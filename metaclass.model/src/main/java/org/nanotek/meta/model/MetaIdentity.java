package org.nanotek.meta.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.nanotek.MutableIdentity;

import schemacrawler.schema.PrimaryKey;
import schemacrawler.schema.TableConstraintColumn;

public class MetaIdentity implements 
IdBase<MetaIdentity,String> , MutableIdentity<String>{

	private String id;
	
	private String definition;
	
	private String shortName;
	
	private String name;
	
	private List<PkColumn> columns; 
	
	public MetaIdentity() {
		super();
	}

	public MetaIdentity(PrimaryKey key) {
		super();
		prepareMetaIdentity(key);
	}
	
	
	private void prepareMetaIdentity(PrimaryKey key2) {
		Optional.ofNullable(key2)
		.ifPresent(k-> {
			this.definition =k.getDefinition();
			this.shortName = k.getShortName();
			this.name = k.getName();
			prepareColumns(k.getConstrainedColumns());
		});
	}

	private void prepareColumns(List<TableConstraintColumn> columns2) {
		columns = new ArrayList<>();
		Optional.ofNullable(columns2)
		.ifPresent(cs -> {
			cs.stream()
			.forEach(c ->{
				PkColumn column = new PkColumn(c.getName());
				columns.add(column);
			});
		});
		
	}

	public String getDefinition() {
		return definition;
	}

	public void setDefinition(String definition) {
		this.definition = definition;
	}

	public String getShortName() {
		return shortName;
	}

	public void setShortName(String shortName) {
		this.shortName = shortName;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<PkColumn> getColumns() {
		return columns;
	}

	public void setColumns(List<PkColumn> columns) {
		this.columns = columns;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

}
