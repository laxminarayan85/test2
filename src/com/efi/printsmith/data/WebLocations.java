
package com.efi.printsmith.data;

import java.math.BigDecimal;
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
  @NamedQuery(name = "WebLocations.findall", query = "from WebLocations"),
  @NamedQuery(name = "WebLocations.byId", query = "select a from WebLocations a where a.id= :id")
})



/**
 * @generated
 */	
@Entity
@Table(name = "weblocations")
public class WebLocations extends ModelBase {
	/**
   * @generated
   */
  public static final String PRODUCTIONLOCATIONS = "ProductionLocations";
	/**
   * @generated
   */
  public static final String WEBTRANSLATION = "WebTranslation";
	/**
	 * @generated
	 */
	public WebLocations() {
    this.created = new Date();
    this.modified = new Date();
  }

 	
	
	/**
   * @generated
   */	
    @ManyToOne()
  private ProductionLocations productionLocations;
	/**
   * @generated
 	 */
  public ProductionLocations getProductionLocations(){
    return productionLocations; 
  }


	/**
   * @generated
   */	
  public void setProductionLocations(ProductionLocations newVal) {
    this.productionLocations = newVal;
  }



	/**
   * @generated
   */	
    @ManyToOne()
  private WebTranslation webTranslation;
	/**
   * @generated
 	 */
  public WebTranslation getWebTranslation(){
    return webTranslation; 
  }


	/**
   * @generated
   */	
  public void setWebTranslation(WebTranslation newVal) {
    this.webTranslation = newVal;
  }



	/**
	 * @generated
	 */		
	@Transient
	@Override
	public Object getProperty(String propertyName) throws UnknownPropertyException {
    if (PRODUCTIONLOCATIONS.equals(propertyName)) return getProductionLocations();
    if (WEBTRANSLATION.equals(propertyName)) return getWebTranslation();
    return super.getProperty(propertyName);
  }
	
	/**
	 * @generated
	 */		
	@SuppressWarnings("unchecked")
	@Override
	public void setProperty(String propertyName, Object newValue) throws PropertyException {
    if (PRODUCTIONLOCATIONS.equals(propertyName)) setProductionLocations((ProductionLocations)newValue); else
    if (WEBTRANSLATION.equals(propertyName)) setWebTranslation((WebTranslation)newValue); else
    super.setProperty(propertyName, newValue);
  }
	
	/**
	 * @generated
	 */		
	@Transient
	@Override
	public Class<?>[] getPropertyClass(String propertyName) throws UnknownPropertyException {	
    if (PRODUCTIONLOCATIONS.equals(propertyName)) 
      return new Class<?>[] {ProductionLocations.class};		
    if (WEBTRANSLATION.equals(propertyName)) 
      return new Class<?>[] {WebTranslation.class};		
    return super.getPropertyClass(propertyName);
  }
	

	/**
	 * @generated
	 */		
	@Transient
	@Override
	public Class<?> getPropertyOwner(String propertyName) throws UnknownPropertyException {	
    if (PRODUCTIONLOCATIONS.equals(propertyName)) return WebLocations.class;
    if (WEBTRANSLATION.equals(propertyName)) return WebLocations.class;
    return super.getPropertyOwner(propertyName);
  }
	
	/**
	 * @generated
	 */			
	@Override
	public boolean deepEquals(Object obj) {
    if (! super.deepEquals(obj))
      return false;
    WebLocations objT = (WebLocations)obj;
    if (! SmartEquals(getProductionLocations(), objT.getProductionLocations()))
      return false;
    if (! SmartEquals(getWebTranslation(), objT.getWebTranslation()))
      return false;
    return true;
  }			
}
