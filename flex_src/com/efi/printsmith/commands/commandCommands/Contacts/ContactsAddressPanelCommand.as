package com.efi.printsmith.commands.commandCommands.Contacts
{
	import com.adobe.cairngorm.commands.ICommand;
	import com.adobe.cairngorm.control.CairngormEvent;
	import com.efi.printsmith.events.ModelGetAllEvent;
	import com.efi.printsmith.events.commandEvents.Contacts.ContactsAddressPanelEvent;
	import com.efi.printsmith.business.commandDelegates.Contacts.ContactsAddressPanelDelegate;
	
	public class ContactsAddressPanelCommand implements ICommand
	{
		public function ContactsAddressPanelCommand()
		{
			
		}

		public function execute(event:CairngormEvent):void
		{
			var evtEvent:ContactsAddressPanelEvent = event as ContactsAddressPanelEvent;
			var delegate:ContactsAddressPanelDelegate = new ContactsAddressPanelDelegate(evtEvent.callbacks);
			
			delegate.handleUIEvent(evtEvent);
		}
		
	}
}