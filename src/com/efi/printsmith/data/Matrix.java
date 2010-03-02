package com.efi.printsmith.data;

import java.util.Date;
import java.util.List;

import com.efi.printsmith.data.*;
import com.efi.printsmith.data.enums.*;
import com.efi.printsmith.exceptions.*;

import javax.persistence.*;

import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CollectionOfElements;
import org.hibernate.annotations.FetchMode;
import org.hibernate.annotations.IndexColumn;
import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;
import org.hibernate.annotations.Type;

/**
 * @generated
 */
 
 
/**
 * @!generated
 */	
@NamedQueries({
	@NamedQuery(name = "Matrix.findall", query = "from Matrix"),
	@NamedQuery(name = "Matrix.byId", query = "select a from Matrix a where a.id= :id")
})


@Entity
@Table(name = "matrix")
public class Matrix extends ModelBase {
	/**
	 * @generated
	 */
	public static final String HEADERVALUES = "HeaderValues";
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

 	
	
    @CollectionOfElements
	private java.util.List<Long> headerValues;
	/**
	 * @generated
 	 */
	public java.util.List<Long> getHeaderValues(){
		return headerValues; 
	}

	public void addHeaderValues(Long obj) {
		if (headerValues == null) {
			headerValues = new java.util.ArrayList<Long>();
		}
		headerValues.add(obj);
	}
	/**
	 * @generated
	 */	
	public void setHeaderValues(java.util.List<Long> newVal) {
		this.headerValues = newVal;
	}
 	
	
    @OneToMany( cascade = {CascadeType.ALL})
    @JoinTable( name = "matrix_elements")
	private java.util.List<MatrixElement> elements;
	/**
	 * @generated
 	 */
	public java.util.List<MatrixElement> getElements(){
		return elements; 
	}

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
		if (HEADERVALUES.equals(propertyName)) return getHeaderValues();
		if (ELEMENTS.equals(propertyName)) return getElements();
		return super.getProperty(propertyName);
	}
	
	/**
	 * @generated
	 */		
	@SuppressWarnings("unchecked")
	@Override
	public void setProperty(String propertyName, Object newValue) throws PropertyException {
		if (HEADERVALUES.equals(propertyName)) setHeaderValues((java.util.List<Long>)newValue); else
		if (ELEMENTS.equals(propertyName)) setElements((java.util.List<MatrixElement>)newValue); else
		super.setProperty(propertyName, newValue);
	}
	
	/**
	 * @generated
	 */		
	@Transient
	@Override
	public Class<?>[] getPropertyClass(String propertyName) throws UnknownPropertyException {	
		if (HEADERVALUES.equals(propertyName)) 
			return new Class<?>[] {java.util.List.class, Long.class};		
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
		if (HEADERVALUES.equals(propertyName)) return Matrix.class;
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
		if (! SmartEquals(getHeaderValues(), objT.getHeaderValues()))
			return false;
		if (! SmartEquals(getElements(), objT.getElements()))
			return false;
		return true;
	}			
}