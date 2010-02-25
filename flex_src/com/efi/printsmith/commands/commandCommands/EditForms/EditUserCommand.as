package com.efi.printsmith.commands.commandCommands.EditForms
{
	import com.adobe.cairngorm.commands.ICommand;
	import com.adobe.cairngorm.control.CairngormEvent;
	import com.efi.printsmith.events.ModelGetAllEvent;
	import com.efi.printsmith.events.commandEvents.EditForms.EditUserEvent;
	import com.efi.printsmith.business.commandDelegates.EditForms.EditUserDelegate;
	
	public class EditUserCommand implements ICommand
	{
		public function EditUserCommand()
		{
			
		}

		public function execute(event:CairngormEvent):void
		{
			var editUserEvent:EditUserEvent = event as EditUserEvent;
			var delegate:EditUserDelegate = new EditUserDelegate(editUserEvent.callbacks);
			
			delegate.handleUIEvent(editUserEvent);
		}
		
	}
}