package org.omilab.services.exampleservice.model;

import javax.persistence.*;

@Entity
public class Page {

	@Id
	@GeneratedValue
	private long id;

	@Column
	private String endpoint;

	@Column
	private String content;

	@ManyToOne
	private Instance instance;

	public Page() {
	}

	public Page(final String endpoint, final String content, Instance instance) {
		this.endpoint = endpoint;
		this.content = content;
		this.instance = instance;
	}

	public long getId() {
		return id;
	}

	public void setId(final long id) {
		this.id = id;
	}

	public String getEndpoint() {
		return endpoint;
	}

	public void setEndpoint(final String endpoint) {
		this.endpoint = endpoint;
	}

	public String getContent() {
		return content;
	}

	public void setContent(final String content) {
		this.content = content;
	}

	public Instance getInstance() {
		return instance;
	}

	public void setInstance(final Instance instance) {
		this.instance = instance;
	}
}
