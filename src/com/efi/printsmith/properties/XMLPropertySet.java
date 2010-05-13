package com.efi.printsmith.properties;

import java.io.File;
import java.io.InputStream;
import java.util.Enumeration;
import java.util.Hashtable;
import java.util.Properties;

import org.apache.log4j.Category;
import org.apache.log4j.Logger;
import org.dom4j.Document;
import org.dom4j.Node;
import org.dom4j.io.SAXReader;

import com.efi.printsmith.properties.propertiesmanager.XMLPropertySetItem;
import com.efi.printsmith.properties.propertiesmanager.XPathMapping;

/**
 * <p>Title: ClassName</p>
 * <p>Description: ???</p>
 * <p>Copyright: Copyright (c) 2000-2001</p>
 * <p>Company: printCafe, Inc.</p>
 * @author unascribed
 * @version 1.0
 */

public class XMLPropertySet extends PropertySetInterface
{
	private Logger log = Logger.getLogger(XMLPropertySet.class);

  protected Properties _props = null;  // Should eventually be used for caching

  private Hashtable _xPathMap = new Hashtable();
  private Document _doc = null;

  protected File file = null;
  protected String resourceName = null;
  protected InputStream in = null;

  public XMLPropertySet(com.efi.printsmith.properties.propertiesmanager.XMLPropertySet xmlPropSet)
      throws Exception
  {
    String filename = xmlPropSet.getXmlFilename();
    if (filename != null)
      file = new File(filename);

    resourceName = xmlPropSet.getResourceName();

    init();

    Enumeration mapItems = xmlPropSet.enumerateXMLPropertySetItem();
    while (mapItems.hasMoreElements()) {
      XMLPropertySetItem mapItem = (XMLPropertySetItem)mapItems.nextElement();
      XPathMapping mapping = mapItem.getXPathMapping();
      if (log.isDebugEnabled())
        log.debug("Adding xml property map: " + mapping.getProperty() + " => " + mapping.getContent());
      addPropertyMap(mapping.getProperty(),mapping.getContent());
    }
  }

  public XMLPropertySet(File xmlFile)
      throws Exception
  {
    file = xmlFile;
    init();
  }

  public XMLPropertySet(InputStream in)
      throws Exception
  {
    this.in = in;
    init();
  }

  protected void init()
      throws Exception
  {
    _doc = null;

    if ((file == null) && (resourceName == null)) {
      throw new Exception("XMLPropertySet: Neither filename nor resourceName have been set");
    }

    StringBuffer description = new StringBuffer();
    description.append("XMLPropertySet: ");

    if (file != null) {
      description.append("file=");
      description.append(file.getAbsolutePath());
      SAXReader reader = new SAXReader();
      _doc = reader.read(file);
    }
    else if (resourceName != null) {
      description.append("resource=");
      description.append(resourceName);
      InputStream resourceIn = Thread.currentThread().getContextClassLoader().getResourceAsStream(resourceName);
      SAXReader reader = new SAXReader();
      _doc = reader.read(resourceIn);
    }
    else if (in != null) {
      description.append("inputstream");
      in.reset();
      SAXReader reader = new SAXReader();
      _doc = reader.read(in);
    }

    setDescription(description.toString());
  }

  public void reload()
      throws Exception
  {
    init();
  }

  public String getProperty(String key)
  {
    if (_doc == null)
      return null;

    String xPath = (String)_xPathMap.get(key);
    if (xPath == null)
      return null;

    Node node = _doc.selectSingleNode(xPath);

    if (node == null)
      return null;

    return node.getText();
  }

  public void setProperty(String key, String value)
  {
    throw new java.lang.UnsupportedOperationException("Method XMLPropertySet.setProperty() not supported.");
  }

  public String removeProperty(String key)
  {
    throw new java.lang.UnsupportedOperationException("Method XMLPropertySet.setProperty() not supported.");
  }

  public void addPropertyMap(String property, String xpath)
  {
    _xPathMap.put(property,xpath);
  }

  public Enumeration getPropertyNames()
  {
    return _xPathMap.keys();
  }
}