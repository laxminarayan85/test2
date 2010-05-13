package com.efi.printsmith.properties;

/**
 * <p>Title: ClassName</p>
 * <p>Description: ???</p>
 * <p>Copyright: Copyright (c) 2000-2001</p>
 * <p>Company: printCafe, Inc.</p>
 * @author unascribed
 * @version 1.0
 */

public abstract class PropertyListener
{

  protected String propertyName = null;

  void setPropertyName(String propertyName)
  {
    this.propertyName = propertyName;
  }

  String getPropertyName()
  {
    return this.propertyName;
  }

  public abstract void propertyChanged(PropertyEvent event);
}