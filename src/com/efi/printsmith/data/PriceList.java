
package com.efi.printsmith.data;

import java.util.Date;
import javax.persistence.*;

import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.Where;

/**
 * @generated
 */

 
/**
 * @generated
 */	
@NamedQueries({
  @NamedQuery(name = "PriceList.findall", query = "from PriceList"),
  @NamedQuery(name = "PriceList.byId", query = "select a from PriceList a where a.id= :id")
})



/**
 * @generated
 */	
@Entity
@Table(name = "pricelist")
@SQLDelete(sql="update pricelist set isdeleted='TRUE' where id=?")
@Where(clause="isdeleted <> 'TRUE'")
public class PriceList extends PriceListBase {

	/**
	 * @generated
	 */
	public PriceList() {
    this.created = new Date();
    this.modified = new Date();
    this.isDeleted = false;
  }

	@Basic
  private Boolean isDeleted = false;

	@Override
	public Boolean getIsDeleted() {
    return isDeleted;
  }

	@Override
	public void setIsDeleted(Boolean isDeleted) {
    this.isDeleted = isDeleted;
  }

}
