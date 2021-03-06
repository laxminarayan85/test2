
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
  @NamedQuery(name = "PreferencesStockDefinition.findall", query = "from PreferencesStockDefinition"),
  @NamedQuery(name = "PreferencesStockDefinition.byId", query = "select a from PreferencesStockDefinition a where a.id= :id")
})



/**
 * @generated
 */	
@Entity
@Table(name = "preferencesstockdefinition")
@SQLDelete(sql="update preferencesstockdefinition set isdeleted='TRUE' where id=?")
@Where(clause="isdeleted <> 'TRUE'")
public class PreferencesStockDefinition extends ModelBase {
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
	public PreferencesStockDefinition() {
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
	@Transient
	@Override
	public Object getProperty(String propertyName) throws UnknownPropertyException {
    if (VISIBLE.equals(propertyName)) return getVisible();
    if (COLUMNS.equals(propertyName)) return getColumns();
    if (COLUMNORDER.equals(propertyName)) return getColumnOrder();
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
    return super.getPropertyClass(propertyName);
  }
	

	/**
	 * @generated
	 */		
	@Transient
	@Override
	public Class<?> getPropertyOwner(String propertyName) throws UnknownPropertyException {	
    if (VISIBLE.equals(propertyName)) return PreferencesStockDefinition.class;
    if (COLUMNS.equals(propertyName)) return PreferencesStockDefinition.class;
    if (COLUMNORDER.equals(propertyName)) return PreferencesStockDefinition.class;
    return super.getPropertyOwner(propertyName);
  }
	
	/**
	 * @generated
	 */			
	@Override
	public boolean deepEquals(Object obj) {
    if (! super.deepEquals(obj))
      return false;
    PreferencesStockDefinition objT = (PreferencesStockDefinition)obj;
    if (! SmartEquals(getVisible(), objT.getVisible()))
      return false;
    if (! SmartEquals(getColumns(), objT.getColumns()))
      return false;
    if (! SmartEquals(getColumnOrder(), objT.getColumnOrder()))
      return false;
    return true;
  }			
}
