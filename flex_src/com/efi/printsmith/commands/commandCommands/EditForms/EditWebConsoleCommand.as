package com.efi.printsmith.commands.commandCommands.EditForms
{
	import com.adobe.cairngorm.commands.ICommand;
	import com.adobe.cairngorm.control.CairngormEvent;
	import com.efi.printsmith.events.ModelGetAllEvent;
	import com.efi.printsmith.events.commandEvents.EditForms.EditWebConsoleEvent;
	import com.efi.printsmith.business.commandDelegates.EditForms.EditWebConsoleDelegate;
	
	public class EditWebConsoleCommand implements ICommand
	{
		public function EditWebConsoleCommand()
		{
			
		}

		public function execute(event:CairngormEvent):void
		{
			var events:EditWebConsoleEvent = event as EditWebConsoleEvent;
			var delegate:EditWebConsoleDelegate = new EditWebConsoleDelegate(events.callbacks);
			
			delegate.handleUIEvent(events);
		}
		
	}
}