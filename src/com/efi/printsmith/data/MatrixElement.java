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
	@NamedQuery(name = "MatrixElement.findall", query = "from MatrixElement"),
	@NamedQuery(name = "MatrixElement.byId", query = "select a from MatrixElement a where a.id= :id")
})


@Entity
@Table(name = "matrixelement")
public class MatrixElement extends ModelBase {
	/**
	 * @generated
	 */
	public static final String QTY = "Qty";
	/**
	 * @generated
	 */
	public static final String PRICE1 = "Price1";
	/**
	 * @generated
	 */
	public static final String PRICE2 = "Price2";
	/**
	 * @generated
	 */
	public static final String PRICE3 = "Price3";
	/**
	 * @generated
	 */
	public static final String PRICE4 = "Price4";
	/**
	 * @generated
	 */
	public static final String PRICE5 = "Price5";
	/**
	 * @generated
	 */
	public static final String PRICE6 = "Price6";
	/**
	 * @generated
	 */
	public static final String PRICE7 = "Price7";
	/**
	 * @generated
	 */
	public static final String PRICE8 = "Price8";
	/**
	 * @generated
	 */
	public static final String PRICE9 = "Price9";
	/**
	 * @generated
	 */
	public static final String PRICE10 = "Price10";

	/**
	 * @generated
	 */
	public MatrixElement() {
		this.created = new Date();
		this.modified = new Date();
	}

 	
	
 	@Basic
	private Integer qty;
	/**
	 * @generated
 	 */
	public Integer getQty(){
		return qty; 
	}

	/**
	 * @generated
	 */	
	public void setQty(Integer newVal) {
		this.qty = newVal;
	}
 	
	
 	@Basic
	private Double price1;
	/**
	 * @generated
 	 */
	public Double getPrice1(){
		return price1; 
	}

	/**
	 * @generated
	 */	
	public void setPrice1(Double newVal) {
		this.price1 = newVal;
	}
 	
	
 	@Basic
	private Double price2;
	/**
	 * @generated
 	 */
	public Double getPrice2(){
		return price2; 
	}

	/**
	 * @generated
	 */	
	public void setPrice2(Double newVal) {
		this.price2 = newVal;
	}
 	
	
 	@Basic
	private Double price3;
	/**
	 * @generated
 	 */
	public Double getPrice3(){
		return price3; 
	}

	/**
	 * @generated
	 */	
	public void setPrice3(Double newVal) {
		this.price3 = newVal;
	}
 	
	
 	@Basic
	private Double price4;
	/**
	 * @generated
 	 */
	public Double getPrice4(){
		return price4; 
	}

	/**
	 * @generated
	 */	
	public void setPrice4(Double newVal) {
		this.price4 = newVal;
	}
 	
	
 	@Basic
	private Double price5;
	/**
	 * @generated
 	 */
	public Double getPrice5(){
		return price5; 
	}

	/**
	 * @generated
	 */	
	public void setPrice5(Double newVal) {
		this.price5 = newVal;
	}
 	
	
 	@Basic
	private Double price6;
	/**
	 * @generated
 	 */
	public Double getPrice6(){
		return price6; 
	}

	/**
	 * @generated
	 */	
	public void setPrice6(Double newVal) {
		this.price6 = newVal;
	}
 	
	
 	@Basic
	private Double price7;
	/**
	 * @generated
 	 */
	public Double getPrice7(){
		return price7; 
	}

	/**
	 * @generated
	 */	
	public void setPrice7(Double newVal) {
		this.price7 = newVal;
	}
 	
	
 	@Basic
	private Double price8;
	/**
	 * @generated
 	 */
	public Double getPrice8(){
		return price8; 
	}

	/**
	 * @generated
	 */	
	public void setPrice8(Double newVal) {
		this.price8 = newVal;
	}
 	
	
 	@Basic
	private Double price9;
	/**
	 * @generated
 	 */
	public Double getPrice9(){
		return price9; 
	}

	/**
	 * @generated
	 */	
	public void setPrice9(Double newVal) {
		this.price9 = newVal;
	}
 	
	
 	@Basic
	private Double price10;
	/**
	 * @generated
 	 */
	public Double getPrice10(){
		return price10; 
	}

	/**
	 * @generated
	 */	
	public void setPrice10(Double newVal) {
		this.price10 = newVal;
	}
	/**
	 * @generated
	 */		
	@Transient
	@Override
	public Object getProperty(String propertyName) throws UnknownPropertyException {
		if (QTY.equals(propertyName)) return getQty();
		if (PRICE1.equals(propertyName)) return getPrice1();
		if (PRICE2.equals(propertyName)) return getPrice2();
		if (PRICE3.equals(propertyName)) return getPrice3();
		if (PRICE4.equals(propertyName)) return getPrice4();
		if (PRICE5.equals(propertyName)) return getPrice5();
		if (PRICE6.equals(propertyName)) return getPrice6();
		if (PRICE7.equals(propertyName)) return getPrice7();
		if (PRICE8.equals(propertyName)) return getPrice8();
		if (PRICE9.equals(propertyName)) return getPrice9();
		if (PRICE10.equals(propertyName)) return getPrice10();
		return super.getProperty(propertyName);
	}
	
