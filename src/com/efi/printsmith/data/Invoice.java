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
	@NamedQuery(name = "Invoice.findall", query = "from Invoice"),
	@NamedQuery(name = "Invoice.byId", query = "select a from Invoice a where a.id= :id")
})


@Entity
@Table(name = "invoice")
public class Invoice extends InvoiceBase {

	/**
	 * @generated
	 */
	public Invoice() {
		this.created = new Date();
		this.modified = new Date();
	}
	public Invoice(long id, String Name, String invoiceNumber, double grandTotal, String customerPO) {
		this.id = id;
		this.setName(Name);
		this.setInvoiceNumber(invoiceNumber);
		this.setGrandTotal(grandTotal);
		this.setCustomerPO(customerPO);
		
	}

}