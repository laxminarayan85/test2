
package com.efi.printsmith.data;

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
  @NamedQuery(name = "MatrixElement.findall", query = "from MatrixElement"),
  @NamedQuery(name = "MatrixElement.byId", query = "select a from MatrixElement a where a.id= :id")
})



/**
 * @generated
 */	
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
	public static final String PRICE12 = "Price12";
	/**
	 * @generated
	 */
	public static final String PRICE2 = "Price2";
	/**
	 * @generated
	 */
	public static final String PRICE13 = "Price13";
	/**
	 * @generated
	 */
	public static final String PRICE3 = "Price3";
	/**
	 * @generated
	 */
	public static final String PRICE14 = "Price14";
	/**
	 * @generated
	 */
	public static final String PRICE4 = "Price4";
	/**
	 * @generated
	 */
	public static final String PRICE15 = "Price15";
	/**
	 * @generated
	 */
	public static final String PRICE5 = "Price5";
	/**
	 * @generated
	 */
	public static final String PRICE16 = "Price16";
	/**
	 * @generated
	 */
	public static final String PRICE6 = "Price6";
	/**
	 * @generated
	 */
	public static final String PRICE17 = "Price17";
	/**
	 * @generated
	 */
	public static final String PRICE7 = "Price7";
	/**
	 * @generated
	 */
	public static final String PRICE18 = "Price18";
	/**
	 * @generated
	 */
	public static final String PRICE8 = "Price8";
	/**
	 * @generated
	 */
	public static final String PRICE19 = "Price19";
	/**
	 * @generated
	 */
	public static final String PRICE9 = "Price9";
	/**
	 * @generated
	 */
	public static final String PRICE20 = "Price20";
	/**
	 * @generated
	 */
	public static final String PRICE10 = "Price10";
	/**
	 * @generated
	 */
	public static final String PRICE11 = "Price11";

	/**
	 * @generated
	 */
	public MatrixElement() {
    this.created = new Date();
    this.modified = new Date();
  }

 	
	
	/**
	 * @generated
	 */	
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
 	
	
	/**
	 * @generated
	 */	
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
 	
	
	/**
	 * @generated
	 */	
 	@Basic
	private Double price12;
	
	/**
	 * @generated
 	 */
	public Double getPrice12(){
    return price12; 
  }

	
	/**
	 * @generated
	 */	
	public void setPrice12(Double newVal) {
    this.price12 = newVal;
  }
 	
	
	/**
	 * @generated
	 */	
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
 	
	
	/**
	 * @generated
	 */	
 	@Basic
	private Double price13;
	
	/**
	 * @generated
 	 */
	public Double getPrice13(){
    return price13; 
  }

	
	/**
	 * @generated
	 */	
	public void setPrice13(Double newVal) {
    this.price13 = newVal;
  }
 	
	
	/**
	 * @generated
	 */	
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
 	
	
	/**
	 * @generated
	 */	
 	@Basic
	private Double price14;
	
	/**
	 * @generated
 	 */
	public Double getPrice14(){
    return price14; 
  }

	
	/**
	 * @generated
	 */	
	public void setPrice14(Double newVal) {
    this.price14 = newVal;
  }
 	
	
	/**
	 * @generated
	 */	
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
 	
	
	/**
	 * @generated
	 */	
 	@Basic
	private Double price15;
	
	/**
	 * @generated
 	 */
	public Double getPrice15(){
    return price15; 
  }

	
	/**
	 * @generated
	 */	
	public void setPrice15(Double newVal) {
    this.price15 = newVal;
  }
 	
	
	/**
	 * @generated
	 */	
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
 	
	
	/**
	 * @generated
	 */	
 	@Basic
	private Double price16;
	
	/**
	 * @generated
 	 */
	public Double getPrice16(){
    return price16; 
  }

	
	/**
	 * @generated
	 */	
	public void setPrice16(Double newVal) {
    this.price16 = newVal;
  }
 	
	
	/**
	 * @generated
	 */	
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
 	
	
	/**
	 * @generated
	 */	
 	@Basic
	private Double price17;
	
	/**
	 * @generated
 	 */
	public Double getPrice17(){
    return price17; 
  }

	
	/**
	 * @generated
	 */	
	public void setPrice17(Double newVal) {
    this.price17 = newVal;
  }
 	
	
	/**
	 * @generated
	 */	
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
 	
	
	/**
	 * @generated
	 */	
 	@Basic
	private Double price18;
	
	/**
	 * @generated
 	 */
	public Double getPrice18(){
    return price18; 
  }

	
	/**
	 * @generated
	 */	
	public void setPrice18(Double newVal) {
    this.price18 = newVal;
  }
 	
	
	/**
	 * @generated
	 */	
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
 	
	
	/**
	 * @generated
	 */	
 	@Basic
	private Double price19;
	
	/**
	 * @generated
 	 */
	public Double getPrice19(){
    return price19; 
  }

	
	/**
	 * @generated
	 */	
	public void setPrice19(Double newVal) {
    this.price19 = newVal;
  }
 	
	
	/**
	 * @generated
	 */	
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
 	
	
	/**
	 * @generated
	 */	
 	@Basic
	private Double price20;
	
	/**
	 * @generated
 	 */
	public Double getPrice20(){
    return price20; 
  }

	
	/**
	 * @generated
	 */	
	public void setPrice20(Double newVal) {
    this.price20 = newVal;
  }
 	
	
	/**
	 * @generated
	 */	
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
 	@Basic
	private Double price11;
	
	/**
	 * @generated
 	 */
	public Double getPrice11(){
    return price11; 
  }

	
	/**
	 * @generated
	 */	
	public void setPrice11(Double newVal) {
    this.price11 = newVal;
  }
	/**
	 * @generated
	 */		
	@Transient
	@Override
	public Object getProperty(String propertyName) throws UnknownPropertyException {
    if (QTY.equals(propertyName)) return getQty();
    if (PRICE1.equals(propertyName)) return getPrice1();
    if (PRICE12.equals(propertyName)) return getPrice12();
    if (PRICE2.equals(propertyName)) return getPrice2();
    if (PRICE13.equals(propertyName)) return getPrice13();
    if (PRICE3.equals(propertyName)) return getPrice3();
    if (PRICE14.equals(propertyName)) return getPrice14();
    if (PRICE4.equals(propertyName)) return getPrice4();
    if (PRICE15.equals(propertyName)) return getPrice15();
    if (PRICE5.equals(propertyName)) return getPrice5();
    if (PRICE16.equals(propertyName)) return getPrice16();
    if (PRICE6.equals(propertyName)) return getPrice6();
    if (PRICE17.equals(propertyName)) return getPrice17();
    if (PRICE7.equals(propertyName)) return getPrice7();
    if (PRICE18.equals(propertyName)) return getPrice18();
    if (PRICE8.equals(propertyName)) return getPrice8();
    if (PRICE19.equals(propertyName)) return getPrice19();
    if (PRICE9.equals(propertyName)) return getPrice9();
    if (PRICE20.equals(propertyName)) return getPrice20();
    if (PRICE10.equals(propertyName)) return getPrice10();
    if (PRICE11.equals(propertyName)) return getPrice11();
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
    if (PRICE12.equals(propertyName)) setPrice12((Double)newValue); else
    if (PRICE2.equals(propertyName)) setPrice2((Double)newValue); else
    if (PRICE13.equals(propertyName)) setPrice13((Double)newValue); else
    if (PRICE3.equals(propertyName)) setPrice3((Double)newValue); else
    if (PRICE14.equals(propertyName)) setPrice14((Double)newValue); else
    if (PRICE4.equals(propertyName)) setPrice4((Double)newValue); else
    if (PRICE15.equals(propertyName)) setPrice15((Double)newValue); else
    if (PRICE5.equals(propertyName)) setPrice5((Double)newValue); else
    if (PRICE16.equals(propertyName)) setPrice16((Double)newValue); else
    if (PRICE6.equals(propertyName)) setPrice6((Double)newValue); else
    if (PRICE17.equals(propertyName)) setPrice17((Double)newValue); else
    if (PRICE7.equals(propertyName)) setPrice7((Double)newValue); else
    if (PRICE18.equals(propertyName)) setPrice18((Double)newValue); else
    if (PRICE8.equals(propertyName)) setPrice8((Double)newValue); else
    if (PRICE19.equals(propertyName)) setPrice19((Double)newValue); else
    if (PRICE9.equals(propertyName)) setPrice9((Double)newValue); else
    if (PRICE20.equals(propertyName)) setPrice20((Double)newValue); else
    if (PRICE10.equals(propertyName)) setPrice10((Double)newValue); else
    if (PRICE11.equals(propertyName)) setPrice11((Double)newValue); else
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
    if (PRICE12.equals(propertyName)) 
      return new Class<?>[] {Double.class};		
    if (PRICE2.equals(propertyName)) 
      return new Class<?>[] {Double.class};		
    if (PRICE13.equals(propertyName)) 
      return new Class<?>[] {Double.class};		
    if (PRICE3.equals(propertyName)) 
      return new Class<?>[] {Double.class};		
    if (PRICE14.equals(propertyName)) 
      return new Class<?>[] {Double.class};		
    if (PRICE4.equals(propertyName)) 
      return new Class<?>[] {Double.class};		
    if (PRICE15.equals(propertyName)) 
      return new Class<?>[] {Double.class};		
    if (PRICE5.equals(propertyName)) 
      return new Class<?>[] {Double.class};		
    if (PRICE16.equals(propertyName)) 
      return new Class<?>[] {Double.class};		
    if (PRICE6.equals(propertyName)) 
      return new Class<?>[] {Double.class};		
    if (PRICE17.equals(propertyName)) 
      return new Class<?>[] {Double.class};		
    if (PRICE7.equals(propertyName)) 
      return new Class<?>[] {Double.class};		
    if (PRICE18.equals(propertyName)) 
      return new Class<?>[] {Double.class};		
    if (PRICE8.equals(propertyName)) 
      return new Class<?>[] {Double.class};		
    if (PRICE19.equals(propertyName)) 
      return new Class<?>[] {Double.class};		
    if (PRICE9.equals(propertyName)) 
      return new Class<?>[] {Double.class};		
    if (PRICE20.equals(propertyName)) 
      return new Class<?>[] {Double.class};		
    if (PRICE10.equals(propertyName)) 
      return new Class<?>[] {Double.class};		
    if (PRICE11.equals(propertyName)) 
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
    if (PRICE12.equals(propertyName)) return MatrixElement.class;
    if (PRICE2.equals(propertyName)) return MatrixElement.class;
    if (PRICE13.equals(propertyName)) return MatrixElement.class;
    if (PRICE3.equals(propertyName)) return MatrixElement.class;
    if (PRICE14.equals(propertyName)) return MatrixElement.class;
    if (PRICE4.equals(propertyName)) return MatrixElement.class;
    if (PRICE15.equals(propertyName)) return MatrixElement.class;
    if (PRICE5.equals(propertyName)) return MatrixElement.class;
    if (PRICE16.equals(propertyName)) return MatrixElement.class;
    if (PRICE6.equals(propertyName)) return MatrixElement.class;
    if (PRICE17.equals(propertyName)) return MatrixElement.class;
    if (PRICE7.equals(propertyName)) return MatrixElement.class;
    if (PRICE18.equals(propertyName)) return MatrixElement.class;
    if (PRICE8.equals(propertyName)) return MatrixElement.class;
    if (PRICE19.equals(propertyName)) return MatrixElement.class;
    if (PRICE9.equals(propertyName)) return MatrixElement.class;
    if (PRICE20.equals(propertyName)) return MatrixElement.class;
    if (PRICE10.equals(propertyName)) return MatrixElement.class;
    if (PRICE11.equals(propertyName)) return MatrixElement.class;
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
    if (! SmartEquals(getPrice12(), objT.getPrice12()))
      return false;
    if (! SmartEquals(getPrice2(), objT.getPrice2()))
      return false;
    if (! SmartEquals(getPrice13(), objT.getPrice13()))
      return false;
    if (! SmartEquals(getPrice3(), objT.getPrice3()))
      return false;
    if (! SmartEquals(getPrice14(), objT.getPrice14()))
      return false;
    if (! SmartEquals(getPrice4(), objT.getPrice4()))
      return false;
    if (! SmartEquals(getPrice15(), objT.getPrice15()))
      return false;
    if (! SmartEquals(getPrice5(), objT.getPrice5()))
      return false;
    if (! SmartEquals(getPrice16(), objT.getPrice16()))
      return false;
    if (! SmartEquals(getPrice6(), objT.getPrice6()))
      return false;
    if (! SmartEquals(getPrice17(), objT.getPrice17()))
      return false;
    if (! SmartEquals(getPrice7(), objT.getPrice7()))
      return false;
    if (! SmartEquals(getPrice18(), objT.getPrice18()))
      return false;
    if (! SmartEquals(getPrice8(), objT.getPrice8()))
      return false;
    if (! SmartEquals(getPrice19(), objT.getPrice19()))
      return false;
    if (! SmartEquals(getPrice9(), objT.getPrice9()))
      return false;
    if (! SmartEquals(getPrice20(), objT.getPrice20()))
      return false;
    if (! SmartEquals(getPrice10(), objT.getPrice10()))
      return false;
    if (! SmartEquals(getPrice11(), objT.getPrice11()))
      return false;
    return true;
  }			
}