	/**
	 * @generated
	 */		
	@SuppressWarnings("unchecked")
	@Override
	public void setProperty(String propertyName, Object newValue) throws PropertyException {
		if (QTY.equals(propertyName)) setQty((Integer)newValue); else
		if (PRICE1.equals(propertyName)) setPrice1((Double)newValue); else
		if (PRICE2.equals(propertyName)) setPrice2((Double)newValue); else
		if (PRICE3.equals(propertyName)) setPrice3((Double)newValue); else
		if (PRICE4.equals(propertyName)) setPrice4((Double)newValue); else
		if (PRICE5.equals(propertyName)) setPrice5((Double)newValue); else
		if (PRICE6.equals(propertyName)) setPrice6((Double)newValue); else
		if (PRICE7.equals(propertyName)) setPrice7((Double)newValue); else
		if (PRICE8.equals(propertyName)) setPrice8((Double)newValue); else
		if (PRICE9.equals(propertyName)) setPrice9((Double)newValue); else
		if (PRICE10.equals(propertyName)) setPrice10((Double)newValue); else
		super.setProperty(propertyName, newValue);
	}
	
	/**
	 * @generated
	 */		
	@Transient
	@Override
	public Class<?>[] getPropertyClass(String propertyName) throws UnknownPropertyException {	
		if (QTY.equals(propertyName)) 
			return new Class<?>[] {Integer.class};		
		if (PRICE1.equals(propertyName)) 
			return new Class<?>[] {Double.class};		
		if (PRICE2.equals(propertyName)) 
			return new Class<?>[] {Double.class};		
		if (PRICE3.equals(propertyName)) 
			return new Class<?>[] {Double.class};		
		if (PRICE4.equals(propertyName)) 
			return new Class<?>[] {Double.class};		
		if (PRICE5.equals(propertyName)) 
			return new Class<?>[] {Double.class};		
		if (PRICE6.equals(propertyName)) 
			return new Class<?>[] {Double.class};		
		if (PRICE7.equals(propertyName)) 
			return new Class<?>[] {Double.class};		
		if (PRICE8.equals(propertyName)) 
			return new Class<?>[] {Double.class};		
		if (PRICE9.equals(propertyName)) 
			return new Class<?>[] {Double.class};		
		if (PRICE10.equals(propertyName)) 
			return new Class<?>[] {Double.class};		
		return super.getPropertyClass(propertyName);
	}
	

	/**
	 * @generated
	 */		
	@Transient
	@Override
	public Class<?> getPropertyOwner(String propertyName) throws UnknownPropertyException {	
		if (QTY.equals(propertyName)) return MatrixElement.class;
		if (PRICE1.equals(propertyName)) return MatrixElement.class;
		if (PRICE2.equals(propertyName)) return MatrixElement.class;
		if (PRICE3.equals(propertyName)) return MatrixElement.class;
		if (PRICE4.equals(propertyName)) return MatrixElement.class;
		if (PRICE5.equals(propertyName)) return MatrixElement.class;
		if (PRICE6.equals(propertyName)) return MatrixElement.class;
		if (PRICE7.equals(propertyName)) return MatrixElement.class;
		if (PRICE8.equals(propertyName)) return MatrixElement.class;
		if (PRICE9.equals(propertyName)) return MatrixElement.class;
		if (PRICE10.equals(propertyName)) return MatrixElement.class;
		return super.getPropertyOwner(propertyName);
	}
	
	/**
	 * @generated
	 */			
	@Override
	public boolean deepEquals(Object obj) {
		if (! super.deepEquals(obj))
			return false;
		MatrixElement objT = (MatrixElement)obj;
		if (! SmartEquals(getQty(), objT.getQty()))
			return false;
		if (! SmartEquals(getPrice1(), objT.getPrice1()))
			return false;
		if (! SmartEquals(getPrice2(), objT.getPrice2()))
			return false;
		if (! SmartEquals(getPrice3(), objT.getPrice3()))
			return false;
		if (! SmartEquals(getPrice4(), objT.getPrice4()))
			return false;
		if (! SmartEquals(getPrice5(), objT.getPrice5()))
			return false;
		if (! SmartEquals(getPrice6(), objT.getPrice6()))
			return false;
		if (! SmartEquals(getPrice7(), objT.getPrice7()))
			return false;
		if (! SmartEquals(getPrice8(), objT.getPrice8()))
			return false;
		if (! SmartEquals(getPrice9(), objT.getPrice9()))
			return false;
		if (! SmartEquals(getPrice10(), objT.getPrice10()))
			return false;
		return true;
	}			
}