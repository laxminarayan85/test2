package com.efi.printsmith.commands.commandCommands
{
	import com.adobe.cairngorm.commands.ICommand;
	import com.adobe.cairngorm.control.CairngormEvent;
	import com.efi.printsmith.events.ModelGetAllEvent;
	import com.efi.printsmith.events.commandEvents.EditUserEvent;
	import com.efi.printsmith.business.commandDelegates.EditUserDelegate;
	
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