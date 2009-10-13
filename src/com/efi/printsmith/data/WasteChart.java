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
	@NamedQuery(name = "WasteChart.findall", query = "from WasteChart"),
	@NamedQuery(name = "WasteChart.byId", query = "select a from WasteChart a where a.id= :id")
})


@Entity
@Table(name = "wastechart")
public class WasteChart extends PriceListBase {

	/**
	 * @generated
	 */
	public WasteChart() {
		this.created = new Date();
		this.modified = new Date();
	}


}