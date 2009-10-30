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
	@NamedQuery(name = "PreferencesPendingList.findall", query = "from PreferencesPendingList"),
	@NamedQuery(name = "PreferencesPendingList.byId", query = "select a from PreferencesPendingList a where a.id= :id")
})


@Entity
@Table(name = "preferencespendinglist")
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
	public PreferencesPendingList() {
		this.created = new Date();
		this.modified = new Date();
	}

 	
	
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
 	
	
    @ManyToOne( cascade = {CascadeType.PERSIST, CascadeType.MERGE} )
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
	@Transient
	@Override
	public Object getProperty(String propertyName) throws UnknownPropertyException {
		if (VISIBLE.equals(propertyName)) return getVisible();
		if (COLUMNS.equals(propertyName)) return getColumns();
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
		return true;
	}			
}