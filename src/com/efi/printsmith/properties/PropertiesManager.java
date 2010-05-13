package com.efi.printsmith.properties;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.UnknownHostException;
import java.util.Enumeration;
import java.util.Iterator;
import java.util.Properties;
import java.util.Stack;
import java.util.Vector;

import org.apache.log4j.Category;
import org.apache.log4j.Logger;

import com.efi.printsmith.searchandreplace.VariableExpansion;
import com.efi.printsmith.searchandreplace.VariableMapper;
import com.efi.printsmith.properties.propertiesmanager.PropertiesManagerItem;

/**
 * <p>Title: ClassName</p>
 * <p>Description: ???</p>
 * <p>Copyright: Copyright (c) 2000-2001</p>
 * <p>Company: printCafe, Inc.</p>
 * @author unascribed
 * @version 1.0
 */

public class PropertiesManager implements java.io.Serializable, VariableMapper
{
	private Logger log = Logger.getLogger(PropertiesManager.class);

  public static final String RUNTIME_PROPERTIES_NAME = "runtime";

  private Stack _sets = new Stack();  // Probably could just use vector
  private PropertyTree _listenerTree = new PropertyTree();
  private PropertyTree _propertyCache = null; // The internal property cache
  private String _saveFilename = null;
  private boolean _flushToSystem = false;

  protected PropertySetInterface runtimeProperties = null;

  protected VariableExpansion _variableExpander = new VariableExpansion("{","}");

  public PropertiesManager()
  {
    initRuntimeProperties();
    initSecurityProperties();
    pushPropertiesToCache();
  }

  protected void initRuntimeProperties()
  {
    runtimeProperties = new JavaPropertySet();
    runtimeProperties.setSetName(RUNTIME_PROPERTIES_NAME);
    
     // This puts the runtime entry at index 0 where it should stay
    _sets.addElement(runtimeProperties);

    String hostname = "<undefined>";
    try {
      hostname = java.net.InetAddress.getLocalHost().getHostName();
    }
    catch (UnknownHostException uhex) {
    }
    String canonicalHostname = "<undefined>";
    try {
        canonicalHostname = java.net.InetAddress.getLocalHost().getCanonicalHostName();
    }
    catch (UnknownHostException uhex) {
    }
    runtimeProperties.setProperty("env.hostname",hostname);
    runtimeProperties.setProperty("env.canonicalHostname",canonicalHostname);
    runtimeProperties.setProperty("env.username",System.getProperty("user.name"));
  }

  protected void initSecurityProperties()
  {
	// See TT defect 19008 for info regarding networkaddress.cache.ttl
	java.security.Security.setProperty("networkaddress.cache.ttl", "300");
	log.info("Setting networkaddress.cache.ttl to 300");
  }
  
  public void initPropertiesFromXML(InputStream in)
      throws Exception
  {
	  com.efi.printsmith.properties.propertiesmanager.PropertiesManager managerXML = null;

    managerXML = com.efi.printsmith.properties.propertiesmanager.PropertiesManager.unmarshal(new InputStreamReader(in));

    if (managerXML == null)
      return;

    _saveFilename = managerXML.getSaveFilename();
    _flushToSystem = managerXML.getFlushToSystem();

    Enumeration managerItems = managerXML.enumeratePropertiesManagerItem();
    while (managerItems.hasMoreElements()) {
      PropertiesManagerItem item = (PropertiesManagerItem)managerItems.nextElement();
      if (item.getJavaPropertySet() != null) {
    	  com.efi.printsmith.properties.propertiesmanager.JavaPropertySet javaPropSet = item.getJavaPropertySet();
        String name = javaPropSet.getName();
        boolean quiet = javaPropSet.getQuiet();

        if (log.isInfoEnabled()) {
          log.info("Adding JavaPropertySet: name=\"" + name + "\"");
        }
        if (quiet) {
          try {
            addPropertySet(name,new JavaPropertySet(javaPropSet));
          }
          catch (Exception ex) {
            log.info(ex.getMessage());
          }
        }
        else
          addPropertySet(name,new JavaPropertySet(javaPropSet));
      } else if (item.getXMLPropertySet() != null) {
    	  com.efi.printsmith.properties.propertiesmanager.XMLPropertySet xmlPropSet = item.getXMLPropertySet();
        String name = xmlPropSet.getName();
        if (log.isInfoEnabled()) {
          log.info("Adding XMLPropertySet: name=\"" + name + "\"");
        }

        addPropertySet(name,new XMLPropertySet(xmlPropSet));
      }
      else {
        log.warn("Unrecognized property set type.  Skipping...");
        continue;
      }
    }

    if (_flushToSystem)
      pushPropertiesToSystem();
  }

