package org.nanotek.meta.model.rdbms;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonInclude(value = Include.NON_NULL)
public class RdbmsIndex{

	@JsonProperty(value = "name")
	protected  String name;
	
	@JsonProperty(value = "fullName")
	protected  String fullName;
	
	@JsonProperty(value = "columnNames")
	protected  List<String> columnNames;
	
	@JsonProperty(value = "isUnique")
	protected Boolean isUnique = false;

	
	public RdbmsIndex() {
	}

	public RdbmsIndex(String name, String fullName, List<String> columnNames) {
		super();
		this.name = name;
		this.fullName = fullName;
		this.columnNames = columnNames;
	}

	public String getFullName() {
		return fullName;
	}

	public List<String> getColumnNames() {
		return columnNames;
	}

	@Override
	public String toString() {
		return "RdbmsIndex [name=" + name + ", fullName=" + fullName + ", columnNames=" + columnNames + "]";
	}

	public Boolean getIsUnique() {
		return isUnique;
	}

	public void setIsUnique(Boolean isUnique) {
		this.isUnique = isUnique;
	}

}
