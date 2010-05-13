package com.efi.printsmith.properties;

/**
 * <p>Title: ClassName</p>
 * <p>Description: ???</p>
 * <p>Copyright: Copyright (c) 2000-2001</p>
 * <p>Company: printCafe, Inc.</p>
 * @author unascribed
 * @version 1.0
 */


public class PropertiesHelper
{
  static private PropertiesManager _manager = null;

  static public void init(String resource)
      throws Exception
  {
    _manager = new PropertiesManager();
    _manager.initPropertiesFromXML(Thread.currentThread().getContextClassLoader().getResourceAsStream(resource));
  }

  static public String getProperty(String name, String defaultVal)
  {
    try {
      return _manager.getProperty(name,defaultVal);
    }
    catch (Exception ex) {
      return defaultVal;
    }
  }

  static public int getIntProperty(String name, int defaultVal)
  {
    try {
      return _manager.getIntProperty(name,defaultVal);
    }
    catch (Exception ex) {
      return defaultVal;
    }
  }

  static public double getDoubleProperty(String name, double defaultVal)
  {
    try {
      return _manager.getDoubleProperty(name,defaultVal);
    }
    catch (Exception ex) {
      return defaultVal;
    }
  }

  static public long getLongProperty(String name, long defaultVal)
  {
    try {
      return _manager.getLongPropety(name,defaultVal);
    }
    catch (Exception ex) {
      return defaultVal;
    }
  }

  static public boolean getBooleanProperty(String name, boolean defaultVal)
  {
    try {
      return _manager.getBooleanProperty(name, defaultVal);
    }
    catch (Exception ex) {
      return defaultVal;
    }
  }

  static public void addPropertyListener(String name, PropertyListener listener)
  {
    _manager.addPropertyListener(name,listener);
  }

  static public PropertiesManager getPropertiesManager()
  {
    return _manager;
  }

}