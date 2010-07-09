
package com.efi.printsmith.data;

import java.math.BigDecimal;
import java.math.RoundingMode;
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
  @NamedQuery(name = "Matrix.findall", query = "from Matrix"),
  @NamedQuery(name = "Matrix.byId", query = "select a from Matrix a where a.id= :id")
})



/**
 * @generated
 */	
@Entity
@Table(name = "matrix")
public class Matrix extends ModelBase {
	/**
	 * @generated
	 */
	public static final String HEADER1 = "Header1";
	/**
	 * @generated
	 */
	public static final String HEADER2 = "Header2";
	/**
	 * @generated
	 */
	public static final String HEADER3 = "Header3";
	/**
	 * @generated
	 */
	public static final String HEADER4 = "Header4";
	/**
	 * @generated
	 */
	public static final String HEADER5 = "Header5";
	/**
	 * @generated
	 */
	public static final String HEADER6 = "Header6";
	/**
	 * @generated
	 */
	public static final String HEADER7 = "Header7";
	/**
	 * @generated
	 */
	public static final String HEADER8 = "Header8";
	/**
	 * @generated
	 */
	public static final String HEADER9 = "Header9";
	/**
	 * @generated
	 */
	public static final String HEADER10 = "Header10";
	/**
	 * @generated
	 */
	public static final String ELEMENTS = "Elements";

	/**
	 * @generated
	 */
	public Matrix() {
    this.created = new Date();
    this.modified = new Date();
  }

 	
	
	/**
	 * @generated
	 */	
 	@Basic
	private Long header1;
	
	/**
	 * @generated
 	 */
	public Long getHeader1(){
    return header1; 
  }

	
	/**
	 * @generated
	 */	
	public void setHeader1(Long newVal) {
    this.header1 = newVal;
  }
	
 	
	
	/**
	 * @generated
	 */	
 	@Basic
	private Long header2;
	
	/**
	 * @generated
 	 */
	public Long getHeader2(){
    return header2; 
  }

	
	/**
	 * @generated
	 */	
	public void setHeader2(Long newVal) {
    this.header2 = newVal;
  }
	
 	
	
	/**
	 * @generated
	 */	
 	@Basic
	private Long header3;
	
	/**
	 * @generated
 	 */
	public Long getHeader3(){
    return header3; 
  }

	
	/**
	 * @generated
	 */	
	public void setHeader3(Long newVal) {
    this.header3 = newVal;
  }
	
 	
	
	/**
	 * @generated
	 */	
 	@Basic
	private Long header4;
	
	/**
	 * @generated
 	 */
	public Long getHeader4(){
    return header4; 
  }

	
	/**
	 * @generated
	 */	
	public void setHeader4(Long newVal) {
    this.header4 = newVal;
  }
	
 	
	
	/**
	 * @generated
	 */	
 	@Basic
	private Long header5;
	
	/**
	 * @generated
 	 */
	public Long getHeader5(){
    return header5; 
  }

	
	/**
	 * @generated
	 */	
	public void setHeader5(Long newVal) {
    this.header5 = newVal;
  }
	
 	
	
	/**
	 * @generated
	 */	
 	@Basic
	private Long header6;
	
	/**
	 * @generated
 	 */
	public Long getHeader6(){
    return header6; 
  }

	
	/**
	 * @generated
	 */	
	public void setHeader6(Long newVal) {
    this.header6 = newVal;
  }
	
 	
	
	/**
	 * @generated
	 */	
 	@Basic
	private Long header7;
	
	/**
	 * @generated
 	 */
	public Long getHeader7(){
    return header7; 
  }

	
	/**
	 * @generated
	 */	
	public void setHeader7(Long newVal) {
    this.header7 = newVal;
  }
	
 	
	
	/**
	 * @generated
	 */	
 	@Basic
	private Long header8;
	
	/**
	 * @generated
 	 */
	public Long getHeader8(){
    return header8; 
  }

	
	/**
	 * @generated
	 */	
	public void setHeader8(Long newVal) {
    this.header8 = newVal;
  }
	
 	
	
	/**
	 * @generated
	 */	
 	@Basic
	private Long header9;
	
	/**
	 * @generated
 	 */
	public Long getHeader9(){
    return header9; 
  }

	
	/**
	 * @generated
	 */	
	public void setHeader9(Long newVal) {
    this.header9 = newVal;
  }
	
 	
	
	/**
	 * @generated
	 */	
 	@Basic
	private Long header10;
	
	/**
	 * @generated
 	 */
	public Long getHeader10(){
    return header10; 
  }

	
	/**
	 * @generated
	 */	
	public void setHeader10(Long newVal) {
    this.header10 = newVal;
  }
	
 	
	
	/**
	 * @generated
	 */	
    @OneToMany(  cascade = {CascadeType.ALL})
    @JoinTable( name = "matrix_elements")
	private java.util.List<MatrixElement> elements;
	
	/**
	 * @generated
 	 */
	public java.util.List<MatrixElement> getElements(){
    return elements; 
  }

	/**
	 * @generated
	 */	
	public void addElements(MatrixElement obj) {
    if (elements == null) {
      elements = new java.util.ArrayList<MatrixElement>();
    }
    elements.add(obj);
  }
	
	/**
	 * @generated
	 */	
	public void setElements(java.util.List<MatrixElement> newVal) {
    this.elements = newVal;
  }
	
