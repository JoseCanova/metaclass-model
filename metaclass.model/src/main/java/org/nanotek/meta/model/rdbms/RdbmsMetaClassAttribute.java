package org.nanotek.meta.model.rdbms;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

import org.nanotek.meta.model.MetaClassAttribute;

import com.fasterxml.jackson.annotation.JsonProperty;

public class RdbmsMetaClassAttribute 
extends MetaClassAttribute<RdbmsMetaClassAttribute> implements Serializable {

	@JsonProperty("isId")
	protected boolean isPartOfId;
	@JsonProperty("clazz")
	protected String clazz;
//	protected Class<?> clazz;
	@JsonProperty("columnName")
	protected String columnName;
	@JsonProperty("length")
	protected String length;
	@JsonProperty("required")
	protected boolean required;
	@JsonProperty("sqlType")
	protected String sqlType;
	@JsonProperty("attributes")
	protected transient Map<String, Object> attributes;
	@JsonProperty("isPartOfIndex")
	protected boolean partOfIndex;
	@JsonProperty("isGenerated")
	protected boolean generated;
	@JsonProperty("isPartOfForeignKey")
	protected boolean partOfForeignKey;
	@JsonProperty("scale")
	protected Integer scale;
	
	private List<String> idAliases;
	
	public RdbmsMetaClassAttribute() {
		super();
	}

	public String getColumnName() {
		return columnName;
	}

	public void setColumnName(String columnName) {
		this.columnName = columnName;
	}

	public void setClazz(String clazz) {
		this.clazz = clazz;
	}

	public String getClazz(){
		return this.clazz;
	}
	
	public String getSqlType() {
		return sqlType;
	}

	
	public void setSqlType(String string) {
		this.sqlType = string;
	}

	
	public String getLength() {
		return length;
	}

	
	public void setLength(String length) {
		this.length = length;
	}

	
	public boolean isRequired() {
		return required;
	}

	
	public void setRequired(boolean required) {
		this.required = required;
	}

	
	public void setAttributes(Map<String, Object> attributes) {
		this.attributes = attributes;
	}

	
	public Map<String, Object> getAttributes() {
		return attributes;
	}

	
	public List<String> getIdAliases() {
		return idAliases;
	}

	
	public void setIdAliases(List<String> idAliases) {
		this.idAliases = idAliases;
	}

	public boolean isPartOfIndex() {
		return partOfIndex;
	}

	public void setPartOfIndex(boolean partOfIndex) {
		this.partOfIndex = partOfIndex;
	}
	
	public boolean isGenerated() {
		return generated;
	}

	public void setGenerated(boolean generated) {
		this.generated = generated;
	}
	
	public boolean isPartOfForeignKey() {
		return partOfForeignKey;
	}

	public void setPartOfForeignKey(boolean partOfForeignKey) {
		this.partOfForeignKey = partOfForeignKey;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public boolean isPartOfId() {
		return isPartOfId;
	}

	public void setPartOfId(boolean isPartOfId) {
		this.isPartOfId = isPartOfId;
	}

	public Integer getScale() {
		return scale;
	}

	public void setScale(Integer scale) {
		this.scale = scale;
	}
	
}
