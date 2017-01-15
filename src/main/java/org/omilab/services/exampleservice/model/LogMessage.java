package org.omilab.services.exampleservice.model;

public final class LogMessage {

	private String action;

	private String resource;

	private String sid;

	private String userid;

	private String entity;

	public LogMessage(String userid, String action, String entity, String resource) {
		this.userid = userid;
		this.action = action;
		this.resource = resource;
		this.entity = entity;
	}

	public LogMessage() {
	}

	public String getAction() {
		return action;
	}

	private void setAction(String action) {
		this.action = action;
	}

	public String getResource() {
		return resource;
	}

	private void setResource(String resource) {
		this.resource = resource;
	}

	public String getSid() {
		return sid;
	}

	public void setSid(String sid) {
		this.sid = sid;
	}

	public String getUserid() {
		return userid;
	}

	private void setUserid(String userid) {
		this.userid = userid;
	}

	public String getEntity() {
		return entity;
	}

	private void setEntity(final String entity) {
		this.entity = entity;
	}
}

