
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
  @NamedQuery(name = "InvoiceTemplate.findall", query = "from InvoiceTemplate"),
  @NamedQuery(name = "InvoiceTemplate.byId", query = "select a from InvoiceTemplate a where a.id= :id")
})



/**
 * @generated
 */	
@Entity
@Table(name = "invoicetemplate")
public class InvoiceTemplate extends InvoiceBase {
	/**
	 * @generated
	 */
	public static final String TEMPLATENAME = "TemplateName";

	/**
	 * @generated
	 */
	public InvoiceTemplate() {
    this.created = new Date();
    this.modified = new Date();
  }

 	
	
	/**
	 * @generated
	 */	
 	@Basic
	private String templateName;
	
	/**
	 * @generated
 	 */
	public String getTemplateName(){
    return templateName; 
  }

	
	/**
	 * @generated
	 */	
	public void setTemplateName(String newVal) {
    this.templateName = newVal;
  }
	
	/**
	 * @generated
	 */		
	@Transient
	@Override
	public Object getProperty(String propertyName) throws UnknownPropertyException {
    if (TEMPLATENAME.equals(propertyName)) return getTemplateName();
    return super.getProperty(propertyName);
  }
	
	/**
	 * @generated
	 */		
	@SuppressWarnings("unchecked")
	@Override
	public void setProperty(String propertyName, Object newValue) throws PropertyException {
    if (TEMPLATENAME.equals(propertyName)) setTemplateName((String)newValue); else
    super.setProperty(propertyName, newValue);
  }
	
	/**
	 * @generated
	 */		
	@Transient
	@Override
	public Class<?>[] getPropertyClass(String propertyName) throws UnknownPropertyException {	
    if (TEMPLATENAME.equals(propertyName)) 
      return new Class<?>[] {String.class};		
    return super.getPropertyClass(propertyName);
  }
	

	/**
	 * @generated
	 */		
	@Transient
	@Override
	public Class<?> getPropertyOwner(String propertyName) throws UnknownPropertyException {	
    if (TEMPLATENAME.equals(propertyName)) return InvoiceTemplate.class;
    return super.getPropertyOwner(propertyName);
  }
	
	/**
	 * @generated
	 */			
	@Override
	public boolean deepEquals(Object obj) {
    if (! super.deepEquals(obj))
      return false;
    InvoiceTemplate objT = (InvoiceTemplate)obj;
    if (! SmartEquals(getTemplateName(), objT.getTemplateName()))
      return false;
    return true;
  }			
}
