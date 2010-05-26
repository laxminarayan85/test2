package com.efi.printsmith.integration.xpedx;

public class XpedxStockCheckRequestParams {
	public Long id;
	public String xpedxId;
	public Long qty;
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getXpedxId() {
		return xpedxId;
	}
	public void setXpedxId(String xpedxId) {
		this.xpedxId = xpedxId;
	}
	public Long getQty() {
		return qty;
	}
	public void setQty(Long qty) {
		this.qty = qty;
	}
}
