
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
  @NamedQuery(name = "QuantityDiscount.findall", query = "from QuantityDiscount"),
  @NamedQuery(name = "QuantityDiscount.byId", query = "select a from QuantityDiscount a where a.id= :id")
})



/**
 * @generated
 */	
@Entity
@Table(name = "quantitydiscount")
@SQLDelete(sql="update modelbase set isdeleted='TRUE' from quantitydiscount where modelbase.id=?")
@Where(clause="isdeleted <> 'TRUE'")
public class QuantityDiscount extends PriceListBase {

	/**
	 * @generated
	 */
	public QuantityDiscount() {
    this.created = new Date();
    this.modified = new Date();
    this.isDeleted = false;
  }

}
