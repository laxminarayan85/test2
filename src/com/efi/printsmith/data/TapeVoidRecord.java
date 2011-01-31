
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
  @NamedQuery(name = "TapeVoidRecord.findall", query = "from TapeVoidRecord"),
  @NamedQuery(name = "TapeVoidRecord.byId", query = "select a from TapeVoidRecord a where a.id= :id")
})



/**
 * @generated
 */	
@Entity
@Table(name = "tapevoidrecord")
//@SQLDelete(sql="update modelbase set isdeleted='TRUE' from tapevoidrecord where modelbase.id=?")
@SQLDelete(sql="update tapevoidrecord set isdeleted='TRUE' where id=?")
//Filter added to retrieve only records that have not been soft deleted.
@Where(clause="isdeleted <> 'TRUE'")
public class TapeVoidRecord extends Transaction {

	/**
	 * @generated
	 */
	public TapeVoidRecord() {
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
}
