package com.efi.printsmith.commands.commandCommands.Contacts
{
	import com.adobe.cairngorm.commands.ICommand;
	import com.adobe.cairngorm.control.CairngormEvent;
	import com.efi.printsmith.events.ModelGetAllEvent;
	import com.efi.printsmith.events.commandEvents.Contacts.ContactsWebPanelEvent;
	import com.efi.printsmith.business.commandDelegates.Contacts.ContactsWebPanelDelegate;
	
	public class ContactsWebPanelCommand implements ICommand
	{
		public function ContactsWebPanelCommand()
		{
			
		}

		public function execute(event:CairngormEvent):void
		{
			var evtEvent:ContactsWebPanelEvent = event as ContactsWebPanelEvent;
			var delegate:ContactsWebPanelDelegate = new ContactsWebPanelDelegate(evtEvent.callbacks);
			
			delegate.handleUIEvent(evtEvent);
		}
		
	}
}