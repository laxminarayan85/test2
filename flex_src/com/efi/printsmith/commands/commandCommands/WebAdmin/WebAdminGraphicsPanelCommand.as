package com.efi.printsmith.commands.commandCommands.WebAdmin
{
	import com.adobe.cairngorm.commands.ICommand;
	import com.adobe.cairngorm.control.CairngormEvent;
	import com.efi.printsmith.events.ModelGetAllEvent;
	import com.efi.printsmith.events.commandEvents.WebAdmin.WebAdminGraphicsPanelEvent;
	import com.efi.printsmith.business.commandDelegates.WebAdmin.WebAdminGraphicsPanelDelegate;
	
	public class WebAdminGraphicsPanelCommand implements ICommand
	{
		public function WebAdminGraphicsPanelCommand()
		{
			
		}

		public function execute(event:CairngormEvent):void
		{
			var evtEvent:WebAdminGraphicsPanelEvent = event as WebAdminGraphicsPanelEvent;
			var delegate:WebAdminGraphicsPanelDelegate = new WebAdminGraphicsPanelDelegate(evtEvent.callbacks);
			
			delegate.handleUIEvent(evtEvent);
		}
		
	}
}