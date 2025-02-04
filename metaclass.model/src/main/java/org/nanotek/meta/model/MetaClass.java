package org.nanotek.meta.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.nanotek.MutableIdentity;
import org.nanotek.meta.util.UUIDStringId;
import org.nanotek.meta.validation.MetaClassDefaultValidationGroup;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.annotation.JsonProperty;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.MappedSuperclass;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Null;
import lombok.AllArgsConstructor;

/**
 * The MetaClass serves as a base class for metadata models, 
 * providing fields and methods to manage the identity, class name, and metadata attributes. 
 * It uses a combination of annotations and generics to facilitate database operations, 
 * JSON serialization, and validation. 
 * The use of Lombok and Jakarta Persistence annotations helps 
 * reduce boilerplate code and manage database relationships effectively.
 * @param <K>
 * @param <T>
 */
@MappedSuperclass
@JsonInclude(value = Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
@AllArgsConstructor
public class MetaClass<K extends MetaClass<K, T> , T extends MetaClassAttribute<?>> 
 implements  IdBase<K,String> , MutableIdentity<String> , IClass {

	private static final long serialVersionUID = -6730971114783577367L;

	@Id
    @UUIDStringId
    @Column(length=36)
	@NotEmpty(groups= {MetaClassDefaultValidationGroup.class})
	private String id;
	
	@JsonProperty("className")
	@NotEmpty(groups= {MetaClassDefaultValidationGroup.class})
	@Column (name="class_name" , length=1000)
	protected String className; 
	
	/*
	 * @JsonIgnore
	 * 
	 * @NotNull(groups= {MetaClassDefaultValidationGroup.class}) protected C
	 * classifier;
	 */
	
	@Null(groups= {MetaClassDefaultValidationGroup.class})
	@OneToOne(cascade = CascadeType.ALL , optional = true , fetch = FetchType.LAZY)
	@JoinTable(
			  name = "metaclass_metaidentity_join", 
			  joinColumns = @JoinColumn(name = "metaclass_id" , referencedColumnName = "id"), 
			  inverseJoinColumns = @JoinColumn(name = "metaidentity_id",referencedColumnName = "id") )
	protected MetaIdentity identity;
	
	@OneToMany(cascade=CascadeType.ALL)
	protected List<T> metaAttributes;
	
	public MetaClass() {
		super();
	}
	
	public MetaClass(@NotEmpty(groups = MetaClassDefaultValidationGroup.class) String className,
			@NotNull(groups = MetaClassDefaultValidationGroup.class) MetaIdentity identity) {
		super();
		this.className = className;
		this.identity = identity;
	}
	
	@Override
	public String getClassName() {
		return className;
	}

	@Override
	public void setClassName(String className) {
		this.className = className;
	}

	public MetaIdentity getIdentity() {
		return identity;
	}

	public void setIdentity(MetaIdentity identity) {
		this.identity = identity;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public List<T> getMetaAttributes() {
		return metaAttributes;
	}

	public boolean  addMetaAttribute(T attr) {
		return  Optional
				.ofNullable(metaAttributes)
				.orElse(metaAttributes = new ArrayList<>())
				.add(attr);
	}
	
	public void setMetaAttributes(List<T> metaAttributes) {
		this.metaAttributes = metaAttributes;
	}
	
}
