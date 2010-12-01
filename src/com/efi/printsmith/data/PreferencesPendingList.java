
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
import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.Type;
import org.hibernate.annotations.Where;

/**
 * @generated
 */

 
/**
 * @generated
 */	
@NamedQueries({
  @NamedQuery(name = "PreferencesPendingList.findall", query = "from PreferencesPendingList"),
  @NamedQuery(name = "PreferencesPendingList.byId", query = "select a from PreferencesPendingList a where a.id= :id")
})



/**
 * @generated
 */	
@Entity
@Table(name = "preferencespendinglist")
@SQLDelete(sql="update preferencespendinglist set isdeleted='TRUE' where id=?")
@Where(clause="isdeleted <> 'TRUE'")
public class PreferencesPendingList extends ModelBase {
	/**
	 * @generated
	 */
	public static final String VISIBLE = "Visible";
	/**
	 * @generated
	 */
	public static final String COLUMNS = "Columns";
	/**
	 * @generated
	 */
	public static final String COLUMNORDER = "ColumnOrder";
	/**
	 * @generated
	 */
	public static final String PASTDUECOLOR = "PastDueColor";
	/**
	 * @generated
	 */
	public static final String READYFORPICKUPCOLOR = "ReadyForPickupColor";
	/**
	 * @generated
	 */
	public static final String INVOICECOLOR = "InvoiceColor";
	/**
	 * @generated
	 */
	public static final String ESTIMATECOLOR = "EstimateColor";
	/**
	 * @generated
	 */
	public static final String LISTFONT = "ListFont";
	/**
	 * @generated
	 */
	public static final String HEADERFONT = "HeaderFont";

	/**
	 * @generated
	 */
	public PreferencesPendingList() {
    this.created = new Date();
    this.modified = new Date();
    this.isDeleted = false;
  }

 	
	
	@Basic
  private Boolean isDeleted = false;

	public Boolean getIsDeleted() {
    return isDeleted;
  }


	public void setIsDeleted(Boolean isDeleted) {
    this.isDeleted = isDeleted;
  }



	/**
	 * @generated
	 */	
 	@Basic
	private Boolean visible;
	
	/**
	 * @generated
 	 */
	public Boolean getVisible(){
    return visible; 
  }

	
	/**
	 * @generated
	 */	
	public void setVisible(Boolean newVal) {
    this.visible = newVal;
  }
	
 	
	
	/**
	 * @generated
	 */	
    @ManyToOne()
	@Where(clause="isdeleted <> 'TRUE'")
	private ColumnNames columns;
	
	/**
	 * @generated
 	 */
	public ColumnNames getColumns(){
    return columns; 
  }

	
	/**
	 * @generated
	 */	
	public void setColumns(ColumnNames newVal) {
    this.columns = newVal;
  }
	
 	
	
	/**
	 * @generated
	 */	
 	@Basic
	private Integer columnOrder;
	
	/**
	 * @generated
 	 */
	public Integer getColumnOrder(){
    return columnOrder; 
  }

	
	/**
	 * @generated
	 */	
	public void setColumnOrder(Integer newVal) {
    this.columnOrder = newVal;
  }
	
 	
	
	/**
	 * @generated
	 */	
 	@Basic
	private String pastDueColor;
	
	/**
	 * @generated
 	 */
	public String getPastDueColor(){
    return pastDueColor; 
  }

	
	/**
	 * @generated
	 */	
	public void setPastDueColor(String newVal) {
    this.pastDueColor = newVal;
  }
	
 	
	
	/**
	 * @generated
	 */	
 	@Basic
	private String readyForPickupColor;
	
	/**
	 * @generated
 	 */
	public String getReadyForPickupColor(){
    return readyForPickupColor; 
  }

	
	/**
	 * @generated
	 */	
	public void setReadyForPickupColor(String newVal) {
    this.readyForPickupColor = newVal;
  }
	
 	
	
	/**
	 * @generated
	 */	
 	@Basic
	private String invoiceColor;
	
	/**
	 * @generated
 	 */
	public String getInvoiceColor(){
    return invoiceColor; 
  }

	
	/**
	 * @generated
	 */	
	public void setInvoiceColor(String newVal) {
    this.invoiceColor = newVal;
  }
	
 	
	
	/**
	 * @generated
	 */	
 	@Basic
	private String estimateColor;
	
	/**
	 * @generated
 	 */
	public String getEstimateColor(){
    return estimateColor; 
  }

	
	/**
	 * @generated
	 */	
	public void setEstimateColor(String newVal) {
    this.estimateColor = newVal;
  }
	
 	
	
	/**
	 * @generated
	 */	
    @ManyToOne(cascade=CascadeType.ALL)
	@Where(clause="isdeleted <> 'TRUE'")
	private FontDefinition listFont;
	
	/**
	 * @generated
 	 */
	public FontDefinition getListFont(){
    return listFont; 
  }

	
	/**
	 * @generated
	 */	
	public void setListFont(FontDefinition newVal) {
    this.listFont = newVal;
  }
	
 	
	
	/**
	 * @generated
	 */	
    @ManyToOne(cascade=CascadeType.ALL)
	@Where(clause="isdeleted <> 'TRUE'")
	private FontDefinition headerFont;
	
	/**
	 * @generated
 	 */
	public FontDefinition getHeaderFont(){
    return headerFont; 
  }

	
	/**
	 * @generated
	 */	
	public void setHeaderFont(FontDefinition newVal) {
    this.headerFont = newVal;
  }
	
