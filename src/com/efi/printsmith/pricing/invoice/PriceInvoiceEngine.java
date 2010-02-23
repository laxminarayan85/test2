package com.efi.printsmith.pricing.invoice;

import com.efi.printsmith.data.Invoice;

public interface PriceInvoiceEngine {
	public Invoice priceInvoice(Invoice invoice);
}
