package com.efi.printsmith.comparator;

import java.util.Comparator;

import com.efi.printsmith.data.InvoiceBase;

public class InvoiceBaseComparator implements Comparator<InvoiceBase>{

	public int compare(InvoiceBase o1, InvoiceBase o2) {
		if(o1==null || o2==null) {
			return 1;
		}
		if(o1.getInvoiceNumber()==null || o2.getInvoiceNumber()==null) {
			return 1;
		}
		try {
			if(Integer.parseInt(o1.getInvoiceNumber())>Integer.parseInt(o2.getInvoiceNumber())) {
				return 1;
			}
		} catch(Exception e) {
			return 1;
		}
		try {
			if(Integer.parseInt(o1.getInvoiceNumber())<Integer.parseInt(o2.getInvoiceNumber())) {
				return -1;
			}
		} catch(Exception e) {
			return 1;
		}
		return 0;
	}

}
