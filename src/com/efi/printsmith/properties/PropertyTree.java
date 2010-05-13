package com.efi.printsmith.properties;

import java.util.Enumeration;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.StringTokenizer;
import java.util.TreeSet;
import java.util.Vector;

/**
 * <p>Title: ClassName</p>
 * <p>Description: ???</p>
 * <p>Copyright: Copyright (c) 2000-2001</p>
 * <p>Company: printCafe, Inc.</p>
 * @author unascribed
 * @version 1.0
 */

public class PropertyTree
{

  private static String PropertyDelimiter = ".";

  private static class Node
  {
    private String _name = null;
    private String _fullName = null;
    private Object _value = null;
    private String _set = null;
    private Hashtable _children = null;

    private void getAllValuesHelper(Vector vect)
    {
      if (_value != null)
        vect.addElement(_value);

      if (_children != null) {
        Iterator values = _children.values().iterator();
        while (values.hasNext()) {
          Node node = (Node)values.next();
          node.getAllValuesHelper(vect);
        }
      }
    }

    public Vector getAllValues()
    {
      Vector tempVect = new Vector();
      getAllValuesHelper(tempVect);
      return tempVect;
    }

    private void getAllChildrenHelper(Vector vect, String set)
    {
      if ((_value != null) && ((set == null) || (set.equals(_set))))
        vect.addElement(this);
      
      if (_children != null) {
        Iterator values = _children.values().iterator();
        while (values.hasNext()) {
          Node node = (Node)values.next();
          node.getAllChildrenHelper(vect,set);
        }
      }
    }
    
    public Vector getAllChildren(String set)
    {
      Vector tempVect = new Vector();
      getAllChildrenHelper(tempVect,set);
      return tempVect;
    }
    
    public Node findNode(String name)
    {
      if ((_name != null) && (_name.equals(name)))
        return this;

      if (_children != null) {
        Iterator values = _children.values().iterator();
        while (values.hasNext()) {
          Node node = (Node)values.next();
          Node newNode = node.findNode(name);
          if (newNode != null)
            return newNode;
        }
      }

      return null;
    }
  } // End of class Node

  private Node _root = new Node();

  public void addProperty(String name, Object value, String set)
  {
    if (name == null)
      return;

    StringTokenizer tokenizer = new StringTokenizer(name, PropertyDelimiter);
    Node curNode = _root;
    StringBuffer curPropertyPath = new StringBuffer();
    while (tokenizer.hasMoreTokens()) {
      if (curNode._children == null) {
        curNode._children = new Hashtable();
      }

      String token = tokenizer.nextToken();
      
      if (curPropertyPath.length() != 0)
        curPropertyPath.append(PropertyDelimiter);
      curPropertyPath.append(token);
      
      Node newNode = (Node)curNode._children.get(token);
      if (newNode == null) {
        newNode = new Node();
        newNode._name = token;
        newNode._fullName = curPropertyPath.toString();
        curNode._children.put(token, newNode);
      }
      curNode = newNode;
    }
    curNode._value = value;
    curNode._set = set;
  }

  Node getNode(String name)
  {
    if (name == null)
      return null;

    StringTokenizer tokenizer = new StringTokenizer(name, PropertyDelimiter);
    Node curNode = _root;
    while (tokenizer.hasMoreTokens()) {
      if (curNode == null)
        return null;
      String token = tokenizer.nextToken();
      if (curNode._children != null)
        curNode = (Node)curNode._children.get(token);
      else
        curNode = null;
    }

    if (curNode != null)
      return curNode;

    return null;
  }

  public Object getPropertyValue(String name)
  {
    Node node = getNode(name);
    if (node == null)
      return null;

    return node._value;
  }

  public String getPropertySet(String name)
  {
    Node node = getNode(name);
    if (node == null)
      return null;
      
    return node._set;
  }
  
  public Enumeration getAllPropertyValues()
  {
    if (_root == null)
      return null;
      
    Vector vect = _root.getAllValues();
    return vect.elements();
  }

  public Iterator getPropertyNames(String name)
  {
    return getPropertyNames(name,null);
  }
  
  /**
   * Returns the properties underneith the passed property.  Example:
   *   one.two.three=something
   *   one.two.three.property1.subproperty1=1
   *   one.two.three.property1.subproperty2=2
   * If "one.two.three.property1" was passed then a vector containing the names
   * in the last to strings would be returned.
   * 
   * @param name The name of the property for which you want to get all children
   * properties.  If null is passed then all property names are returned
   * @return The property names (an enumeration of Strings)
   * @see getAllPropertyNames()
   */
  public Iterator getPropertyNames(String name, String set)
  {
    Node node = _root;
    if (name != null) {
      node = getNode(name);
    }
    if (node == null)
      return null;

    Vector nodes = node.getAllChildren(set);
    TreeSet names = new TreeSet();
    for (int i = 0; i < nodes.size(); i++) {
      Node curNode = (Node)nodes.elementAt(i);
      names.add(curNode._fullName);
    }

    return names.iterator();
  }

  public Iterator getAllPropertyNames()
  {
    return getPropertyNames(null,null);
  }
  
  public Iterator getAllPropertyNames(String set)
  {
    return getPropertyNames(null,set);
  }

}