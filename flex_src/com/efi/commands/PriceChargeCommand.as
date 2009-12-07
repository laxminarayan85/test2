package com.efi.commands
{
	import com.adobe.cairngorm.commands.ICommand;
	import com.adobe.cairngorm.control.CairngormEvent;
	import com.efi.business.ModelGetAllDelegate;
	import com.efi.events.ModelGetAllEvent;
	import com.efi.events.PriceChargeEvent;

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