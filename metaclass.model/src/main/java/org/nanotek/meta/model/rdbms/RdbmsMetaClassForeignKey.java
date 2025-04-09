package org.nanotek.meta.model.rdbms;

import java.util.Objects;

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

	@Override
	public int hashCode() {
		return Objects.hash(columnName, joinColumnName, tableName);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		RdbmsMetaClassForeignKey other = (RdbmsMetaClassForeignKey) obj;
		return Objects.equals(columnName, other.columnName) && Objects.equals(joinColumnName, other.joinColumnName)
				&& Objects.equals(tableName, other.tableName);
	}

}
