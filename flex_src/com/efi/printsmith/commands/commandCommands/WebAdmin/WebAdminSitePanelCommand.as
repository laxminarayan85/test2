package com.efi.printsmith.commands.commandCommands.WebAdmin
{
	import com.adobe.cairngorm.commands.ICommand;
	import com.adobe.cairngorm.control.CairngormEvent;
	import com.efi.printsmith.events.ModelGetAllEvent;
	import com.efi.printsmith.events.commandEvents.WebAdmin.WebAdminSitePanelEvent;
	import com.efi.printsmith.business.commandDelegates.WebAdmin.WebAdminSitePanelDelegate;
	
	public class WebAdminSitePanelCommand implements ICommand
	{
		public function WebAdminSitePanelCommand()
		{
			
		}

		public function execute(event:CairngormEvent):void
		{
			var evtEvent:WebAdminSitePanelEvent = event as WebAdminSitePanelEvent;
			var delegate:WebAdminSitePanelDelegate = new WebAdminSitePanelDelegate(evtEvent.callbacks);
			
			delegate.handleUIEvent(evtEvent);
		}
		
	}
}