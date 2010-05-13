package com.efi.printsmith.properties;

import java.util.Enumeration;

/**
 * <p>Title: ClassName</p>
 * <p>Description: ???</p>
 * <p>Copyright: Copyright (c) 2000-2001</p>
 * <p>Company: printCafe, Inc.</p>
 * @author unascribed
 * @version 1.0
 */

public abstract class PropertySetInterface
{
  protected String setName = null;
  protected String description = "not defined";

  abstract public void reload() throws Exception;
  abstract public String getProperty(String key);
  abstract public void setProperty(String key, String val);
  abstract public String removeProperty(String key);
  abstract public Enumeration getPropertyNames();

  public String getSetName()
  {
    return setName;
  }

  public void setSetName(String name)
  {
    setName = name;
  }

  public String getDescription()
  {
    return description;
  }

  public void setDescription(String description)
  {
    this.description = description;
  }
}