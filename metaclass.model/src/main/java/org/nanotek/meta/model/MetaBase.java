package org.nanotek.meta.model;

import java.io.Serializable;

import org.nanotek.MutableIdentity;

public class MetaBase<K extends MetaBase<K,ID>,ID extends Serializable> implements  IdBase<K,ID> , MutableIdentity<ID>{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1994647285984999840L;
	
	ID id;
	
	
	public MetaBase() {
	}

	public MetaBase(ID id) {
		this.id = id;
	}
	@Override
	public ID getId() {
		return id;
	}

	@Override
	public void setId(ID t) {
		this.id = t;
	}
	
	
}