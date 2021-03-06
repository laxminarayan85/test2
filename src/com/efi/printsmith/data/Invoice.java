
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
  @NamedQuery(name = "Invoice.findall", query = "from Invoice"),
  @NamedQuery(name = "Invoice.byId", query = "select a from Invoice a where a.id= :id")
})



/**
 * @generated
 */	
@Entity
@Table(name = "invoice")
@SQLDelete(sql="update invoice set isdeleted='TRUE' where id=?")
@Where(clause="isdeleted <> 'TRUE'")
public class Invoice extends InvoiceBase {

	/**
	 * @generated
	 */
	public Invoice() {
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

	public Invoice(long id, String Name, String invoiceNumber, BigDecimal grandTotal, String customerPO) {
		this.id = id;
		this.setName(Name);
		this.setInvoiceNumber(invoiceNumber);
		this.setGrandTotal(grandTotal);
		this.setCustomerPO(customerPO);
	}
	
	public Invoice(long id,  String invoiceNumber, Account account, Contact contact,String name, Double grandTotal, Date orderDate, Date wantDate, Date proofDate) {
		this.id = id;
		this.setInvoiceNumber(invoiceNumber);
		this.setName(name);
		this.setGrandTotal(grandTotal);
		this.setOrderedDate(orderDate);
		this.setWantedDate(wantDate);
		this.setProofDate(proofDate);
		this.setAccount(account);
		this.setContact(contact);
	}	
	
	public Invoice(long id,  String invoiceNumber) {
		this.id = id;
		this.setInvoiceNumber(invoiceNumber);
	}
}
