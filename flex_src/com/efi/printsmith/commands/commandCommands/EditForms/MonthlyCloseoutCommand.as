package com.efi.printsmith.commands.commandCommands.EditForms
{
	import com.adobe.cairngorm.commands.ICommand;
	import com.adobe.cairngorm.control.CairngormEvent;
	import com.efi.printsmith.events.ModelGetAllEvent;
	import com.efi.printsmith.events.commandEvents.EditForms.MonthlyCloseoutEvent;
	import com.efi.printsmith.business.commandDelegates.EditForms.MonthlyCloseoutDelegate;
	
	public class MonthlyCloseoutCommand implements ICommand
	{
		public function MonthlyCloseoutCommand()
		{
			
		}

		public function execute(event:CairngormEvent):void
		{
			var eventTemp:MonthlyCloseoutEvent = event as MonthlyCloseoutEvent;
			var delegate:MonthlyCloseoutDelegate = new MonthlyCloseoutDelegate(eventTemp.callbacks);
			
			delegate.handleUIEvent(eventTemp);
		}
		
	}
}