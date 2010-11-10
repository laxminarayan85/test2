
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
  @NamedQuery(name = "Tape.findall", query = "from Tape"),
  @NamedQuery(name = "Tape.byId", query = "select a from Tape a where a.id= :id")
})



/**
 * @generated
 */	
@Entity
@Table(name = "tape")
@SQLDelete(sql="update tape set isdeleted='TRUE' where id=?")
@Where(clause="isdeleted <> 'TRUE'")
public class Tape extends ModelBase {
	/**
   * @generated
   */
  public static final String BATCHES = "Batches";
	/**
	 * @generated
	 */
	public Tape() {
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
    @OneToMany(  cascade = {CascadeType.ALL})
    @Where(clause="isdeleted <> 'TRUE'")
    @JoinTable( name = "tape_batches")
  private java.util.List<TapeBatch> batches;

	/**
   * @generated
 	 */
  public java.util.List<TapeBatch> getBatches(){
    return batches; 
  }


	/**
   * @generated
   */	
  public void addBatches(TapeBatch obj) {
    if (batches == null) {
      batches = new java.util.ArrayList<TapeBatch>();
    }
    batches.add(obj);
  }


	/**
   * @generated
   */	
  public void setBatches(java.util.List<TapeBatch> newVal) {
    this.batches = newVal;
  }



	/**
	 * @generated
	 */		
	@Transient
	@Override
	public Object getProperty(String propertyName) throws UnknownPropertyException {
    if (BATCHES.equals(propertyName)) return getBatches();
    return super.getProperty(propertyName);
  }
	
	/**
	 * @generated
	 */		
	@SuppressWarnings("unchecked")
	@Override
	public void setProperty(String propertyName, Object newValue) throws PropertyException {
    if (BATCHES.equals(propertyName)) setBatches((java.util.List<TapeBatch>)newValue); else
    super.setProperty(propertyName, newValue);
  }
	
	/**
	 * @generated
	 */		
	@Transient
	@Override
	public Class<?>[] getPropertyClass(String propertyName) throws UnknownPropertyException {	
    if (BATCHES.equals(propertyName)) 
      return new Class<?>[] {java.util.List.class, TapeBatch.class};		
    return super.getPropertyClass(propertyName);
  }
	

	/**
	 * @generated
	 */		
	@Transient
	@Override
	public Class<?> getPropertyOwner(String propertyName) throws UnknownPropertyException {	
    if (BATCHES.equals(propertyName)) return Tape.class;
    return super.getPropertyOwner(propertyName);
  }
	
	/**
	 * @generated
	 */			
	@Override
	public boolean deepEquals(Object obj) {
    if (! super.deepEquals(obj))
      return false;
    Tape objT = (Tape)obj;
    if (! SmartEquals(getBatches(), objT.getBatches()))
      return false;
    return true;
  }			
}
