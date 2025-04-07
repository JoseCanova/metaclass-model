package org.nanotek.meta.model.rdbms;

import java.util.Optional;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

public class RdbmsMetaClassForeignKey {

	
	@JsonProperty("tableName")
	private String tableName;
	
	@JsonProperty("columnName")
	private String columnName;
	
	@JsonProperty("joinColumnName")
	private String joinColumnName;
	
	public RdbmsMetaClassForeignKey() {
	}

	public RdbmsMetaClassForeignKey(String tableName, String columnName, String joinColumnName) {
		super();
		this.tableName = tableName;
		this.columnName = columnName;
		this.joinColumnName = joinColumnName;
	}

	public String getTableName() {
		return tableName;
	}

	public String getColumnName() {
		return columnName;
	}

	public String getJoinColumnName() {
		return joinColumnName;
	}

	@Override
	public String toString() {
		return "RdbmsMetaClassForeignKey [tableName=" + tableName + ", columnName=" + columnName + ", joinColumnName="
				+ joinColumnName + "]";
	}

}
