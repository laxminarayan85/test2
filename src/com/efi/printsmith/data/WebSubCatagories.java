
package com.efi.printsmith.data;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Date;
import java.util.List;

import com.efi.printsmith.data.*;
import com.efi.printsmith.data.enums.*;
import com.efi.printsmith.exceptions.*;

import javax.persistence.*;

import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CollectionOfElements;
import org.hibernate.annotations.Fetch;
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
  @NamedQuery(name = "WebSubCatagories.findall", query = "from WebSubCatagories"),
  @NamedQuery(name = "WebSubCatagories.byId", query = "select a from WebSubCatagories a where a.id= :id")
})



/**
 * @generated
 */	
@Entity
@Table(name = "websubcatagories")
public class WebSubCatagories extends WebCatagories {
	/**
	 * @generated
	 */
	public static final String PRODUCTS = "Products";

	/**
	 * @generated
	 */
	public WebSubCatagories() {
    this.created = new Date();
    this.modified = new Date();
  }

 	
	
	/**
	 * @generated
	 */	
    @OneToMany()
    @JoinTable( name = "websubcatagories_products")
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
	@Transient
	@Override
	public Object getProperty(String propertyName) throws UnknownPropertyException {
    if (PRODUCTS.equals(propertyName)) return getProducts();
    return super.getProperty(propertyName);
  }
	
	/**
	 * @generated
	 */		
	@SuppressWarnings("unchecked")
	@Override
	public void setProperty(String propertyName, Object newValue) throws PropertyException {
    if (PRODUCTS.equals(propertyName)) setProducts((java.util.List<WebProducts>)newValue); else
    super.setProperty(propertyName, newValue);
  }
	
	/**
	 * @generated
	 */		
	@Transient
	@Override
	public Class<?>[] getPropertyClass(String propertyName) throws UnknownPropertyException {	
    if (PRODUCTS.equals(propertyName)) 
      return new Class<?>[] {java.util.List.class, WebProducts.class};		
    return super.getPropertyClass(propertyName);
  }
	

	/**
	 * @generated
	 */		
	@Transient
	@Override
	public Class<?> getPropertyOwner(String propertyName) throws UnknownPropertyException {	
    if (PRODUCTS.equals(propertyName)) return WebSubCatagories.class;
    return super.getPropertyOwner(propertyName);
  }
	
	/**
	 * @generated
	 */			
	@Override
	public boolean deepEquals(Object obj) {
    if (! super.deepEquals(obj))
      return false;
    WebSubCatagories objT = (WebSubCatagories)obj;
    if (! SmartEquals(getProducts(), objT.getProducts()))
      return false;
    return true;
  }			
}
