package com.efi.printsmith.service;

import org.apache.log4j.Logger;

import com.efi.printsmith.data.Charge;
import com.efi.printsmith.data.ChargeDefinition;
import com.efi.printsmith.data.CuttingCharge;
import com.efi.printsmith.data.InkCharge;
import com.efi.printsmith.data.ShippingCharge;
import com.efi.printsmith.data.SquareAreaCharge;
import com.efi.printsmith.data.enums.ChargeMethod;
import com.efi.printsmith.pricing.charge.ChargeUtilities;

public class ChargeService {
	protected static Logger log = Logger.getLogger(ChargeService.class);

	public Charge createChargeFromChargeDefinition(ChargeDefinition chargeDefinition) {
		return ChargeUtilities.createChargeFromChargeDefinition(chargeDefinition);
	}
}
