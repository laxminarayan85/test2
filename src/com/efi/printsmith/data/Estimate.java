
package com.efi.printsmith.data;

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
import org.hibernate.annotations.Type;

/**
 * @generated
 */

 
/**
 * @generated
 */	
@NamedQueries({
	@NamedQuery(name = "Estimate.findall", query = "from Estimate"),
	@NamedQuery(name = "Estimate.byId", query = "select a from Estimate a where a.id= :id")
})



/**
 * @generated
 */	
@Entity
@Table(name = "estimate")
public class Estimate extends InvoiceBase {

	/**
	 * @generated
	 */
	public Estimate() {
		this.created = new Date();
		this.modified = new Date();
	}
	
	public Estimate(long id, String Name, String invoiceNumber, double grandTotal) {
		this.id = id;
		this.setName(Name);
		this.setInvoiceNumber(invoiceNumber);
		this.setGrandTotal(grandTotal);
	}
	
	public Estimate(long id,  String invoiceNumber, Account account, Contact contact, String name, Double grandTotal, Date orderDate, Date wantDate, Date proofDate) {
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
	
	public Estimate(long id,  String invoiceNumber) {
		this.id = id;
		this.setInvoiceNumber(invoiceNumber);
	}
}