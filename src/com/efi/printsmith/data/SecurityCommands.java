
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
  @NamedQuery(name = "SecurityCommands.findall", query = "from SecurityCommands"),
  @NamedQuery(name = "SecurityCommands.byId", query = "select a from SecurityCommands a where a.id= :id")
})



/**
 * @generated
 */	
@Entity
@Table(name = "securitycommands")
public class SecurityCommands extends ModelBase {
	/**
	 * @generated
	 */
	public static final String MENU = "Menu";
	/**
	 * @generated
	 */
	public static final String COMMANDNAME = "CommandName";
	/**
	 * @generated
	 */
	public static final String COMMANDID = "CommandId";

	/**
	 * @generated
	 */
	public SecurityCommands() {
    this.created = new Date();
    this.modified = new Date();
  }

 	
	
	/**
	 * @generated
	 */	
 	@Basic
	private String menu;
	
	/**
	 * @generated
 	 */
	public String getMenu(){
    return menu; 
  }

	
	/**
	 * @generated
	 */	
	public void setMenu(String newVal) {
    this.menu = newVal;
  }
 	
	
	/**
	 * @generated
	 */	
 	@Basic
	private String commandName;
	
	/**
	 * @generated
 	 */
	public String getCommandName(){
    return commandName; 
  }

	
	/**
	 * @generated
	 */	
	public void setCommandName(String newVal) {
    this.commandName = newVal;
  }
 	
	
	/**
	 * @generated
	 */	
 	@Basic
	private String commandId;
	
	/**
	 * @generated
 	 */
	public String getCommandId(){
    return commandId; 
  }

	
	/**
	 * @generated
	 */	
	public void setCommandId(String newVal) {
    this.commandId = newVal;
  }
	/**
	 * @generated
	 */		
	@Transient
	@Override
	public Object getProperty(String propertyName) throws UnknownPropertyException {
    if (MENU.equals(propertyName)) return getMenu();
    if (COMMANDNAME.equals(propertyName)) return getCommandName();
    if (COMMANDID.equals(propertyName)) return getCommandId();
    return super.getProperty(propertyName);
  }
	
	/**
	 * @generated
	 */		
	@SuppressWarnings("unchecked")
	@Override
	public void setProperty(String propertyName, Object newValue) throws PropertyException {
    if (MENU.equals(propertyName)) setMenu((String)newValue); else
    if (COMMANDNAME.equals(propertyName)) setCommandName((String)newValue); else
    if (COMMANDID.equals(propertyName)) setCommandId((String)newValue); else
    super.setProperty(propertyName, newValue);
  }
	
	/**
	 * @generated
	 */		
	@Transient
	@Override
	public Class<?>[] getPropertyClass(String propertyName) throws UnknownPropertyException {	
    if (MENU.equals(propertyName)) 
      return new Class<?>[] {String.class};		
    if (COMMANDNAME.equals(propertyName)) 
      return new Class<?>[] {String.class};		
    if (COMMANDID.equals(propertyName)) 
      return new Class<?>[] {String.class};		
    return super.getPropertyClass(propertyName);
  }
	

	/**
	 * @generated
	 */		
	@Transient
	@Override
	public Class<?> getPropertyOwner(String propertyName) throws UnknownPropertyException {	
    if (MENU.equals(propertyName)) return SecurityCommands.class;
    if (COMMANDNAME.equals(propertyName)) return SecurityCommands.class;
    if (COMMANDID.equals(propertyName)) return SecurityCommands.class;
    return super.getPropertyOwner(propertyName);
  }
	
	/**
	 * @generated
	 */			
	@Override
	public boolean deepEquals(Object obj) {
    if (! super.deepEquals(obj))
      return false;
    SecurityCommands objT = (SecurityCommands)obj;
    if (! SmartEquals(getMenu(), objT.getMenu()))
      return false;
    if (! SmartEquals(getCommandName(), objT.getCommandName()))
      return false;
    if (! SmartEquals(getCommandId(), objT.getCommandId()))
      return false;
    return true;
  }			
}
