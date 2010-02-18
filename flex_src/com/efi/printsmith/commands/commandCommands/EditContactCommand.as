package com.efi.printsmith.commands.commandCommands
{
	import com.adobe.cairngorm.commands.ICommand;
	import com.adobe.cairngorm.control.CairngormEvent;
	import com.efi.printsmith.events.ModelGetAllEvent;
	import com.efi.printsmith.events.commandEvents.EditContactEvent;
	import com.efi.printsmith.business.commandDelegates.EditContactDelegate;
	
	public class EditContactCommand implements ICommand
	{
		public function EditContactCommand()
		{
			
		}

		public function execute(event:CairngormEvent):void
		{
			var editContactEvent:EditContactEvent = event as EditContactEvent;
			var delegate:EditContactDelegate = new EditContactDelegate(editContactEvent.callbacks);
			
			delegate.handleUIEvent(editContactEvent);
		}
		
	}
}