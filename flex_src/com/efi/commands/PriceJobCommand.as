package com.efi.commands
{
	import com.adobe.cairngorm.commands.ICommand;
	import com.adobe.cairngorm.control.CairngormEvent;
	import com.efi.business.PricingDelegate;
	import com.efi.events.ModelGetAllEvent;
	import com.efi.events.PriceJobEvent;

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