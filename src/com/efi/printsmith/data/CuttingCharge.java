
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
  @NamedQuery(name = "CuttingCharge.findall", query = "from CuttingCharge"),
  @NamedQuery(name = "CuttingCharge.byId", query = "select a from CuttingCharge a where a.id= :id")
})



/**
 * @generated
 */	
@Entity
@Table(name = "cuttingcharge")
public class CuttingCharge extends Charge {
	/**
	 * @generated
	 */
	public static final String CUTS = "Cuts";

	/**
	 * @generated
	 */
	public CuttingCharge() {
    this.created = new Date();
    this.modified = new Date();
  }

 	
	
	/**
	 * @generated
	 */	
 	@Basic
	private Integer cuts;
	
	/**
	 * @generated
 	 */
	public Integer getCuts(){
    return cuts; 
  }

	
	/**
	 * @generated
	 */	
	public void setCuts(Integer newVal) {
    this.cuts = newVal;
  }
	
	/**
	 * @generated
	 */		
	@Transient
	@Override
	public Object getProperty(String propertyName) throws UnknownPropertyException {
    if (CUTS.equals(propertyName)) return getCuts();
    return super.getProperty(propertyName);
  }
	
	/**
	 * @generated
	 */		
	@SuppressWarnings("unchecked")
	@Override
	public void setProperty(String propertyName, Object newValue) throws PropertyException {
    if (CUTS.equals(propertyName)) setCuts((Integer)newValue); else
    super.setProperty(propertyName, newValue);
  }
	
	/**
	 * @generated
	 */		
	@Transient
	@Override
	public Class<?>[] getPropertyClass(String propertyName) throws UnknownPropertyException {	
    if (CUTS.equals(propertyName)) 
      return new Class<?>[] {Integer.class};		
    return super.getPropertyClass(propertyName);
  }
	

	/**
	 * @generated
	 */		
	@Transient
	@Override
	public Class<?> getPropertyOwner(String propertyName) throws UnknownPropertyException {	
    if (CUTS.equals(propertyName)) return CuttingCharge.class;
    return super.getPropertyOwner(propertyName);
  }
	
	/**
	 * @generated
	 */			
	@Override
	public boolean deepEquals(Object obj) {
    if (! super.deepEquals(obj))
      return false;
    CuttingCharge objT = (CuttingCharge)obj;
    if (! SmartEquals(getCuts(), objT.getCuts()))
      return false;
    return true;
  }			
}
