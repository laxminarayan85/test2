package com.efi.printsmith.commands
{
	import com.adobe.cairngorm.commands.ICommand;
	import com.adobe.cairngorm.control.CairngormEvent;
	import com.efi.printsmith.business.PricingDelegate;
	import com.efi.printsmith.events.ModelGetAllEvent;
	import com.efi.printsmith.events.PriceChargeEvent;

	public class PriceChargeCommand implements ICommand
	{
		public function PriceChargeCommand()
		{
		}

		public function execute(event:CairngormEvent):void
		{
			var priceChargeEvent:PriceChargeEvent = event as PriceChargeEvent;
			var delegate:PricingDelegate = new PricingDelegate(priceChargeEvent.callbacks);
			
			delegate.priceCharge(priceChargeEvent.charge);
		}
		
	}
}