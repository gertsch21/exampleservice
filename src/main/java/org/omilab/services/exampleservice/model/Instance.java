package org.omilab.services.exampleservice.model;

import javax.persistence.*;
import java.util.List;
import java.util.Set;

@Entity
public class Instance {

	@Id
	@GeneratedValue
	private long id;

	@Column
	private String psmip;

	@OneToMany(mappedBy = "instance", fetch = FetchType.EAGER, cascade = CascadeType.REMOVE)
	private List<Page> page;

	public Instance() {
	}

	public Instance(final String psmip) {
		this.psmip = psmip;
	}

	public long getId() {
		return id;
	}

	public void setId(final long id) {
		this.id = id;
	}

	public String getPsmip() {
		return psmip;
	}

	public void setPsmip(final String psmip) {
		this.psmip = psmip;
	}

	public List<Page> getPage() {
		return page;
	}

	public void setPage(final List<Page> page) {
		this.page = page;
	}
}