  public String getSaveFilename()
  {
    return _saveFilename;
  }

  public void setSaveFilename(String filename)
  {
    _saveFilename = filename;
  }

  public boolean getFlushToSystem()
  {
    return _flushToSystem;
  }

  public void setFlushToSystem(boolean flushToSystem)
  {
    _flushToSystem = flushToSystem;
  }

  /**
   * Associates a property listener object with a property.  Each time
   * the property is changed all associated listeners will be triggered.
   * 
   * @param name The name of the property for the listener
   * @param listener The listener to add
   */
  public void addPropertyListener(String name, PropertyListener listener)
  {
    Vector listenerVect = (Vector)_listenerTree.getPropertyValue(name);
    if (listenerVect == null) {
      listenerVect = new Vector();
      _listenerTree.addProperty(name,listenerVect,null);
    }

    listenerVect.add(listener);
    listener.setPropertyName(name);
  }

  private void callPropertyListeners(String name, String oldValue, String newValue)
  {
    Vector listenerVect = (Vector)_listenerTree.getPropertyValue(name);
    if (listenerVect == null)
      return;

    PropertyEvent event = new PropertyEvent(name,oldValue);

    for (int i = 0; i < listenerVect.size(); i++) {
      PropertyListener listener = (PropertyListener)listenerVect.elementAt(i);
      if (log.isDebugEnabled())
        log.debug("Calling PropertyListener \"" + listener.getClass().getName() + "\"");
      listener.propertyChanged(event);
    }
  }

  private void callAllPropertyListeners()
  {
    Enumeration listenerVects = _listenerTree.getAllPropertyValues();
    while (listenerVects.hasMoreElements()) {
      Vector listenerVect = (Vector)listenerVects.nextElement();
      if (listenerVect == null)
        continue;
      for (int i = 0; i < listenerVect.size(); i++) {
        PropertyListener listener = (PropertyListener)listenerVect.elementAt(i);
        if (log.isDebugEnabled())
          log.debug("Calling PropertyListener \"" + listener.getClass().getName() + "\"");
        listener.propertyChanged(new PropertyEvent(listener.getPropertyName(),null));
      }
    }
  }

  public void addPropertySet(String setName, PropertySetInterface properties)
  {
    properties.setSetName(setName);

    _sets.add(properties);

    // TODO: Could optimize to only push the set to the cache (now that pushToCache doesn't clear the cache)
    pushPropertiesToCache();
    if (_flushToSystem)
      pushPropertiesToSystem();
    callAllPropertyListeners();
  }

  public void reloadPropertySet(String setName)
    throws Exception
  {
    PropertySetInterface set = getPropertySet(setName);
    if (set == null)
      return;

    set.reload();
    clearCache();
    pushPropertiesToCache();
    if (_flushToSystem)
      pushPropertiesToSystem();
    callAllPropertyListeners();
  }
  
  public void reloadAllPropertySets()
    throws Exception
  {
    PropertySetInterface[] sets = getPropertySets();
    if (sets == null)
      return;
      
    for (int i = 0; i < sets.length; i++) {
      sets[i].reload();    
    }
    clearCache();
    pushPropertiesToCache();
    if (_flushToSystem)
      pushPropertiesToSystem();
    callAllPropertyListeners();
  }
  
  /**
   * Returns an Iterator containg the subset of property names for properties
   * containing values under then given name.  Example, if the following
   * properties are defined:
   * <li>com.company.set.stuff
   * <li>com.company.set2.stuff2
   * <li>com.company.set2.stuff3
   * and a call was made to getPropertyNames with the parameter "com.company.set2"
   * then the last two items would be returned in the iterator.
   * 
   * @param name The name of the property for which we want all sub-properties
   * @return An iterator containing the names of all properties found
   */
  public Iterator getPropertyNames(String name)
  {
    return _propertyCache.getPropertyNames(name);
  }

