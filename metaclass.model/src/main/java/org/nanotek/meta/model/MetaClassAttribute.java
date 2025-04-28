package org.nanotek.meta.model;

import org.nanotek.MutableIdentity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class MetaClassAttribute<T extends MetaClassAttribute<T>>
implements IdBase<T,String> , MutableIdentity<String> {

	protected String id;
	
	@JsonProperty("name")
	protected String fieldName;
	
	
	public MetaClassAttribute() {
	}
	

	public String getFieldName() {
		return fieldName;
	}

	public void setFieldName(String fieldName) {
		this.fieldName = fieldName;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}
	
}
