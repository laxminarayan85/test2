package com.efi.printsmith.commands.commandCommands.WebAdmin
{
	import com.adobe.cairngorm.commands.ICommand;
	import com.adobe.cairngorm.control.CairngormEvent;
	import com.efi.printsmith.events.ModelGetAllEvent;
	import com.efi.printsmith.events.commandEvents.WebAdmin.WebAdminProductsPanelEvent;
	import com.efi.printsmith.business.commandDelegates.WebAdmin.WebAdminProductsPanelDelegate;
	
	public class WebAdminProductsPanelCommand implements ICommand
	{
		public function WebAdminProductsPanelCommand()
		{
			
		}

		public function execute(event:CairngormEvent):void
		{
			var evtEvent:WebAdminProductsPanelEvent = event as WebAdminProductsPanelEvent;
			var delegate:WebAdminProductsPanelDelegate = new WebAdminProductsPanelDelegate(evtEvent.callbacks);
			
			delegate.handleUIEvent(evtEvent);
		}
		
	}
}