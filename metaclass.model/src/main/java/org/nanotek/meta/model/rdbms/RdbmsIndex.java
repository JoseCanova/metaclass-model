package org.nanotek.meta.model.rdbms;

import java.util.List;
import java.util.stream.Collectors;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.annotation.JsonProperty;

import schemacrawler.schema.Index;
import schemacrawler.schema.IndexColumn;

@JsonInclude(value = Include.NON_NULL)
public class RdbmsIndex{

	@JsonProperty(value = "name")
	protected  String name;
	
	@JsonProperty(value = "fullName")
	protected  String fullName;
	
	@JsonProperty(value = "columnNames")
	protected  List<String> columnNames;
	
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

}
