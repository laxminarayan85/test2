
package com.efi.printsmith.data;

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
	@NamedQuery(name = "SpecialInstructions.findall", query = "from SpecialInstructions"),
	@NamedQuery(name = "SpecialInstructions.byId", query = "select a from SpecialInstructions a where a.id= :id")
})



/**
 * @generated
 */	
@Entity
@Table(name = "specialinstructions")
public class SpecialInstructions extends ModelBase {
	/**
	 * @generated
	 */
	public static final String INSTRUCTIONS = "Instructions";

	/**
	 * @generated
	 */
	public SpecialInstructions() {
		this.created = new Date();
		this.modified = new Date();
	}

 	
	
	/**
	 * @generated
	 */	
 	@Basic
	private String instructions;
	
	/**
	 * @generated
 	 */
	public String getInstructions(){
		return instructions; 
	}

	
	/**
	 * @generated
	 */	
	public void setInstructions(String newVal) {
		this.instructions = newVal;
	}
	/**
	 * @generated
	 */		
	@Transient
	@Override
	public Object getProperty(String propertyName) throws UnknownPropertyException {
		if (INSTRUCTIONS.equals(propertyName)) return getInstructions();
		return super.getProperty(propertyName);
	}
	
	/**
	 * @generated
	 */		
	@SuppressWarnings("unchecked")
	@Override
	public void setProperty(String propertyName, Object newValue) throws PropertyException {
		if (INSTRUCTIONS.equals(propertyName)) setInstructions((String)newValue); else
		super.setProperty(propertyName, newValue);
	}
	
	/**
	 * @generated
	 */		
	@Transient
	@Override
	public Class<?>[] getPropertyClass(String propertyName) throws UnknownPropertyException {	
		if (INSTRUCTIONS.equals(propertyName)) 
			return new Class<?>[] {String.class};		
		return super.getPropertyClass(propertyName);
	}
	

	/**
	 * @generated
	 */		
	@Transient
	@Override
	public Class<?> getPropertyOwner(String propertyName) throws UnknownPropertyException {	
		if (INSTRUCTIONS.equals(propertyName)) return SpecialInstructions.class;
		return super.getPropertyOwner(propertyName);
	}
	
	/**
	 * @generated
	 */			
	@Override
	public boolean deepEquals(Object obj) {
		if (! super.deepEquals(obj))
			return false;
		SpecialInstructions objT = (SpecialInstructions)obj;
		if (! SmartEquals(getInstructions(), objT.getInstructions()))
			return false;
		return true;
	}			
}