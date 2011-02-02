package com.efi.printsmith.commands.commandCommands.EditForms
{
	import com.adobe.cairngorm.commands.ICommand;
	import com.adobe.cairngorm.control.CairngormEvent;
	import com.efi.printsmith.events.ModelGetAllEvent;
	import com.efi.printsmith.events.commandEvents.EditForms.GenerateStatmentEvent;
	import com.efi.printsmith.business.commandDelegates.EditForms.GenerateStatmentDelegate;
	
	public class GenerateStatmentCommand implements ICommand
	{
		public function GenerateStatmentCommand()
		{
			
		}

		public function execute(event:CairngormEvent):void
		{
			var eventTemp:GenerateStatmentEvent = event as GenerateStatmentEvent;
			var delegate:GenerateStatmentDelegate = new GenerateStatmentDelegate(eventTemp.callbacks);
			
			delegate.handleUIEvent(eventTemp);
		}
		
	}
}