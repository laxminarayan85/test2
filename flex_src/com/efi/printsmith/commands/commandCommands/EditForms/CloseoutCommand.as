package com.efi.printsmith.commands.commandCommands.EditForms
{
	import com.adobe.cairngorm.commands.ICommand;
	import com.adobe.cairngorm.control.CairngormEvent;
	import com.efi.printsmith.events.ModelGetAllEvent;
	import com.efi.printsmith.events.commandEvents.EditForms.CloseoutEvent;
	import com.efi.printsmith.business.commandDelegates.EditForms.CloseoutDelegate;
	
	public class CloseoutCommand implements ICommand
	{
		public function CloseoutCommand()
		{
			
		}

		public function execute(event:CairngormEvent):void
		{
			var eventTemp:CloseoutEvent = event as CloseoutEvent;
			var delegate:CloseoutDelegate = new CloseoutDelegate(eventTemp.callbacks);
			
			delegate.handleUIEvent(eventTemp);
		}
		
	}
}