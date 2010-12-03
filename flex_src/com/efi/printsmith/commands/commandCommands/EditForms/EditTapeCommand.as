package com.efi.printsmith.commands.commandCommands.EditForms
{
	import com.adobe.cairngorm.commands.ICommand;
	import com.adobe.cairngorm.control.CairngormEvent;
	import com.efi.printsmith.events.ModelGetAllEvent;
	import com.efi.printsmith.events.commandEvents.EditForms.EditTapeEvent;
	import com.efi.printsmith.business.commandDelegates.EditForms.EditTapeDelegate;
	
	public class EditTapeCommand implements ICommand
	{
		public function EditTapeCommand()
		{
			
		}

		public function execute(event:CairngormEvent):void
		{
			var editTapeEvent:EditTapeEvent = event as EditTapeEvent;
			var delegate:EditTapeDelegate = new EditTapeDelegate(editTapeEvent.callbacks);
			
			delegate.handleUIEvent(editTapeEvent);
		}
		
	}
}