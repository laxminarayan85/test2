
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
 	@Column(name="price1", precision=19, scale=8)
	private BigDecimal price1;
	
	/**
	 * @generated
 	 */
	public BigDecimal getPrice1(){
    return price1; 
  }

	
	/**
   * @generated
   */	
  public void setPrice1(BigDecimal newVal) {
    this.price1 = newVal;
    this.price1.setScale(8, RoundingMode.HALF_UP);
  }


	/**
   * @generated
   */	
  public void setPrice1(double newVal) {
    this.price1 = BigDecimal.valueOf(newVal);
    this.price1.setScale(8, RoundingMode.HALF_UP);
  }


	/**
	 * @generated
	 */	
 	@Basic  	
 	@Column(name="price12", precision=19, scale=8)
	private BigDecimal price12;
	
	/**
	 * @generated
 	 */
	public BigDecimal getPrice12(){
    return price12; 
  }

	
	/**
   * @generated
   */	
  public void setPrice12(BigDecimal newVal) {
    this.price12 = newVal;
    this.price12.setScale(8, RoundingMode.HALF_UP);
  }


	/**
   * @generated
   */	
  public void setPrice12(double newVal) {
    this.price12 = BigDecimal.valueOf(newVal);
    this.price12.setScale(8, RoundingMode.HALF_UP);
  }


	/**
	 * @generated
	 */	
 	@Basic  	
 	@Column(name="price2", precision=19, scale=8)
	private BigDecimal price2;
	
	/**
	 * @generated
 	 */
	public BigDecimal getPrice2(){
    return price2; 
  }

	
	/**
   * @generated
   */	
  public void setPrice2(BigDecimal newVal) {
    this.price2 = newVal;
    this.price2.setScale(8, RoundingMode.HALF_UP);
  }


	/**
   * @generated
   */	
  public void setPrice2(double newVal) {
    this.price2 = BigDecimal.valueOf(newVal);
    this.price2.setScale(8, RoundingMode.HALF_UP);
  }


	/**
	 * @generated
	 */	
	@Basic  	
 	@Column(name="price13", precision=19, scale=8)
	private BigDecimal price13;
	
	/**
	 * @generated
 	 */
	public BigDecimal getPrice13(){
    return price13; 
  }

	
	/**
   * @generated
   */	
  public void setPrice13(BigDecimal newVal) {
    this.price13 = newVal;
    this.price13.setScale(8, RoundingMode.HALF_UP);
  }


	/**
   * @generated
   */	
  public void setPrice13(double newVal) {
    this.price13 = BigDecimal.valueOf(newVal);
    this.price13.setScale(8, RoundingMode.HALF_UP);
  }


	/**
	 * @generated
	 */	
	@Basic  	
 	@Column(name="price3", precision=19, scale=8)
	private BigDecimal price3;
	
	/**
	 * @generated
 	 */
	public BigDecimal getPrice3(){
    return price3; 
  }

	
	/**
   * @generated
   */	
  public void setPrice3(BigDecimal newVal) {
    this.price3 = newVal;
    this.price3.setScale(8, RoundingMode.HALF_UP);
  }


	/**
   * @generated
   */	
  public void setPrice3(double newVal) {
    this.price3 = BigDecimal.valueOf(newVal);
    this.price3.setScale(8, RoundingMode.HALF_UP);
  }


	/**
	 * @generated
	 */	
	@Basic  	
 	@Column(name="price14", precision=19, scale=8)
	private BigDecimal price14;
	
	/**
	 * @generated
 	 */
	public BigDecimal getPrice14(){
    return price14; 
  }

	
	/**
   * @generated
   */	
  public void setPrice14(BigDecimal newVal) {
    this.price14 = newVal;
    this.price14.setScale(8, RoundingMode.HALF_UP);
  }


	/**
   * @generated
   */	
  public void setPrice14(double newVal) {
    this.price14 = BigDecimal.valueOf(newVal);
    this.price14.setScale(8, RoundingMode.HALF_UP);
  }


	/**
	 * @generated
	 */	
	@Basic  	
 	@Column(name="price4", precision=19, scale=8)
	private BigDecimal price4;
	
	/**
	 * @generated
 	 */
	public BigDecimal getPrice4(){
    return price4; 
  }

	
	/**
   * @generated
   */	
  public void setPrice4(BigDecimal newVal) {
    this.price4 = newVal;
    this.price4.setScale(8, RoundingMode.HALF_UP);
  }


	/**
   * @generated
   */	
  public void setPrice4(double newVal) {
    this.price4 = BigDecimal.valueOf(newVal);
    this.price4.setScale(8, RoundingMode.HALF_UP);
  }


	/**
	 * @generated
	 */	
	@Basic  	
 	@Column(name="price15", precision=19, scale=8)
	private BigDecimal price15;
	
	/**
	 * @generated
 	 */
	public BigDecimal getPrice15(){
    return price15; 
  }

	
	/**
   * @generated
   */	
  public void setPrice15(BigDecimal newVal) {
    this.price15 = newVal;
    this.price15.setScale(8, RoundingMode.HALF_UP);
  }


	/**
   * @generated
   */	
  public void setPrice15(double newVal) {
    this.price15 = BigDecimal.valueOf(newVal);
    this.price15.setScale(8, RoundingMode.HALF_UP);
  }


	/**
	 * @generated
	 */	
	@Basic  	
 	@Column(name="price5", precision=19, scale=8)
	private BigDecimal price5;
	
	/**
	 * @generated
 	 */
	public BigDecimal getPrice5(){
    return price5; 
  }

	
	/**
   * @generated
   */	
  public void setPrice5(BigDecimal newVal) {
    this.price5 = newVal;
    this.price5.setScale(8, RoundingMode.HALF_UP);
  }


	/**
   * @generated
   */	
  public void setPrice5(double newVal) {
    this.price5 = BigDecimal.valueOf(newVal);
    this.price5.setScale(8, RoundingMode.HALF_UP);
  }


	/**
	 * @generated
	 */	
	@Basic  	
 	@Column(name="price16", precision=19, scale=8)
	private BigDecimal price16;
	
	/**
	 * @generated
 	 */
	public BigDecimal getPrice16(){
    return price16; 
  }

	
	/**
   * @generated
   */	
  public void setPrice16(BigDecimal newVal) {
    this.price16 = newVal;
    this.price16.setScale(8, RoundingMode.HALF_UP);
  }


	/**
   * @generated
   */	
  public void setPrice16(double newVal) {
    this.price16 = BigDecimal.valueOf(newVal);
    this.price16.setScale(8, RoundingMode.HALF_UP);
  }


	/**
	 * @generated
	 */	
	@Basic  	
 	@Column(name="price6", precision=19, scale=8)
	private BigDecimal price6;
	
	/**
	 * @generated
 	 */
	public BigDecimal getPrice6(){
    return price6; 
  }

	
	/**
   * @generated
   */	
  public void setPrice6(BigDecimal newVal) {
    this.price6 = newVal;
    this.price6.setScale(8, RoundingMode.HALF_UP);
  }


	/**
   * @generated
   */	
  public void setPrice6(double newVal) {
    this.price6 = BigDecimal.valueOf(newVal);
    this.price6.setScale(8, RoundingMode.HALF_UP);
  }


	/**
	 * @generated
	 */	
	@Basic  	
 	@Column(name="price17", precision=19, scale=8)
	private BigDecimal price17;
	
	/**
	 * @generated
 	 */
	public BigDecimal getPrice17(){
    return price17; 
  }

	
	/**
   * @generated
   */	
  public void setPrice17(BigDecimal newVal) {
    this.price17 = newVal;
    this.price17.setScale(8, RoundingMode.HALF_UP);
  }


	/**
   * @generated
   */	
  public void setPrice17(double newVal) {
    this.price17 = BigDecimal.valueOf(newVal);
    this.price17.setScale(8, RoundingMode.HALF_UP);
  }


	/**
	 * @generated
	 */	
	@Basic  	
 	@Column(name="price7", precision=19, scale=8)
	private BigDecimal price7;
	
	/**
	 * @generated
 	 */
	public BigDecimal getPrice7(){
    return price7; 
  }

	
	/**
   * @generated
   */	
  public void setPrice7(BigDecimal newVal) {
    this.price7 = newVal;
    this.price7.setScale(8, RoundingMode.HALF_UP);
  }


	/**
   * @generated
   */	
  public void setPrice7(double newVal) {
    this.price7 = BigDecimal.valueOf(newVal);
    this.price7.setScale(8, RoundingMode.HALF_UP);
  }


	/**
	 * @generated
	 */	
	@Basic  	
 	@Column(name="price18", precision=19, scale=8)
	private BigDecimal price18;
	
	/**
	 * @generated
 	 */
	public BigDecimal getPrice18(){
    return price18; 
  }

	
	/**
   * @generated
   */	
  public void setPrice18(BigDecimal newVal) {
    this.price18 = newVal;
    this.price18.setScale(8, RoundingMode.HALF_UP);
  }


	/**
   * @generated
   */	
  public void setPrice18(double newVal) {
    this.price18 = BigDecimal.valueOf(newVal);
    this.price18.setScale(8, RoundingMode.HALF_UP);
  }


	/**
	 * @generated
	 */	
	@Basic  	
 	@Column(name="price8", precision=19, scale=8)
	private BigDecimal price8;
	
	/**
	 * @generated
 	 */
	public BigDecimal getPrice8(){
    return price8; 
  }

	
	/**
   * @generated
   */	
  public void setPrice8(BigDecimal newVal) {
    this.price8 = newVal;
    this.price8.setScale(8, RoundingMode.HALF_UP);
  }


	/**
   * @generated
   */	
  public void setPrice8(double newVal) {
    this.price8 = BigDecimal.valueOf(newVal);
    this.price8.setScale(8, RoundingMode.HALF_UP);
  }


	/**
	 * @generated
	 */	
	@Basic  	
 	@Column(name="price19", precision=19, scale=8)
	private BigDecimal price19;
	
	/**
	 * @generated
 	 */
	public BigDecimal getPrice19(){
    return price19; 
  }

	
	/**
   * @generated
   */	
  public void setPrice19(BigDecimal newVal) {
    this.price19 = newVal;
    this.price19.setScale(8, RoundingMode.HALF_UP);
  }


	/**
   * @generated
   */	
  public void setPrice19(double newVal) {
    this.price19 = BigDecimal.valueOf(newVal);
    this.price19.setScale(8, RoundingMode.HALF_UP);
  }


	/**
	 * @generated
	 */	
	@Basic  	
 	@Column(name="price9", precision=19, scale=8)
	private BigDecimal price9;
	
	/**
	 * @generated
 	 */
	public BigDecimal getPrice9(){
    return price9; 
  }

	
	/**
   * @generated
   */	
  public void setPrice9(BigDecimal newVal) {
    this.price9 = newVal;
    this.price9.setScale(8, RoundingMode.HALF_UP);
  }


	/**
   * @generated
   */	
  public void setPrice9(double newVal) {
    this.price9 = BigDecimal.valueOf(newVal);
    this.price9.setScale(8, RoundingMode.HALF_UP);
  }


	/**
	 * @generated
	 */	
	@Basic  	
 	@Column(name="price20", precision=19, scale=8)
	private BigDecimal price20;
	
	/**
	 * @generated
 	 */
	public BigDecimal getPrice20(){
    return price20; 
  }

	
	/**
   * @generated
   */	
  public void setPrice20(BigDecimal newVal) {
    this.price20 = newVal;
    this.price20.setScale(8, RoundingMode.HALF_UP);
  }


	/**
   * @generated
   */	
  public void setPrice20(double newVal) {
    this.price20 = BigDecimal.valueOf(newVal);
    this.price20.setScale(8, RoundingMode.HALF_UP);
  }


	/**
	 * @generated
	 */	
	@Basic  	
 	@Column(name="price10", precision=19, scale=8)
	private BigDecimal price10;
	
	/**
	 * @generated
 	 */
	public BigDecimal getPrice10(){
    return price10; 
  }

	
	/**
   * @generated
   */	
  public void setPrice10(BigDecimal newVal) {
    this.price10 = newVal;
    this.price10.setScale(8, RoundingMode.HALF_UP);
  }


	/**
   * @generated
   */	
  public void setPrice10(double newVal) {
    this.price10 = BigDecimal.valueOf(newVal);
    this.price10.setScale(8, RoundingMode.HALF_UP);
  }


	/**
	 * @generated
	 */	
	@Basic  	
 	@Column(name="price11", precision=19, scale=8)
	private BigDecimal price11;
	
	/**
	 * @generated
 	 */
	public BigDecimal getPrice11(){
    return price11; 
  }

	
	/**
   * @generated
   */	
  public void setPrice11(BigDecimal newVal) {
    this.price11 = newVal;
    this.price11.setScale(8, RoundingMode.HALF_UP);
  }


	/**
   * @generated
   */	
  public void setPrice11(double newVal) {
    this.price11 = BigDecimal.valueOf(newVal);
    this.price11.setScale(8, RoundingMode.HALF_UP);
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
    if (PRICE1.equals(propertyName)) setPrice1((BigDecimal)newValue); else
    if (PRICE12.equals(propertyName)) setPrice12((BigDecimal)newValue); else
    if (PRICE2.equals(propertyName)) setPrice2((BigDecimal)newValue); else
    if (PRICE13.equals(propertyName)) setPrice13((BigDecimal)newValue); else
    if (PRICE3.equals(propertyName)) setPrice3((BigDecimal)newValue); else
    if (PRICE14.equals(propertyName)) setPrice14((BigDecimal)newValue); else
    if (PRICE4.equals(propertyName)) setPrice4((BigDecimal)newValue); else
    if (PRICE15.equals(propertyName)) setPrice15((BigDecimal)newValue); else
    if (PRICE5.equals(propertyName)) setPrice5((BigDecimal)newValue); else
    if (PRICE16.equals(propertyName)) setPrice16((BigDecimal)newValue); else
    if (PRICE6.equals(propertyName)) setPrice6((BigDecimal)newValue); else
    if (PRICE17.equals(propertyName)) setPrice17((BigDecimal)newValue); else
    if (PRICE7.equals(propertyName)) setPrice7((BigDecimal)newValue); else
    if (PRICE18.equals(propertyName)) setPrice18((BigDecimal)newValue); else
    if (PRICE8.equals(propertyName)) setPrice8((BigDecimal)newValue); else
    if (PRICE19.equals(propertyName)) setPrice19((BigDecimal)newValue); else
    if (PRICE9.equals(propertyName)) setPrice9((BigDecimal)newValue); else
    if (PRICE20.equals(propertyName)) setPrice20((BigDecimal)newValue); else
    if (PRICE10.equals(propertyName)) setPrice10((BigDecimal)newValue); else
    if (PRICE11.equals(propertyName)) setPrice11((BigDecimal)newValue); else
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
      return new Class<?>[] {BigDecimal.class};		
    if (PRICE12.equals(propertyName)) 
      return new Class<?>[] {BigDecimal.class};		
    if (PRICE2.equals(propertyName)) 
      return new Class<?>[] {BigDecimal.class};		
    if (PRICE13.equals(propertyName)) 
      return new Class<?>[] {BigDecimal.class};		
    if (PRICE3.equals(propertyName)) 
      return new Class<?>[] {BigDecimal.class};		
    if (PRICE14.equals(propertyName)) 
      return new Class<?>[] {BigDecimal.class};		
    if (PRICE4.equals(propertyName)) 
      return new Class<?>[] {BigDecimal.class};		
    if (PRICE15.equals(propertyName)) 
      return new Class<?>[] {BigDecimal.class};		
    if (PRICE5.equals(propertyName)) 
      return new Class<?>[] {BigDecimal.class};		
    if (PRICE16.equals(propertyName)) 
      return new Class<?>[] {BigDecimal.class};		
    if (PRICE6.equals(propertyName)) 
      return new Class<?>[] {BigDecimal.class};		
    if (PRICE17.equals(propertyName)) 
      return new Class<?>[] {BigDecimal.class};		
    if (PRICE7.equals(propertyName)) 
      return new Class<?>[] {BigDecimal.class};		
    if (PRICE18.equals(propertyName)) 
      return new Class<?>[] {BigDecimal.class};		
    if (PRICE8.equals(propertyName)) 
      return new Class<?>[] {BigDecimal.class};		
    if (PRICE19.equals(propertyName)) 
      return new Class<?>[] {BigDecimal.class};		
    if (PRICE9.equals(propertyName)) 
      return new Class<?>[] {BigDecimal.class};		
    if (PRICE20.equals(propertyName)) 
      return new Class<?>[] {BigDecimal.class};		
    if (PRICE10.equals(propertyName)) 
      return new Class<?>[] {BigDecimal.class};		
    if (PRICE11.equals(propertyName)) 
      return new Class<?>[] {BigDecimal.class};		
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
