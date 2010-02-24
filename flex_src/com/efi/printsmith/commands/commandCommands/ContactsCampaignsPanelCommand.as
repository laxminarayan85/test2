package com.efi.printsmith.commands.commandCommands
{
	import com.adobe.cairngorm.commands.ICommand;
	import com.adobe.cairngorm.control.CairngormEvent;
	import com.efi.printsmith.events.ModelGetAllEvent;
	import com.efi.printsmith.events.commandEvents.ContactsCampaignsPanelEvent;
	import com.efi.printsmith.business.commandDelegates.ContactsCampaignsPanelDelegate;
	
	public class ContactsCampaignsPanelCommand implements ICommand
	{
		public function ContactsCampaignsPanelCommand()
		{
			
		}

		public function execute(event:CairngormEvent):void
		{
			var evtEvent:ContactsCampaignsPanelEvent = event as ContactsCampaignsPanelEvent;
			var delegate:ContactsCampaignsPanelDelegate = new ContactsCampaignsPanelDelegate(evtEvent.callbacks);
			
			delegate.handleUIEvent(evtEvent);
		}
		
	}
}