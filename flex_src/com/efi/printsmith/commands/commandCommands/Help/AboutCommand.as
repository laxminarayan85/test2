package com.efi.printsmith.commands.commandCommands.Help
{
	import com.adobe.cairngorm.commands.ICommand;
	import com.adobe.cairngorm.control.CairngormEvent;
	import com.efi.printsmith.events.ModelGetAllEvent;
	import com.efi.printsmith.events.commandEvents.Help.AboutEvent;
	import com.efi.printsmith.business.commandDelegates.Help.AboutDelegate;
	public class AboutCommand implements ICommand
	{
		public function InvoiceChargesCommand()
		{
			
		}

		public function execute(event:CairngormEvent):void
		{
			var evtEvent:AboutEvent = event as AboutEvent;
			var delegate:AboutDelegate = new AboutDelegate(evtEvent.callbacks);
			
			delegate.handleUIEvent(evtEvent);
		}
		
	}
}