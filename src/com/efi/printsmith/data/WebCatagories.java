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
	@NamedQuery(name = "WebCatagories.findall", query = "from WebCatagories"),
	@NamedQuery(name = "WebCatagories.byId", query = "select a from WebCatagories a where a.id= :id")
})


@Entity
@Table(name = "webcatagories")
public class WebCatagories extends ModelBase {
	/**
	 * @generated
	 */
	public static final String STATUS = "Status";
	/**
	 * @generated
	 */
	public static final String IMAGE = "Image";
	/**
	 * @generated
	 */
	public static final String PRODUCTS = "Products";
	/**
	 * @generated
	 */
	public static final String PARENT = "Parent";
	/**
	 * @generated
	 */
	public static final String NAME = "Name";

	/**
	 * @generated
	 */
	public WebCatagories() {
		this.created = new Date();
		this.modified = new Date();
	}

 	
	
	/**
	 * @generated
	 */	
 	@Basic
	private String status;
	
	/**
	 * @generated
 	 */
	public String getStatus(){
		return status; 
	}

	
	/**
	 * @generated
	 */	
	public void setStatus(String newVal) {
		this.status = newVal;
	}
 	
	
	/**
	 * @generated
	 */	
    @ManyToOne( cascade = {CascadeType.PERSIST, CascadeType.MERGE} )
	private WebGraphics image;
	
	/**
	 * @generated
 	 */
	public WebGraphics getImage(){
		return image; 
	}

	
	/**
	 * @generated
	 */	
	public void setImage(WebGraphics newVal) {
		this.image = newVal;
	}
 	
	
	/**
	 * @generated
	 */	
    @OneToMany( cascade = {CascadeType.ALL})
    @JoinTable( name = "webcatagories_products")
	private java.util.List<WebProducts> products;
	
	/**
	 * @generated
 	 */
	public java.util.List<WebProducts> getProducts(){
		return products; 
	}

	/**
	 * @generated
	 */	
	public void addProducts(WebProducts obj) {
		if (products == null) {
			products = new java.util.ArrayList<WebProducts>();
		}
		products.add(obj);
	}
	
	/**
	 * @generated
	 */	
	public void setProducts(java.util.List<WebProducts> newVal) {
		this.products = newVal;
	}
 	
	
	/**
	 * @generated
	 */	
    @ManyToOne( cascade = {CascadeType.PERSIST, CascadeType.MERGE} )
	private WebCatagories parent;
	
	/**
	 * @generated
 	 */
	public WebCatagories getParent(){
		return parent; 
	}

	
	/**
	 * @generated
	 */	
	public void setParent(WebCatagories newVal) {
		this.parent = newVal;
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
	@Transient
	@Override
	public Object getProperty(String propertyName) throws UnknownPropertyException {
		if (STATUS.equals(propertyName)) return getStatus();
		if (IMAGE.equals(propertyName)) return getImage();
		if (PRODUCTS.equals(propertyName)) return getProducts();
		if (PARENT.equals(propertyName)) return getParent();
		if (NAME.equals(propertyName)) return getName();
		return super.getProperty(propertyName);
	}
	
	/**
	 * @generated
	 */		
	@SuppressWarnings("unchecked")
	@Override
	public void setProperty(String propertyName, Object newValue) throws PropertyException {
		if (STATUS.equals(propertyName)) setStatus((String)newValue); else
		if (IMAGE.equals(propertyName)) setImage((WebGraphics)newValue); else
		if (PRODUCTS.equals(propertyName)) setProducts((java.util.List<WebProducts>)newValue); else
		if (PARENT.equals(propertyName)) setParent((WebCatagories)newValue); else
		if (NAME.equals(propertyName)) setName((String)newValue); else
		super.setProperty(propertyName, newValue);
	}
	
	/**
	 * @generated
	 */		
	@Transient
	@Override
	public Class<?>[] getPropertyClass(String propertyName) throws UnknownPropertyException {	
		if (STATUS.equals(propertyName)) 
			return new Class<?>[] {String.class};		
		if (IMAGE.equals(propertyName)) 
			return new Class<?>[] {WebGraphics.class};		
		if (PRODUCTS.equals(propertyName)) 
			return new Class<?>[] {java.util.List.class, WebProducts.class};		
		if (PARENT.equals(propertyName)) 
			return new Class<?>[] {WebCatagories.class};		
		if (NAME.equals(propertyName)) 
			return new Class<?>[] {String.class};		
		return super.getPropertyClass(propertyName);
	}
	

	/**
	 * @generated
	 */		
	@Transient
	@Override
	public Class<?> getPropertyOwner(String propertyName) throws UnknownPropertyException {	
		if (STATUS.equals(propertyName)) return WebCatagories.class;
		if (IMAGE.equals(propertyName)) return WebCatagories.class;
		if (PRODUCTS.equals(propertyName)) return WebCatagories.class;
		if (PARENT.equals(propertyName)) return WebCatagories.class;
		if (NAME.equals(propertyName)) return WebCatagories.class;
		return super.getPropertyOwner(propertyName);
	}
	
	/**
	 * @generated
	 */			
	@Override
	public boolean deepEquals(Object obj) {
		if (! super.deepEquals(obj))
			return false;
		WebCatagories objT = (WebCatagories)obj;
		if (! SmartEquals(getStatus(), objT.getStatus()))
			return false;
		if (! SmartEquals(getImage(), objT.getImage()))
			return false;
		if (! SmartEquals(getProducts(), objT.getProducts()))
			return false;
		if (! SmartEquals(getParent(), objT.getParent()))
			return false;
		if (! SmartEquals(getName(), objT.getName()))
			return false;
		return true;
	}			
}