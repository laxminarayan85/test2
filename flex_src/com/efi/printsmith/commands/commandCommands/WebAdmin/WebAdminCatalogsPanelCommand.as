package com.efi.printsmith.commands.commandCommands.WebAdmin
{
	import com.adobe.cairngorm.commands.ICommand;
	import com.adobe.cairngorm.control.CairngormEvent;
	import com.efi.printsmith.events.ModelGetAllEvent;
	import com.efi.printsmith.events.commandEvents.WebAdmin.WebAdminCatalogsPanelEvent;
	import com.efi.printsmith.business.commandDelegates.WebAdmin.WebAdminCatalogsPanelDelegate;
	
	public class WebAdminCatalogsPanelCommand implements ICommand
	{
		public function WebAdminCatalogsPanelCommand()
		{
			
		}

		public function execute(event:CairngormEvent):void
		{
			var evtEvent:WebAdminCatalogsPanelEvent = event as WebAdminCatalogsPanelEvent;
			var delegate:WebAdminCatalogsPanelDelegate = new WebAdminCatalogsPanelDelegate(evtEvent.callbacks);
			
			delegate.handleUIEvent(evtEvent);
		}
		
	}
}