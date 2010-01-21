package com.efi.printsmith.commands
{
	import com.adobe.cairngorm.commands.ICommand;
	import com.adobe.cairngorm.control.CairngormEvent;
	import com.efi.printsmith.business.PricingDelegate;
	import com.efi.printsmith.events.ModelGetAllEvent;
	import com.efi.printsmith.events.PriceJobEvent;

	public class PriceJobCommand implements ICommand
	{
		public function PriceJobCommand()
		{
		}

		public function execute(event:CairngormEvent):void
		{
			var priceJobEvent:PriceJobEvent = event as PriceJobEvent;
			var delegate:PricingDelegate = new PricingDelegate(priceJobEvent.callbacks);
			
			delegate.priceJob(priceJobEvent.job);
		}
		
	}
}