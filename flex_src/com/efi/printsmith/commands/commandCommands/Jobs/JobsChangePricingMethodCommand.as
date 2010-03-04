package com.efi.printsmith.commands.commandCommands.Jobs
{
	import com.adobe.cairngorm.commands.ICommand;
	import com.adobe.cairngorm.control.CairngormEvent;
	import com.efi.printsmith.events.ModelGetAllEvent;
	import com.efi.printsmith.events.commandEvents.Invoice.JobsChangePricingMethodEvent;
	import com.efi.printsmith.business.commandDelegates.Invoice.JobsChangePricingMethodDelegate;
	
	public class JobsChangePricingMethodCommand implements ICommand
	{
		public function JobsChangePricingMethodCommand()
		{
			
		}

		public function execute(event:CairngormEvent):void
		{
			var evtEvent:JobsChangePricingMethodEvent = event as JobsChangePricingMethodEvent;
			var delegate:JobsChangePricingMethodDelegate = new JobsChangePricingMethodDelegate(evtEvent.callbacks);
			
			delegate.handleUIEvent(evtEvent);
		}
		
	}
}