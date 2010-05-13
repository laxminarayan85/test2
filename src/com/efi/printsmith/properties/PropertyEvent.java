package com.efi.printsmith.properties;

/**
 * <p>Title: ClassName</p>
 * <p>Description: ???</p>
 * <p>Copyright: Copyright (c) 2000-2001</p>
 * <p>Company: printCafe, Inc.</p>
 * @author unascribed
 * @version 1.0
 */

public class PropertyEvent
{

  private String _name = null;
  private String _oldValue = null;

  public PropertyEvent(String name, String oldValue)
  {
    _name = name;
    _oldValue = oldValue;
  }

  public String getName()
  {
    return _name;
  }

  public String getOldValue()
  {
    return _oldValue;
  }
  
  public String getNewValue()
  {
      return PropertiesHelper.getProperty(_name,null);
  }
}