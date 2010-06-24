
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
  @NamedQuery(name = "WebProducts.findall", query = "from WebProducts"),
  @NamedQuery(name = "WebProducts.byId", query = "select a from WebProducts a where a.id= :id")
})



/**
 * @generated
 */	
@Entity
@Table(name = "webproducts")
public class WebProducts extends ModelBase {
	/**
	 * @generated
	 */
	public static final String NAME = "Name";
	/**
	 * @generated
	 */
	public static final String STATUS = "Status";
	/**
	 * @generated
	 */
	public static final String SKU = "Sku";
	/**
	 * @generated
	 */
	public static final String THUMBNAIL = "Thumbnail";
	/**
	 * @generated
	 */
	public static final String DETAILS = "Details";
	/**
	 * @generated
	 */
	public static final String GLOBALPRODUCT = "GlobalProduct";
	/**
	 * @generated
	 */
	public static final String CHECKOUTTYPE = "CheckoutType";
	/**
	 * @generated
	 */
	public static final String ALLOWUSERENTEREDQTY = "AllowUserEnteredQty";
	/**
	 * @generated
	 */
	public static final String DESCRIPTION = "Description";
	/**
	 * @generated
	 */
	public static final String CALCULATEPRICES = "CalculatePrices";
	/**
	 * @generated
	 */
	public static final String QUESTIONS = "Questions";

