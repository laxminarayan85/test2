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
 * @generated
 */	
@NamedQueries({
	@NamedQuery(name = "SpeedTable.findall", query = "from SpeedTable"),
	@NamedQuery(name = "SpeedTable.byId", query = "select a from SpeedTable a where a.id= :id")
})


@Entity
@Table(name = "speedtable")
public class SpeedTable extends PriceListBase {

	/**
	 * @generated
	 */
	public SpeedTable() {
		this.created = new Date();
		this.modified = new Date();
	}

}