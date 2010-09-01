
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
  @NamedQuery(name = "ChargeInit.findall", query = "from ChargeInit"),
  @NamedQuery(name = "ChargeInit.byId", query = "select a from ChargeInit a where a.id= :id")
})



/**
 * @generated
 */	
@Entity
@Table(name = "chargeinit")
@SQLDelete(sql="update chargeinit set isdeleted='TRUE' where id=?")
@Where(clause="isdeleted <> 'TRUE'")
public class ChargeInit extends ModelBase {

	/**
	 * @generated
	 */
	public ChargeInit() {
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