  /**
   * Retreives the value of the property with a given name in the given property
   * set.  If not set is specified then the sets are searched in order for the
   * property.  If the property is not found or is set to null then defaultValue
   * is returned.  If doSubstitution is set and a variable is found in the
   * property's value then the variable is evaluated (by doing a recursive
   * getProperty()) and replaced in the property's value before being returned.
   *
   * @param setName The name of the property set in which to look.  If set to null
   * then all property sets are searched.
   * @param name The name of the property
   * @param defaultValue The value to use if the property is not set or is set to
   * null.
   * @param doSubstitution If set then variables will be evaluated and replaced.
   * @return The value of the named property
   */
  public String getProperty(String setName, String name, String defaultValue, boolean doSubstitution)
  {
    String value = defaultValue;

    if (setName != null) {
      int numPropSets = _sets.size();
      for (int i = 0; i < numPropSets; i++) {
        PropertySetInterface set = (PropertySetInterface)_sets.elementAt(i);
        if (setName.equals(set.getSetName())) {
          String setValue = set.getProperty(name);
          if (setValue != null)
            value = setValue;
          break;
        }
      }
    }
    else {
      String cacheValue = (String)_propertyCache.getPropertyValue(name);
      if (cacheValue != null)
        value = cacheValue;
    }
      
    if (doSubstitution) {
      try {
        value = doPropertySubstitution(value);
      }
      catch (Exception reex) {
        log.debug(reex.getMessage(),reex);
      }
    }

    return value;
  }

  String doPropertySubstitution(String input)
      throws Exception
  {
    return _variableExpander.expandVariables(input,this);
  }

  /**
   * Retreives the value of the named property.  If the property is not set or is
   * set to null then defaultValue is returned instead.
   * 
   * @param name The name of the property
   * @param defaultValue The value to use if the property is not set or is set to
   * null.
   * @return The value of the named property.
   */
  public String getProperty(String name, String defaultValue)
  {
    return getProperty(null,name,defaultValue,true);
  }

  /**
   * Retreives the value of the named property.
   * 
   * @param name The name of the property for the requested value.
   * @return The value of then named property.
   */
  public String getProperty(String name)
  {
    return getProperty(null,name,null,true);
  }

  /**
   * @return An array of the currently loaded property sets.
   */
  public PropertySetInterface[] getPropertySets()
  {
    PropertySetInterface[] sets = new PropertySetInterface[_sets.size()];
    for (int i = 0; i < _sets.size(); i++) {
      sets[i] = (PropertySetInterface)_sets.elementAt(i);
    }
    return sets;
  }

  /**
   * @return An array of Strings containing the names of the property sets.
   */
  public String[] getPropertySetNames()
  {
    String[] names = new String[_sets.size()];
    for (int i = 0; i < _sets.size(); i++) {
      names[i] = ((PropertySetInterface)_sets.elementAt(i)).getSetName();
    }
    return names;
  }

  /**
   * Returns the property set of the given name.
   * 
   * @param setName The name of the property set requested.
   * @return The property set matching the given name.  null if a property set is
   * not found.
   */
  public PropertySetInterface getPropertySet(String setName)
  {
    for (int i = 0; i < _sets.size(); i++) {
      PropertySetInterface props = (PropertySetInterface)_sets.elementAt(i);
      if (props == null)
        continue;

      String name = props.getSetName();
      if (((name != null) && (name.equals(setName))) || ((name == null) && (setName == null)))
        return props;
    }

    return null;
  }

  /**
   * Returns the name of the property set for a specific property.  This will be
   * the set from which the property is getting its current value.  In other words,
   * the property may be set in multiple property sets but only one of those sets
   * will be providing the actual value.  The name of that set will be returned.
   * 
   * @param name The name of the property for which we want the set name.
   * @return The name of the set setting the given property.  If the property is
   * not defined then null is returned.
   */
  public String getSetNameForProperty(String name)
  {
    return _propertyCache.getPropertySet(name);
  }

  /**
   * @return An iterator that iterates through all of the property keys that are
   * currently being managed
   */
  public Iterator getPropertyNames()
  {
    return _propertyCache.getAllPropertyNames();
  }

  /**
   * Sets a property to the given value.  The property is actually set in what is
   * called the <i>runtime</i> property set and typically is lost when the system
   * is restarted (unless the property manager is configured to read from a saved
   * property dump.)
   * 
   * @param name The name of the property to set
   * @param value The value to set the property to
   */
  public void setProperty(String name, String value)
  {
    String oldValue = getProperty(name);

    runtimeProperties.setProperty(name,value);

    callPropertyListeners(name,oldValue,value);
    pushPropertiesToCache();
  }