	/**
	 * @generated
	 */		
	@Transient
	@Override
	public Object getProperty(String propertyName) throws UnknownPropertyException {
    if (HEADER1.equals(propertyName)) return getHeader1();
    if (HEADER2.equals(propertyName)) return getHeader2();
    if (HEADER3.equals(propertyName)) return getHeader3();
    if (HEADER4.equals(propertyName)) return getHeader4();
    if (HEADER5.equals(propertyName)) return getHeader5();
    if (HEADER6.equals(propertyName)) return getHeader6();
    if (HEADER7.equals(propertyName)) return getHeader7();
    if (HEADER8.equals(propertyName)) return getHeader8();
    if (HEADER9.equals(propertyName)) return getHeader9();
    if (HEADER10.equals(propertyName)) return getHeader10();
    if (ELEMENTS.equals(propertyName)) return getElements();
    return super.getProperty(propertyName);
  }
	
	/**
	 * @generated
	 */		
	@SuppressWarnings("unchecked")
	@Override
	public void setProperty(String propertyName, Object newValue) throws PropertyException {
    if (HEADER1.equals(propertyName)) setHeader1((Long)newValue); else
    if (HEADER2.equals(propertyName)) setHeader2((Long)newValue); else
    if (HEADER3.equals(propertyName)) setHeader3((Long)newValue); else
    if (HEADER4.equals(propertyName)) setHeader4((Long)newValue); else
    if (HEADER5.equals(propertyName)) setHeader5((Long)newValue); else
    if (HEADER6.equals(propertyName)) setHeader6((Long)newValue); else
    if (HEADER7.equals(propertyName)) setHeader7((Long)newValue); else
    if (HEADER8.equals(propertyName)) setHeader8((Long)newValue); else
    if (HEADER9.equals(propertyName)) setHeader9((Long)newValue); else
    if (HEADER10.equals(propertyName)) setHeader10((Long)newValue); else
    if (ELEMENTS.equals(propertyName)) setElements((java.util.List<MatrixElement>)newValue); else
    super.setProperty(propertyName, newValue);
  }
	
	/**
	 * @generated
	 */		
	@Transient
	@Override
	public Class<?>[] getPropertyClass(String propertyName) throws UnknownPropertyException {	
    if (HEADER1.equals(propertyName)) 
      return new Class<?>[] {Long.class};		
    if (HEADER2.equals(propertyName)) 
      return new Class<?>[] {Long.class};		
    if (HEADER3.equals(propertyName)) 
      return new Class<?>[] {Long.class};		
    if (HEADER4.equals(propertyName)) 
      return new Class<?>[] {Long.class};		
    if (HEADER5.equals(propertyName)) 
      return new Class<?>[] {Long.class};		
    if (HEADER6.equals(propertyName)) 
      return new Class<?>[] {Long.class};		
    if (HEADER7.equals(propertyName)) 
      return new Class<?>[] {Long.class};		
    if (HEADER8.equals(propertyName)) 
      return new Class<?>[] {Long.class};		
    if (HEADER9.equals(propertyName)) 
      return new Class<?>[] {Long.class};		
    if (HEADER10.equals(propertyName)) 
      return new Class<?>[] {Long.class};		
    if (ELEMENTS.equals(propertyName)) 
      return new Class<?>[] {java.util.List.class, MatrixElement.class};		
    return super.getPropertyClass(propertyName);
  }
	

	/**
	 * @generated
	 */		
	@Transient
	@Override
	public Class<?> getPropertyOwner(String propertyName) throws UnknownPropertyException {	
    if (HEADER1.equals(propertyName)) return Matrix.class;
    if (HEADER2.equals(propertyName)) return Matrix.class;
    if (HEADER3.equals(propertyName)) return Matrix.class;
    if (HEADER4.equals(propertyName)) return Matrix.class;
    if (HEADER5.equals(propertyName)) return Matrix.class;
    if (HEADER6.equals(propertyName)) return Matrix.class;
    if (HEADER7.equals(propertyName)) return Matrix.class;
    if (HEADER8.equals(propertyName)) return Matrix.class;
    if (HEADER9.equals(propertyName)) return Matrix.class;
    if (HEADER10.equals(propertyName)) return Matrix.class;
    if (ELEMENTS.equals(propertyName)) return Matrix.class;
    return super.getPropertyOwner(propertyName);
  }
	
	/**
	 * @generated
	 */			
	@Override
	public boolean deepEquals(Object obj) {
    if (! super.deepEquals(obj))
      return false;
    Matrix objT = (Matrix)obj;
    if (! SmartEquals(getHeader1(), objT.getHeader1()))
      return false;
    if (! SmartEquals(getHeader2(), objT.getHeader2()))
      return false;
    if (! SmartEquals(getHeader3(), objT.getHeader3()))
      return false;
    if (! SmartEquals(getHeader4(), objT.getHeader4()))
      return false;
    if (! SmartEquals(getHeader5(), objT.getHeader5()))
      return false;
    if (! SmartEquals(getHeader6(), objT.getHeader6()))
      return false;
    if (! SmartEquals(getHeader7(), objT.getHeader7()))
      return false;
    if (! SmartEquals(getHeader8(), objT.getHeader8()))
      return false;
    if (! SmartEquals(getHeader9(), objT.getHeader9()))
      return false;
    if (! SmartEquals(getHeader10(), objT.getHeader10()))
      return false;
    if (! SmartEquals(getElements(), objT.getElements()))
      return false;
    return true;
  }			
}
