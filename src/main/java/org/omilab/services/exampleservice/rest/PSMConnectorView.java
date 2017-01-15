package org.omilab.services.exampleservice.rest;

import org.omilab.services.exampleservice.model.GenericServiceContent;
import org.omilab.services.exampleservice.model.Post;
import org.omilab.services.exampleservice.model.Topic;
import org.omilab.services.exampleservice.repo.PageRepository;
import org.omilab.services.exampleservice.service.CommentMgmtService;
import org.omilab.services.exampleservice.service.InstanceMgmtService;
import org.omilab.services.exampleservice.service.PostMgmtService;
import org.omilab.services.exampleservice.service.TopicMgmtService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.util.Assert;

import javax.servlet.http.HttpServletRequest;
import javax.ws.rs.*;
import javax.ws.rs.core.Context;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.*;
import java.io.*;

import freemarker.template.Configuration;
import freemarker.template.Template;
import freemarker.template.TemplateException;
import freemarker.template.TemplateExceptionHandler;


@Component
@Path("/view")
public final class PSMConnectorView {

	//freemarker
	private final Configuration cfg;
	private Template temp;

	private final PageRepository pageRepo;

	private final InstanceMgmtService instanceMgmtService;

	private final TopicMgmtService topics;

	private final PostMgmtService posts;

	private final CommentMgmtService comments;

	@Autowired
	public PSMConnectorView(PageRepository pageRepo, InstanceMgmtService instanceMgmtService, TopicMgmtService topics, PostMgmtService posts, CommentMgmtService comments) {
		this.pageRepo = pageRepo;
		this.instanceMgmtService = instanceMgmtService;
		this.topics = topics;
		this.posts = posts;
		this.comments = comments;

		this.cfg = new Configuration(Configuration.VERSION_2_3_25);

		try{
			this.cfg.setDirectoryForTemplateLoading(new File("/home/omilab/IdeaProjects/ExampleService/freemarker"));
			this.cfg.setDefaultEncoding("UTF-8");
			this.cfg.setTemplateExceptionHandler(TemplateExceptionHandler.RETHROW_HANDLER);
			this.cfg.setLogTemplateExceptions(false);
			this.temp = this.cfg.getTemplate("template.ftlh");
		}catch(IOException e){
			System.err.println("Verzeichnis freemarker not found");
		}

	}

	@POST
	@Path("/{instanceid}/{endpoint}")
	@Produces("application/json")
	@Consumes("application/json")
	public GenericServiceContent processRequest(final @PathParam("instanceid") Long instanceid,
												final @PathParam("endpoint") String endpoint,
												final @Context HttpServletRequest servletRequest) {




		if(!instanceMgmtService.checkAccess(servletRequest.getRemoteAddr(), instanceid))
			return new GenericServiceContent("Not allowed!");


		Map<String, Object> input = new HashMap<String, Object>();
		Set<Post> allePosts = posts.getPosts();
		Set<Topic> alleTopics = topics.getTopics();
		input.put("posts", allePosts);
		input.put("topics",alleTopics);
		Writer out = new StringWriter();
		try {
			temp.process(input, out);
		} catch (TemplateException e) {
			System.err.println("Template exception");
		} catch (IOException e) {
			System.err.println("Template IO Exception");
		}

		return new GenericServiceContent(out.toString(), new HashMap<String,String>());
	}



}