  /**
   * Sets a property to a given value for a given set.
   * 
   * @param setName The name of the set for which the property is being set
   * @param name The name of the property to set
   * @param value The value to set the property to
   */
  public void setProperty(String setName, String name, String value)
  {
    String oldValue = getProperty(setName,name,null,true);

    if (setName == null)
      setName = RUNTIME_PROPERTIES_NAME;

    for (int i = 0; i < _sets.size(); i++) {
      PropertySetInterface props = (PropertySetInterface)_sets.elementAt(i);
      if (setName.equals(props.getSetName())) {
        props.setProperty(name,value);
        break;
      }
    }

    callPropertyListeners(name,oldValue,value);
    pushPropertiesToCache();
    if (this._flushToSystem)
      pushPropertiesToSystem();
  }

  /**
   * Saves all of the flattened properties from the cache to a file with the name
   * given via the setSaveFilename() call.
   * 
   * @throws IOException
   * @throws FileNotFoundException
   * @see setSaveFilename()
   */
  public void saveProperties()
      throws IOException, FileNotFoundException
  {
    savePropertiesToFile(null);
  }

  /**
   * Saves all of the flattened properties from the cache to a file with the name
   * passed.
   * 
   * @param filename The name of the file to save the properties to.
   * @throws IOException
   * @throws FileNotFoundException
   */
  public void savePropertiesToFile(String filename)
      throws IOException, FileNotFoundException
  {
    if (filename == null)
      filename = _saveFilename;

    writePropertiesToStream(new FileOutputStream(filename));

    if (log.isInfoEnabled())
      log.info("Wrote properties to file \"" + filename + "\"");
  }

  /**
   * Writes the flattened properties from the cache to the output stream <b>out</b>
   *
   * @param out The stream to write the flattened properties too
   * @throws IOException
   */
  public void writePropertiesToStream(OutputStream out)
      throws IOException
  {
    Iterator names = getPropertyNames();
    Properties tempProps = new Properties();
    while (names.hasNext()) {
      String name = (String)names.next();
      String value = (String)getProperty(name,null);
      if (value == null)
        continue;

      tempProps.setProperty(name,value);
    }

    tempProps.store(out,"Flattened printcafe properties");
  }

  /**
   * This method will dump all properties currently in the cache to System (i.e.
   * to be accessed via System.getProperty().)  If flushToSystem is set to true
   * then this process is done automatically in certain cases.  Note that pushing
   * properties to system is purely additive.  If any properties are removed from
   * the proeprty manager or set to null they will not be removed from the System
   * properties.
   */
  public void pushPropertiesToSystem()
  {
    Iterator names = getPropertyNames();
    while (names.hasNext()) {
      String name = (String)names.next();
      String value = (String)getProperty(name,null);
      if (value == null)
        continue;

      System.setProperty(name,value);
    }

    log.info("Properties pushed to System");
  }

  /**
   * Reinitalizes the cache.  After this call the cache will be empty and all
   * getProperty() calls will return null.  To repopulate the cache
   * pushPropertiesToCache() should be called.
   * 
   * @see pushPropertiesToCache()
   */
  public void clearCache()
  {
    _propertyCache = new PropertyTree();
  }
  
  /**
   * This method re-adds all properties from the property sets to the cache.
   * This cache is used when using
   * the getProperty() calls.  Properties are not pulled out of the property sets
   * directly.  Any changes made to a property set won't be available until
   * pushPropertiesToCache is called.  However, some calls, like addPropertySet(),
   * will call pushPropertiesToCache().  Note that unlike reloadAllPropertySets(),
   * this does not cause property sets to be reevaluated if necessary (some
   * property sets, like the file based ones, need to be reloaded if any changes
   * are made to the files.)
   * 
   * @see reloadAllPropertySets()
   */
  public void pushPropertiesToCache()
  {
    if (_propertyCache == null)
      _propertyCache = new PropertyTree();
      
    for (int i = (_sets.size()-1); i >= 0; i--) {
      PropertySetInterface props = (PropertySetInterface)_sets.elementAt(i);
      String setName = props.getSetName();
      Enumeration currentKeys = props.getPropertyNames();
      while (currentKeys.hasMoreElements()) {
        String propertyName = (String)currentKeys.nextElement();
        String propertyValue = (String)props.getProperty(propertyName);
        _propertyCache.addProperty(propertyName,propertyValue,setName);
      }
    }
  }
  
