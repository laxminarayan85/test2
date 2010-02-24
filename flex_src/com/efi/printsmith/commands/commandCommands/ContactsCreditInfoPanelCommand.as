package com.efi.printsmith.commands.commandCommands
{
	import com.adobe.cairngorm.commands.ICommand;
	import com.adobe.cairngorm.control.CairngormEvent;
	import com.efi.printsmith.events.ModelGetAllEvent;
	import com.efi.printsmith.events.commandEvents.ContactsCreditInfoPanelEvent;
	import com.efi.printsmith.business.commandDelegates.ContactsCreditInfoPanelDelegate;
	
	public class ContactsCreditInfoPanelCommand implements ICommand
	{
		public function ContactsCreditInfoPanelCommand()
		{
			
		}

		public function execute(event:CairngormEvent):void
		{
			var evtEvent:ContactsCreditInfoPanelEvent = event as ContactsCreditInfoPanelEvent;
			var delegate:ContactsCreditInfoPanelDelegate = new ContactsCreditInfoPanelDelegate(evtEvent.callbacks);
			
			delegate.handleUIEvent(evtEvent);
		}
		
	}
}