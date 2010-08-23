package com.efi.printsmith.pricing.charge;

import java.math.BigDecimal;

public class ChargeCostingPrices {
	public BigDecimal unitPrice;
	public BigDecimal setupPrice;
	public BigDecimal materialUnitPrice;
	public BigDecimal materialSetupPrice;
	
	public BigDecimal getUnitPrice() {
		return unitPrice;
	}
	
	public void setUnitPrice(BigDecimal unitPrice) {
		this.unitPrice = unitPrice;
	}
	
	public void setUnitPrice(double unitPrice) {
		this.unitPrice = BigDecimal.valueOf(unitPrice);
	}
	
	public BigDecimal getSetupPrice() {
		return setupPrice;
	}
	
	public void setSetupPrice(BigDecimal setupPrice) {
		this.setupPrice = setupPrice;
	}
	
	public void setSetupPrice(double setupPrice) {
		this.setupPrice = BigDecimal.valueOf(setupPrice);
	}

	public BigDecimal getMaterialUnitPrice() {
		return materialUnitPrice;
	}

	public void setMaterialUnitPrice(BigDecimal materialUnitPrice) {
		this.materialUnitPrice = materialUnitPrice;
	}

	public void setMaterialUnitPrice(double materialUnitPrice) {
		this.materialUnitPrice = BigDecimal.valueOf(materialUnitPrice);
	}

	public BigDecimal getMaterialSetupPrice() {
		return materialSetupPrice;
	}

	public void setMaterialSetupPrice(BigDecimal materialSetupPrice) {
		this.materialSetupPrice = materialSetupPrice;
	}
	
	public void setMaterialSetupPrice(double materialSetupPrice) {
		this.materialSetupPrice = BigDecimal.valueOf(materialSetupPrice);
	}
}
