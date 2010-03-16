package com.efi.printsmith.data;

import java.util.Date;
import java.util.List;

import com.efi.printsmith.data.*;
import com.efi.printsmith.data.enums.*;
import com.efi.printsmith.exceptions.*;

import javax.persistence.*;

import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CollectionOfElements;
import org.hibernate.annotations.FetchMode;
import org.hibernate.annotations.IndexColumn;
import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;
import org.hibernate.annotations.Type;

/**
 * @generated
 */

 
/**
 * @generated
 */	
@NamedQueries({
	@NamedQuery(name = "WebCatalogs.findall", query = "from WebCatalogs"),
	@NamedQuery(name = "WebCatalogs.byId", query = "select a from WebCatalogs a where a.id= :id")
})


@Entity
@Table(name = "webcatalogs")
public class WebCatalogs extends ModelBase {
	/**
	 * @generated
	 */
	public static final String ROLEID = "RoleId";
	/**
	 * @generated
	 */
	public static final String STATUS = "Status";
	/**
	 * @generated
	 */
	public static final String NAME = "Name";
	/**
	 * @generated
	 */
	public static final String DESCRIPTION = "Description";
	/**
	 * @generated
	 */
	public static final String PATH = "Path";
	/**
	 * @generated
	 */
	public static final String CATAGORIES = "Catagories";

	/**
	 * @generated
	 */
	public WebCatalogs() {
		this.created = new Date();
		this.modified = new Date();
	}

 	
	
	/**
	 * @generated
	 */	
 	@Basic
	private Integer roleId;
	
	/**
	 * @generated
 	 */
	public Integer getRoleId(){
		return roleId; 
	}

	
	/**
	 * @generated
	 */	
	public void setRoleId(Integer newVal) {
		this.roleId = newVal;
	}
 	
	
	/**
	 * @generated
	 */	
    @ManyToOne( cascade = {CascadeType.PERSIST, CascadeType.MERGE} )
	private WebStatus status;
	
	/**
	 * @generated
 	 */
	public WebStatus getStatus(){
		return status; 
	}

	
	/**
	 * @generated
	 */	
	public void setStatus(WebStatus newVal) {
		this.status = newVal;
	}
 	
	
	/**
	 * @generated
	 */	
 	@Basic
	private String name;
	
	/**
	 * @generated
 	 */
	public String getName(){
		return name; 
	}

	
	/**
	 * @generated
	 */	
	public void setName(String newVal) {
		this.name = newVal;
	}
 	
	
	/**
	 * @generated
	 */	
 	@Basic
	private String description;
	
	/**
	 * @generated
 	 */
	public String getDescription(){
		return description; 
	}

	
	/**
	 * @generated
	 */	
	public void setDescription(String newVal) {
		this.description = newVal;
	}
 	
	
	/**
	 * @generated
	 */	
 	@Basic
	private String path;
	
	/**
	 * @generated
 	 */
	public String getPath(){
		return path; 
	}

	
	/**
	 * @generated
	 */	
	public void setPath(String newVal) {
		this.path = newVal;
	}
 	
	
	/**
	 * @generated
	 */	
    @OneToMany( cascade = {CascadeType.ALL})
    @JoinTable( name = "webcatalogs_catagories")
	private java.util.List<WebCatagories> catagories;
	
	/**
	 * @generated
 	 */
	public java.util.List<WebCatagories> getCatagories(){
		return catagories; 
	}

	/**
	 * @generated
	 */	
	public void addCatagories(WebCatagories obj) {
		if (catagories == null) {
			catagories = new java.util.ArrayList<WebCatagories>();
		}
		catagories.add(obj);
	}
	
	/**
	 * @generated
	 */	
	public void setCatagories(java.util.List<WebCatagories> newVal) {
		this.catagories = newVal;
	}
	/**
	 * @generated
	 */		
	@Transient
	@Override
	public Object getProperty(String propertyName) throws UnknownPropertyException {
		if (ROLEID.equals(propertyName)) return getRoleId();
		if (STATUS.equals(propertyName)) return getStatus();
		if (NAME.equals(propertyName)) return getName();
		if (DESCRIPTION.equals(propertyName)) return getDescription();
		if (PATH.equals(propertyName)) return getPath();
		if (CATAGORIES.equals(propertyName)) return getCatagories();
		return super.getProperty(propertyName);
	}
	
	/**
	 * @generated
	 */		
	@SuppressWarnings("unchecked")
	@Override
	public void setProperty(String propertyName, Object newValue) throws PropertyException {
		if (ROLEID.equals(propertyName)) setRoleId((Integer)newValue); else
		if (STATUS.equals(propertyName)) setStatus((WebStatus)newValue); else
		if (NAME.equals(propertyName)) setName((String)newValue); else
		if (DESCRIPTION.equals(propertyName)) setDescription((String)newValue); else
		if (PATH.equals(propertyName)) setPath((String)newValue); else
		if (CATAGORIES.equals(propertyName)) setCatagories((java.util.List<WebCatagories>)newValue); else
		super.setProperty(propertyName, newValue);
	}
	
	/**
	 * @generated
	 */		
	@Transient
	@Override
	public Class<?>[] getPropertyClass(String propertyName) throws UnknownPropertyException {	
		if (ROLEID.equals(propertyName)) 
			return new Class<?>[] {Integer.class};		
		if (STATUS.equals(propertyName)) 
			return new Class<?>[] {WebStatus.class};		
		if (NAME.equals(propertyName)) 
			return new Class<?>[] {String.class};		
		if (DESCRIPTION.equals(propertyName)) 
			return new Class<?>[] {String.class};		
		if (PATH.equals(propertyName)) 
			return new Class<?>[] {String.class};		
		if (CATAGORIES.equals(propertyName)) 
			return new Class<?>[] {java.util.List.class, WebCatagories.class};		
		return super.getPropertyClass(propertyName);
	}
	

	/**
	 * @generated
	 */		
	@Transient
	@Override
	public Class<?> getPropertyOwner(String propertyName) throws UnknownPropertyException {	
		if (ROLEID.equals(propertyName)) return WebCatalogs.class;
		if (STATUS.equals(propertyName)) return WebCatalogs.class;
		if (NAME.equals(propertyName)) return WebCatalogs.class;
		if (DESCRIPTION.equals(propertyName)) return WebCatalogs.class;
		if (PATH.equals(propertyName)) return WebCatalogs.class;
		if (CATAGORIES.equals(propertyName)) return WebCatalogs.class;
		return super.getPropertyOwner(propertyName);
	}
	
	/**
	 * @generated
	 */			
	@Override
	public boolean deepEquals(Object obj) {
		if (! super.deepEquals(obj))
			return false;
		WebCatalogs objT = (WebCatalogs)obj;
		if (! SmartEquals(getRoleId(), objT.getRoleId()))
			return false;
		if (! SmartEquals(getStatus(), objT.getStatus()))
			return false;
		if (! SmartEquals(getName(), objT.getName()))
			return false;
		if (! SmartEquals(getDescription(), objT.getDescription()))
			return false;
		if (! SmartEquals(getPath(), objT.getPath()))
			return false;
		if (! SmartEquals(getCatagories(), objT.getCatagories()))
			return false;
		return true;
	}			
}