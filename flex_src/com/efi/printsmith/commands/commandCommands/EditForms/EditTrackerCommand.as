package com.efi.printsmith.commands.commandCommands.EditForms
{
	import com.adobe.cairngorm.commands.ICommand;
	import com.adobe.cairngorm.control.CairngormEvent;
	import com.efi.printsmith.events.ModelGetAllEvent;
	import com.efi.printsmith.events.commandEvents.EditForms.EditTrackerEvent;
	import com.efi.printsmith.business.commandDelegates.EditForms.EditTrackerDelegate;
	
	public class EditTrackerCommand implements ICommand
	{
		public function EditTrackerCommand()
		{
			
		}

		public function execute(event:CairngormEvent):void
		{
			var editTrackerEvent:EditTrackerEvent = event as EditTrackerEvent;
			var delegate:EditTrackerDelegate = new EditTrackerDelegate(editTrackerEvent.callbacks);
			
			delegate.handleUIEvent(editTrackerEvent);
		}
		
	}
}