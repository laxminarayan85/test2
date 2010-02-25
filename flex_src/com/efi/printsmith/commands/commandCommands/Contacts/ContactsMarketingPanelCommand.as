package com.efi.printsmith.commands.commandCommands.Contacts
{
	import com.adobe.cairngorm.commands.ICommand;
	import com.adobe.cairngorm.control.CairngormEvent;
	import com.efi.printsmith.events.ModelGetAllEvent;
	import com.efi.printsmith.events.commandEvents.Contacts.ContactsMarketingPanelEvent;
	import com.efi.printsmith.business.commandDelegates.Contacts.ContactsMarketingPanelDelegate;
	
	public class ContactsMarketingPanelCommand implements ICommand
	{
		public function ContactsMarketingPanelCommand()
		{
			
		}

		public function execute(event:CairngormEvent):void
		{
			var evtEvent:ContactsMarketingPanelEvent = event as ContactsMarketingPanelEvent;
			var delegate:ContactsMarketingPanelDelegate = new ContactsMarketingPanelDelegate(evtEvent.callbacks);
			
			delegate.handleUIEvent(evtEvent);
		}
		
	}
}