  /**
   * Get the value of a property.  If the property is null or is not set then
   * defaultValue is returned instead.  If the property is not a number (i.e.
   * can't be parsed as an int) then PropertyFormatException is thrown.
   * 
   * @param name The name of the property to retreive
   * @param defaultValue The value to return if the named property is not set
   * @return The value of the property
   * @throws PropertyFormatException
   */
  public int getIntProperty(String name, int defaultValue)
      throws PropertyFormatException
  {
    String prop = getProperty(name);
    if (prop == null)
      return defaultValue;

    try {
      return Integer.parseInt(prop);
    }
    catch (NumberFormatException ex) {
      throw new PropertyFormatException();
    }
  }

  /**
   * A convience method for setting a runtime property of type int.  It will be
   * stored in the property manager as a String (as all properties are.)
   * 
   * @param name The name of the property to set
   * @param value The integer value to set the property to
   */
  public void setIntProperty(String name, int value)
  {
    setProperty(name,Integer.toString(value));
  }

  /**
   * Get the value of a property.  If the property is null or is not set then
   * defaultValue is returned instead.  If the property is not a number (i.e.
   * can't be parsed as an double) then PropertyFormatException is thrown.
   * 
   * @param name The name of the property to retrieve
   * @param defaultValue The value to return if the named property is not set
   * @return The value of the property
   * @throws PropertyFormatException
   */
  public double getDoubleProperty(String name, double defaultValue)
    throws PropertyFormatException
  {
    String prop = getProperty(name);
    if (prop == null)
      return defaultValue;

    try {
      return Double.parseDouble(prop);
    }
    catch (NumberFormatException ex) {
      throw new PropertyFormatException();
    }
  }

  /**
   * A convience method for setting a runtime property of type double.  It will be
   * stored in the property manager as a String (as all properties are.)
   * 
   * @param name The name of the property to set
   * @param value The integer value to set the property to
   */
  public void setDoubleProperty(String name, double value)
  {
    setProperty(name,Double.toString(value));
  }

  /**
   * Get the value of a property.  If the property is null or is not set then
   * defaultValue is returned instead.  If the property is not a number (i.e.
   * can't be parsed as an long) then PropertyFormatException is thrown.
   * 
   * @param name The name of the property to retrieve
   * @param defaultValue The value to return if the named property is not set
   * @return The value of the property
   * @throws PropertyFormatException
   */
  public long getLongPropety(String name, long defaultValue)
      throws PropertyFormatException
  {
    String prop = getProperty(name);
    if (prop == null)
      return defaultValue;

    try {
      return Long.parseLong(prop);
    }
    catch (NumberFormatException ex) {
      throw new PropertyFormatException();
    }
  }

  /**
   * A convience method for setting a runtime property of type long.  It will be
   * stored in the property manager as a String (as all properties are.)
   * 
   * @param name The name of the property to set
   * @param value The integer value to set the property to
   */
  public void setLongProperty(String name, long value)
  {
    setProperty(name,Long.toString(value));
  }

  /**
   * Get the value of a property.  If the property is null or is not set then
   * defaultValue is returned instead.  If the property is set to one of "true",
   * "yes", "t", or "y" then the method returns true, otherwise it returns false.
   * 
   * @param name The name of the property to retreive
   * @param defaultValue The value to return if the named property is not set
   * @return The value of the property
   */
  public boolean getBooleanProperty(String name, boolean defaultValue)
  {
    String prop = getProperty(name);
    if (prop == null)
      return defaultValue;

    return (prop.equalsIgnoreCase("true") ||
            prop.equalsIgnoreCase("yes") ||
            prop.equalsIgnoreCase("t") ||
            prop.equalsIgnoreCase("y"));
  }

  /**
   * A convience method for setting a runtime property of type boolean.  It will be
   * stored in the property manager as either "true" or "false".
   * 
   * @param name The name of the property to set
   * @param value The integer value to set the property to
   */
  public void setBooleanProperty(String name, boolean value)
  {
    setProperty(name,(value ? "true" : "false"));
  }

  public String getVariableValue(String variable)
  {
    return getProperty(variable);
  }
}