	/**
	 * @generated
	 */		
	@Transient
	@Override
	public Object getProperty(String propertyName) throws UnknownPropertyException {
    if (VISIBLE.equals(propertyName)) return getVisible();
    if (COLUMNS.equals(propertyName)) return getColumns();
    if (COLUMNORDER.equals(propertyName)) return getColumnOrder();
    if (PASTDUECOLOR.equals(propertyName)) return getPastDueColor();
    if (READYFORPICKUPCOLOR.equals(propertyName)) return getReadyForPickupColor();
    if (INVOICECOLOR.equals(propertyName)) return getInvoiceColor();
    if (ESTIMATECOLOR.equals(propertyName)) return getEstimateColor();
    if (LISTFONT.equals(propertyName)) return getListFont();
    if (HEADERFONT.equals(propertyName)) return getHeaderFont();
    return super.getProperty(propertyName);
  }
	
	/**
	 * @generated
	 */		
	@SuppressWarnings("unchecked")
	@Override
	public void setProperty(String propertyName, Object newValue) throws PropertyException {
    if (VISIBLE.equals(propertyName)) setVisible((Boolean)newValue); else
    if (COLUMNS.equals(propertyName)) setColumns((ColumnNames)newValue); else
    if (COLUMNORDER.equals(propertyName)) setColumnOrder((Integer)newValue); else
    if (PASTDUECOLOR.equals(propertyName)) setPastDueColor((String)newValue); else
    if (READYFORPICKUPCOLOR.equals(propertyName)) setReadyForPickupColor((String)newValue); else
    if (INVOICECOLOR.equals(propertyName)) setInvoiceColor((String)newValue); else
    if (ESTIMATECOLOR.equals(propertyName)) setEstimateColor((String)newValue); else
    if (LISTFONT.equals(propertyName)) setListFont((FontDefinition)newValue); else
    if (HEADERFONT.equals(propertyName)) setHeaderFont((FontDefinition)newValue); else
    super.setProperty(propertyName, newValue);
  }
	
	/**
	 * @generated
	 */		
	@Transient
	@Override
	public Class<?>[] getPropertyClass(String propertyName) throws UnknownPropertyException {	
    if (VISIBLE.equals(propertyName)) 
      return new Class<?>[] {Boolean.class};		
    if (COLUMNS.equals(propertyName)) 
      return new Class<?>[] {ColumnNames.class};		
    if (COLUMNORDER.equals(propertyName)) 
      return new Class<?>[] {Integer.class};		
    if (PASTDUECOLOR.equals(propertyName)) 
      return new Class<?>[] {String.class};		
    if (READYFORPICKUPCOLOR.equals(propertyName)) 
      return new Class<?>[] {String.class};		
    if (INVOICECOLOR.equals(propertyName)) 
      return new Class<?>[] {String.class};		
    if (ESTIMATECOLOR.equals(propertyName)) 
      return new Class<?>[] {String.class};		
    if (LISTFONT.equals(propertyName)) 
      return new Class<?>[] {FontDefinition.class};		
    if (HEADERFONT.equals(propertyName)) 
      return new Class<?>[] {FontDefinition.class};		
    return super.getPropertyClass(propertyName);
  }
	

	/**
	 * @generated
	 */		
	@Transient
	@Override
	public Class<?> getPropertyOwner(String propertyName) throws UnknownPropertyException {	
    if (VISIBLE.equals(propertyName)) return PreferencesPendingList.class;
    if (COLUMNS.equals(propertyName)) return PreferencesPendingList.class;
    if (COLUMNORDER.equals(propertyName)) return PreferencesPendingList.class;
    if (PASTDUECOLOR.equals(propertyName)) return PreferencesPendingList.class;
    if (READYFORPICKUPCOLOR.equals(propertyName)) return PreferencesPendingList.class;
    if (INVOICECOLOR.equals(propertyName)) return PreferencesPendingList.class;
    if (ESTIMATECOLOR.equals(propertyName)) return PreferencesPendingList.class;
    if (LISTFONT.equals(propertyName)) return PreferencesPendingList.class;
    if (HEADERFONT.equals(propertyName)) return PreferencesPendingList.class;
    return super.getPropertyOwner(propertyName);
  }
	
	/**
	 * @generated
	 */			
	@Override
	public boolean deepEquals(Object obj) {
    if (! super.deepEquals(obj))
      return false;
    PreferencesPendingList objT = (PreferencesPendingList)obj;
    if (! SmartEquals(getVisible(), objT.getVisible()))
      return false;
    if (! SmartEquals(getColumns(), objT.getColumns()))
      return false;
    if (! SmartEquals(getColumnOrder(), objT.getColumnOrder()))
      return false;
    if (! SmartEquals(getPastDueColor(), objT.getPastDueColor()))
      return false;
    if (! SmartEquals(getReadyForPickupColor(), objT.getReadyForPickupColor()))
      return false;
    if (! SmartEquals(getInvoiceColor(), objT.getInvoiceColor()))
      return false;
    if (! SmartEquals(getEstimateColor(), objT.getEstimateColor()))
      return false;
    if (! SmartEquals(getListFont(), objT.getListFont()))
      return false;
    if (! SmartEquals(getHeaderFont(), objT.getHeaderFont()))
      return false;
    return true;
  }			
}
