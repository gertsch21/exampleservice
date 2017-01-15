package org.omilab.services.exampleservice.rest;

import freemarker.template.Configuration;
import freemarker.template.Template;
import freemarker.template.TemplateExceptionHandler;
import org.omilab.services.exampleservice.model.GenericRequest;
import org.omilab.services.exampleservice.model.GenericServiceContent;
import org.omilab.services.exampleservice.service.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import java.io.File;
import java.io.IOException;

@Component
@Path("/admin")
public final class PSMConnectorAdmin {

	//freemarker
	private final Configuration cfg;
	private Template temp;

	private static final Logger logger = LoggerFactory.getLogger(PSMConnectorAdmin.class);

	private final AdminService admin;

	private final InstanceMgmtService instances;

	private final PostMgmtService posts;

	private final CommentMgmtService comments;

	private final TopicMgmtService topics;

	private final Environment env;

	@Autowired
	public PSMConnectorAdmin(AdminService admin, InstanceMgmtService instances, Environment env, PostMgmtService posts, CommentMgmtService comments, TopicMgmtService topics) {
		this.admin = admin;
		this.instances = instances;
		this.env = env;
		this.posts = posts;
		this.comments = comments;
		this.topics = topics;

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
	public GenericServiceContent processAdmin(final GenericRequest request,
											  final @PathParam("instanceid") Long instanceid,
											  final @PathParam("endpoint") String endpoint,
											  final @Context HttpServletRequest servletRequest) {

		if(!instances.checkAccess(servletRequest.getRemoteAddr(), instanceid)) {
			logger.error("API call to instance with invalid IP detected. Enable debug log for more information...");
			logger.debug("Request IP: " + servletRequest.getRemoteAddr() + " Instanceid: " + instanceid);
			return new GenericServiceContent("Not allowed!");
		}

		if(request.getParams().get("subject") != null && request.getParams().get("text") != null)
			posts.createPost(Long.valueOf(1), request.getParams().get("subject"), request.getParams().get("text"),request.getUsername());



		final StringBuilder sb = new StringBuilder();
		sb.append("<div class=\"panel panel-default\"><div class=\"panel-body\">");

		sb.append("<form method=\"POST\" action=\"\">\n" +
				"  Subject: <br>\n" +
				"  <textarea name=\"subject\" cols=\"50\"></textarea><br><br>\n"
				);

		sb.append(
				"  Text:<br>\n" +
				"  <textarea name=\"text\" cols=\"100\"></textarea><br><br>\n" +
				"  <input type=\"submit\">\n" +
				"</form>"
				);

		sb.append("</div></div>");

		return new GenericServiceContent(sb.toString());
	}

}
