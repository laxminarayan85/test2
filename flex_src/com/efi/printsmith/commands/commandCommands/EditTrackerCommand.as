package com.efi.printsmith.commands.commandCommands
{
	import com.adobe.cairngorm.commands.ICommand;
	import com.adobe.cairngorm.control.CairngormEvent;
	import com.efi.printsmith.events.ModelGetAllEvent;
	import com.efi.printsmith.events.commandEvents.EditTrackerEvent;
	import com.efi.printsmith.business.commandDelegates.EditTrackerDelegate;
	
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