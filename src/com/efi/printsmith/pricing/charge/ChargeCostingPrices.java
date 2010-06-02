package com.efi.printsmith.pricing.charge;

public class ChargeCostingPrices {
	public double unitPrice;
	public double setupPrice;
	public double materialUnitPrice;
	public double materialSetupPrice;
	
	public double getUnitPrice() {
		return unitPrice;
	}
	
	public void setUnitPrice(double unitPrice) {
		this.unitPrice = unitPrice;
	}
	
	public double getSetupPrice() {
		return setupPrice;
	}
	
	public void setSetupPrice(double setupPrice) {
		this.setupPrice = setupPrice;
	}

	public double getMaterialUnitPrice() {
		return materialUnitPrice;
	}

	public void setMaterialUnitPrice(double materialUnitPrice) {
		this.materialUnitPrice = materialUnitPrice;
	}

	public double getMaterialSetupPrice() {
		return materialSetupPrice;
	}

	public void setMaterialSetupPrice(double materialSetupPrice) {
		this.materialSetupPrice = materialSetupPrice;
	}
}
