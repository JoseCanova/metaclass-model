package org.nanotek.meta.model;

import java.io.Serializable;

import org.nanotek.meta.util.UUIDStringId;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class PkColumn implements Serializable {

	@Id
	@UUIDStringId
	private String id;
	
	protected String name;

	public PkColumn() {
		super();
	}

	public PkColumn(String name) {
		super();
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}
	
}
