
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
import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.Type;
import org.hibernate.annotations.Where;

/**
 * @generated
 */

 
/**
 * @generated
 */	
@NamedQueries({
  @NamedQuery(name = "PriceListElement.findall", query = "from PriceListElement"),
  @NamedQuery(name = "PriceListElement.byId", query = "select a from PriceListElement a where a.id= :id")
})



/**
 * @generated
 */	
@Entity
@Table(name = "pricelistelement")
@SQLDelete(sql="update pricelistelement set isdeleted='TRUE' where id=?")
@Where(clause="isdeleted <> 'TRUE'")
public class PriceListElement extends ModelBase {
	/**
	 * @generated
	 */
	public static final String QUANTITY = "Quantity";
	/**
	 * @generated
	 */
	public static final String AMOUNT = "Amount";
	/**
	 * @generated
	 */
	public static final String SIDE = "Side";
	/**
	 * @generated
	 */
	public static final String COLOR = "Color";

	/**
   * @generated
   */
  public static final String LASTLINE = "LastLine";

	/**
	 * @generated
	 */
	public PriceListElement() {
    this.created = new Date();
    this.modified = new Date();
    this.isDeleted = false;
  }

 	
	
	@Basic
  private Boolean isDeleted = false;

	public Boolean getIsDeleted() {
    return isDeleted;
  }


	public void setIsDeleted(Boolean isDeleted) {
    this.isDeleted = isDeleted;
  }



	/**
	 * @generated
	 */	
 	@Basic
	private Long quantity;
	
	/**
	 * @generated
 	 */
	public Long getQuantity(){
    return quantity; 
  }

	
	/**
	 * @generated
	 */	
	public void setQuantity(Long newVal) {
    this.quantity = newVal;
  }
	
 	
	
	/**
	 * @generated
	 */	
 	@Basic
	@Column(name="amount", precision=19, scale=4)
	private BigDecimal amount;
	
	/**
	 * @generated
 	 */
	public BigDecimal getAmount(){
    return amount; 
  }

	
	/**
	 * @generated
	 */	
	public void setAmount(BigDecimal newVal) {
    this.amount = newVal;
    this.amount.setScale(4, RoundingMode.HALF_UP);
  }
	
	/**
	 * @generated
	 */	
	public void setAmount(double newVal) {
    this.amount = BigDecimal.valueOf(newVal);
    this.amount.setScale(4, RoundingMode.HALF_UP);
  }
 	
	
	/**
	 * @generated
	 */	
 	@Basic
	private Integer side;
	
	/**
	 * @generated
 	 */
	public Integer getSide(){
    return side; 
  }

	
	/**
	 * @generated
	 */	
	public void setSide(Integer newVal) {
    this.side = newVal;
  }
	
 	
	
	/**
	 * @generated
	 */	
 	@Basic
	private Integer color;
	
	/**
	 * @generated
 	 */
	public Integer getColor(){
    return color; 
  }

	
	/**
	 * @generated
	 */	
	public void setColor(Integer newVal) {
    this.color = newVal;
  }
	
	/**
   * @generated
   */	
 	@Basic
  private Boolean lastLine;

	/**
   * @generated
 	 */
  public Boolean getLastLine(){
    return lastLine; 
  }


	/**
   * @generated
   */	
  public void setLastLine(Boolean newVal) {
    this.lastLine = newVal;
  }


	/**
	 * @generated
	 */		
	@Transient
	@Override
	public Object getProperty(String propertyName) throws UnknownPropertyException {
    if (QUANTITY.equals(propertyName)) return getQuantity();
    if (AMOUNT.equals(propertyName)) return getAmount();
    if (SIDE.equals(propertyName)) return getSide();
    if (COLOR.equals(propertyName)) return getColor();
    if (LASTLINE.equals(propertyName)) return getLastLine();
    return super.getProperty(propertyName);
  }
	
	/**
	 * @generated
	 */		
	@SuppressWarnings("unchecked")
	@Override
	public void setProperty(String propertyName, Object newValue) throws PropertyException {
    if (QUANTITY.equals(propertyName)) setQuantity((Long)newValue); else
    if (AMOUNT.equals(propertyName)) setAmount((BigDecimal)newValue); else
    if (SIDE.equals(propertyName)) setSide((Integer)newValue); else
    if (COLOR.equals(propertyName)) setColor((Integer)newValue); else
    if (LASTLINE.equals(propertyName)) setLastLine((Boolean)newValue); else
    super.setProperty(propertyName, newValue);
  }
	
	/**
	 * @generated
	 */		
	@Transient
	@Override
	public Class<?>[] getPropertyClass(String propertyName) throws UnknownPropertyException {	
    if (QUANTITY.equals(propertyName)) 
      return new Class<?>[] {Long.class};		
    if (AMOUNT.equals(propertyName)) 
      return new Class<?>[] {BigDecimal.class};		
    if (SIDE.equals(propertyName)) 
      return new Class<?>[] {Integer.class};		
    if (COLOR.equals(propertyName)) 
      return new Class<?>[] {Integer.class};		
    if (LASTLINE.equals(propertyName)) 
      return new Class<?>[] {Boolean.class};		
    return super.getPropertyClass(propertyName);
  }
	

	/**
	 * @generated
	 */		
	@Transient
	@Override
	public Class<?> getPropertyOwner(String propertyName) throws UnknownPropertyException {	
    if (QUANTITY.equals(propertyName)) return PriceListElement.class;
    if (AMOUNT.equals(propertyName)) return PriceListElement.class;
    if (SIDE.equals(propertyName)) return PriceListElement.class;
    if (COLOR.equals(propertyName)) return PriceListElement.class;
    if (LASTLINE.equals(propertyName)) return PriceListElement.class;
    return super.getPropertyOwner(propertyName);
  }
	
	/**
	 * @generated
	 */			
	@Override
	public boolean deepEquals(Object obj) {
    if (! super.deepEquals(obj))
      return false;
    PriceListElement objT = (PriceListElement)obj;
    if (! SmartEquals(getQuantity(), objT.getQuantity()))
      return false;
    if (! SmartEquals(getAmount(), objT.getAmount()))
      return false;
    if (! SmartEquals(getSide(), objT.getSide()))
      return false;
    if (! SmartEquals(getColor(), objT.getColor()))
      return false;
    if (! SmartEquals(getLastLine(), objT.getLastLine()))
      return false;
    return true;
  }			
}
