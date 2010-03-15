package com.efi.printsmith.commands.commandCommands.WebAdmin
{
	import com.adobe.cairngorm.commands.ICommand;
	import com.adobe.cairngorm.control.CairngormEvent;
	import com.efi.printsmith.events.ModelGetAllEvent;
	import com.efi.printsmith.events.commandEvents.WebAdmin.WebAdminCatagoriesPanelEvent;
	import com.efi.printsmith.business.commandDelegates.WebAdmin.WebAdminCatagoriesPanelDelegate;
	
	public class WebAdminCatagoriesPanelCommand implements ICommand
	{
		public function WebAdminCatagoriesPanelCommand()
		{
			
		}

		public function execute(event:CairngormEvent):void
		{
			var evtEvent:WebAdminCatagoriesPanelEvent = event as WebAdminCatagoriesPanelEvent;
			var delegate:WebAdminCatagoriesPanelDelegate = new WebAdminCatagoriesPanelDelegate(evtEvent.callbacks);
			
			delegate.handleUIEvent(evtEvent);
		}
		
	}
}