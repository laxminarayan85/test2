package com.efi.printsmith.commands.commandCommands.WebAdmin
{
	import com.adobe.cairngorm.commands.ICommand;
	import com.adobe.cairngorm.control.CairngormEvent;
	import com.efi.printsmith.events.ModelGetAllEvent;
	import com.efi.printsmith.events.commandEvents.WebAdmin.WebAdminAdminPanelEvent;
	import com.efi.printsmith.business.commandDelegates.WebAdmin.WebAdminAdminPanelDelegate;
	
	public class WebAdminAdminPanelCommand implements ICommand
	{
		public function WebAdminAdminPanelCommand()
		{
			
		}

		public function execute(event:CairngormEvent):void
		{
			var evtEvent:WebAdminAdminPanelEvent = event as WebAdminAdminPanelEvent;
			var delegate:WebAdminAdminPanelDelegate = new WebAdminAdminPanelDelegate(evtEvent.callbacks);
			
			delegate.handleUIEvent(evtEvent);
		}
		
	}
}