	/**
	 * @generated
	 */
	public WebProducts() {
    this.created = new Date();
    this.modified = new Date();
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
    @ManyToOne()
	private JobBase sku;
	
	/**
	 * @generated
 	 */
	public JobBase getSku(){
    return sku; 
  }

	
	/**
	 * @generated
	 */	
	public void setSku(JobBase newVal) {
    this.sku = newVal;
  }
 	
	
	/**
	 * @generated
	 */	
    @ManyToOne()
	private WebGraphics thumbnail;
	
	/**
	 * @generated
 	 */
	public WebGraphics getThumbnail(){
    return thumbnail; 
  }

	
	/**
	 * @generated
	 */	
	public void setThumbnail(WebGraphics newVal) {
    this.thumbnail = newVal;
  }
 	
	
	/**
	 * @generated
	 */	
    @ManyToOne()
	private WebGraphics details;
	
	/**
	 * @generated
 	 */
	public WebGraphics getDetails(){
    return details; 
  }

	
	/**
	 * @generated
	 */	
	public void setDetails(WebGraphics newVal) {
    this.details = newVal;
  }
 	
	
	/**
	 * @generated
	 */	
 	@Basic
	private Boolean globalProduct;
	
	/**
	 * @generated
 	 */
	public Boolean getGlobalProduct(){
    return globalProduct; 
  }

	
	/**
	 * @generated
	 */	
	public void setGlobalProduct(Boolean newVal) {
    this.globalProduct = newVal;
  }
 	
	
	/**
	 * @generated
	 */	
    @ManyToOne()
	private WebCheckoutTypes checkoutType;
	
	/**
	 * @generated
 	 */
	public WebCheckoutTypes getCheckoutType(){
    return checkoutType; 
  }

	
	/**
	 * @generated
	 */	
	public void setCheckoutType(WebCheckoutTypes newVal) {
    this.checkoutType = newVal;
  }
 	
	
	/**
	 * @generated
	 */	
 	@Basic
	private Boolean allowUserEnteredQty;
	
	/**
	 * @generated
 	 */
	public Boolean getAllowUserEnteredQty(){
    return allowUserEnteredQty; 
  }

	
	/**
	 * @generated
	 */	
	public void setAllowUserEnteredQty(Boolean newVal) {
    this.allowUserEnteredQty = newVal;
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
    @ManyToOne()
	private PreferencesPricingMethod calculatePrices;
	
	/**
	 * @generated
 	 */
	public PreferencesPricingMethod getCalculatePrices(){
    return calculatePrices; 
  }

	
	/**
	 * @generated
	 */	
	public void setCalculatePrices(PreferencesPricingMethod newVal) {
    this.calculatePrices = newVal;
  }
 	
	
	/**
	 * @generated
	 */	
    @OneToMany()
    @IndexColumn(name="questionswebproducts")
    @JoinTable( name = "webproducts_questions")
	private java.util.List<WebQuestions> questions;
	
	/**
	 * @generated
 	 */
	public java.util.List<WebQuestions> getQuestions(){
    return questions; 
  }

	/**
	 * @generated
	 */	
	public void addQuestions(WebQuestions obj) {
    if (questions == null) {
      questions = new java.util.ArrayList<WebQuestions>();
    }
    questions.add(obj);
  }
	
	/**
	 * @generated
	 */	
	public void setQuestions(java.util.List<WebQuestions> newVal) {
    this.questions = newVal;
  }
	/**
	 * @generated
	 */		
	@Transient
	@Override
	public Object getProperty(String propertyName) throws UnknownPropertyException {
    if (NAME.equals(propertyName)) return getName();
    if (STATUS.equals(propertyName)) return getStatus();
    if (SKU.equals(propertyName)) return getSku();
    if (THUMBNAIL.equals(propertyName)) return getThumbnail();
    if (DETAILS.equals(propertyName)) return getDetails();
    if (GLOBALPRODUCT.equals(propertyName)) return getGlobalProduct();
    if (CHECKOUTTYPE.equals(propertyName)) return getCheckoutType();
    if (ALLOWUSERENTEREDQTY.equals(propertyName)) return getAllowUserEnteredQty();
    if (DESCRIPTION.equals(propertyName)) return getDescription();
    if (CALCULATEPRICES.equals(propertyName)) return getCalculatePrices();
    if (QUESTIONS.equals(propertyName)) return getQuestions();
    return super.getProperty(propertyName);
  }
	
	/**
	 * @generated
	 */		
	@SuppressWarnings("unchecked")
	@Override
	public void setProperty(String propertyName, Object newValue) throws PropertyException {
    if (NAME.equals(propertyName)) setName((String)newValue); else
    if (STATUS.equals(propertyName)) setStatus((String)newValue); else
    if (SKU.equals(propertyName)) setSku((JobBase)newValue); else
    if (THUMBNAIL.equals(propertyName)) setThumbnail((WebGraphics)newValue); else
    if (DETAILS.equals(propertyName)) setDetails((WebGraphics)newValue); else
    if (GLOBALPRODUCT.equals(propertyName)) setGlobalProduct((Boolean)newValue); else
    if (CHECKOUTTYPE.equals(propertyName)) setCheckoutType((WebCheckoutTypes)newValue); else
    if (ALLOWUSERENTEREDQTY.equals(propertyName)) setAllowUserEnteredQty((Boolean)newValue); else
    if (DESCRIPTION.equals(propertyName)) setDescription((String)newValue); else
    if (CALCULATEPRICES.equals(propertyName)) setCalculatePrices((PreferencesPricingMethod)newValue); else
    if (QUESTIONS.equals(propertyName)) setQuestions((java.util.List<WebQuestions>)newValue); else
    super.setProperty(propertyName, newValue);
  }
	
	/**
	 * @generated
	 */		
	@Transient
	@Override
	public Class<?>[] getPropertyClass(String propertyName) throws UnknownPropertyException {	
    if (NAME.equals(propertyName)) 
      return new Class<?>[] {String.class};		
    if (STATUS.equals(propertyName)) 
      return new Class<?>[] {String.class};		
    if (SKU.equals(propertyName)) 
      return new Class<?>[] {JobBase.class};		
    if (THUMBNAIL.equals(propertyName)) 
      return new Class<?>[] {WebGraphics.class};		
    if (DETAILS.equals(propertyName)) 
      return new Class<?>[] {WebGraphics.class};		
    if (GLOBALPRODUCT.equals(propertyName)) 
      return new Class<?>[] {Boolean.class};		
    if (CHECKOUTTYPE.equals(propertyName)) 
      return new Class<?>[] {WebCheckoutTypes.class};		
    if (ALLOWUSERENTEREDQTY.equals(propertyName)) 
      return new Class<?>[] {Boolean.class};		
    if (DESCRIPTION.equals(propertyName)) 
      return new Class<?>[] {String.class};		
    if (CALCULATEPRICES.equals(propertyName)) 
      return new Class<?>[] {PreferencesPricingMethod.class};		
    if (QUESTIONS.equals(propertyName)) 
      return new Class<?>[] {java.util.List.class, WebQuestions.class};		
    return super.getPropertyClass(propertyName);
  }
	

	/**
	 * @generated
	 */		
	@Transient
	@Override
	public Class<?> getPropertyOwner(String propertyName) throws UnknownPropertyException {	
    if (NAME.equals(propertyName)) return WebProducts.class;
    if (STATUS.equals(propertyName)) return WebProducts.class;
    if (SKU.equals(propertyName)) return WebProducts.class;
    if (THUMBNAIL.equals(propertyName)) return WebProducts.class;
    if (DETAILS.equals(propertyName)) return WebProducts.class;
    if (GLOBALPRODUCT.equals(propertyName)) return WebProducts.class;
    if (CHECKOUTTYPE.equals(propertyName)) return WebProducts.class;
    if (ALLOWUSERENTEREDQTY.equals(propertyName)) return WebProducts.class;
    if (DESCRIPTION.equals(propertyName)) return WebProducts.class;
    if (CALCULATEPRICES.equals(propertyName)) return WebProducts.class;
    if (QUESTIONS.equals(propertyName)) return WebProducts.class;
    return super.getPropertyOwner(propertyName);
  }
	
	/**
	 * @generated
	 */			
	@Override
	public boolean deepEquals(Object obj) {
    if (! super.deepEquals(obj))
      return false;
    WebProducts objT = (WebProducts)obj;
    if (! SmartEquals(getName(), objT.getName()))
      return false;
    if (! SmartEquals(getStatus(), objT.getStatus()))
      return false;
    if (! SmartEquals(getSku(), objT.getSku()))
      return false;
    if (! SmartEquals(getThumbnail(), objT.getThumbnail()))
      return false;
    if (! SmartEquals(getDetails(), objT.getDetails()))
      return false;
    if (! SmartEquals(getGlobalProduct(), objT.getGlobalProduct()))
      return false;
    if (! SmartEquals(getCheckoutType(), objT.getCheckoutType()))
      return false;
    if (! SmartEquals(getAllowUserEnteredQty(), objT.getAllowUserEnteredQty()))
      return false;
    if (! SmartEquals(getDescription(), objT.getDescription()))
      return false;
    if (! SmartEquals(getCalculatePrices(), objT.getCalculatePrices()))
      return false;
    if (! SmartEquals(getQuestions(), objT.getQuestions()))
      return false;
    return true;
  }			
}
