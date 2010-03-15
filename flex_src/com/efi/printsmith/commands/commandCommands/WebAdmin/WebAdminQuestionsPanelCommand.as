package com.efi.printsmith.commands.commandCommands.WebAdmin
{
	import com.adobe.cairngorm.commands.ICommand;
	import com.adobe.cairngorm.control.CairngormEvent;
	import com.efi.printsmith.events.ModelGetAllEvent;
	import com.efi.printsmith.events.commandEvents.WebAdmin.WebAdminQuestionsPanelEvent;
	import com.efi.printsmith.business.commandDelegates.WebAdmin.WebAdminQuestionsPanelDelegate;
	
	public class WebAdminQuestionsPanelCommand implements ICommand
	{
		public function WebAdminQuestionsPanelCommand()
		{
			
		}

		public function execute(event:CairngormEvent):void
		{
			var evtEvent:WebAdminQuestionsPanelEvent = event as WebAdminQuestionsPanelEvent;
			var delegate:WebAdminQuestionsPanelDelegate = new WebAdminQuestionsPanelDelegate(evtEvent.callbacks);
			
			delegate.handleUIEvent(evtEvent);
		}
		
	}
}