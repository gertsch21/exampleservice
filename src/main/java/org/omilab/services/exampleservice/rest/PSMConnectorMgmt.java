package org.omilab.services.exampleservice.rest;

import org.omilab.services.exampleservice.model.GenericRequest;
import org.omilab.services.exampleservice.service.InstanceMgmtService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;

@Component
@Path("/instanceMgmt")
public final class PSMConnectorMgmt {

	private final InstanceMgmtService instances;

	@Autowired
	public PSMConnectorMgmt(InstanceMgmtService instances) {
		this.instances = instances;
	}

	@POST
	@Produces("application/json")
	@Consumes("application/json")
	public String manageInstance(final GenericRequest gr, final @Context HttpServletRequest servletRequest) {
		if(gr.getParams().get("mode").equals("create")) {
			String id = instances.createInstance(servletRequest.getRemoteAddr()).toString();
			return id;
		}
		if(gr.getParams().get("mode").equals("delete")) {
			if(instances.checkAccess(servletRequest.getRemoteAddr(),Long.parseLong(gr.getParams().get("instanceid"))))
				return Boolean.toString(instances.deleteInstance(Long.parseLong(gr.getParams().get("instanceid"))));
			else
				return "Not allowed!";
		}
		return "";
	}

}
