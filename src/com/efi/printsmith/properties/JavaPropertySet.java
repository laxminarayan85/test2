package com.efi.printsmith.properties;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.util.Enumeration;
import java.util.Properties;

import org.apache.log4j.Category;
import org.apache.log4j.Logger;

import com.efi.printsmith.service.JDFIntegrationService;


/**
 * <p>Title: ClassName</p>
 * <p>Description: ???</p>
 * <p>Copyright: Copyright (c) 2000-2001</p>
 * <p>Company: printCafe, Inc.</p>
 * @author unascribed
 * @version 1.0
 */

public class JavaPropertySet extends PropertySetInterface
{
	private Logger log = Logger.getLogger(JavaPropertySet.class);

  protected Properties _props = null;

  protected InputStream in = null;
  protected File file = null;
  protected String resourceName = null;

  public JavaPropertySet()
  {
    try {
      init();
    }
    catch (Exception ex) {
      log.warn(ex.getMessage(),ex);
    }
  }

  public JavaPropertySet(com.efi.printsmith.properties.propertiesmanager.JavaPropertySet propSet)
      throws Exception
  {
    String filename = propSet.getPropertiesFilename();
    if (filename != null)
      file = new File(filename);

    resourceName = propSet.getResourceName();

    init();
  }

  public JavaPropertySet(InputStream in)
      throws Exception
  {
    this.in = in;
    init();
  }

  public JavaPropertySet(File file)
      throws Exception
  {
    this.file = file;
    init();
  }

  public JavaPropertySet(String resourceName)
      throws Exception
  {
    this.resourceName = resourceName;
    init();
  }

  protected void init()
      throws Exception
  {
    InputStream inStream = null;

    StringBuffer description = new StringBuffer();
    description.append("JavaPropertySet: ");

    if (in != null) {
      in.reset();
      inStream = in;
      description.append("inputstream");
    }
    else if (file != null) {
      inStream = new FileInputStream(file);
      description.append("file=");
      description.append(file.getAbsolutePath());
    }
    else if (resourceName != null) {
      inStream = Thread.currentThread().getContextClassLoader().getResourceAsStream(resourceName);
      description.append("resource=");
      description.append(resourceName);
    }
    else {
      description.append("plain");
    }
    setDescription(description.toString());

    _props = new Properties();
    if (inStream != null)
      _props.load(inStream);
  }

  public void reload()
      throws Exception
  {
    init();
  }

  public String getProperty(String key)
  {
    return _props.getProperty(key);
  }

  public void setProperty(String key, String value)
  {
    _props.setProperty(key,value);
  }

  public String removeProperty(String key)
  {
    return (String)_props.remove(key);
  }

  public Enumeration getPropertyNames()
  {
    return _props.keys();
  }

  public Properties getJavaProperties()
  {
    return _props;
  }
}