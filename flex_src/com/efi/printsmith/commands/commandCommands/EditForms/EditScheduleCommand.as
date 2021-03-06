package com.efi.printsmith.commands.commandCommands.EditForms
{
	import com.adobe.cairngorm.commands.ICommand;
	import com.adobe.cairngorm.control.CairngormEvent;
	import com.efi.printsmith.events.ModelGetAllEvent;
	import com.efi.printsmith.events.commandEvents.EditForms.EditScheduleEvent;
	import com.efi.printsmith.business.commandDelegates.EditForms.EditScheduleDelegate;
	
	public class EditScheduleCommand implements ICommand
	{
		public function EditScheduleCommand()
		{
			
		}

		public function execute(event:CairngormEvent):void
		{
			var editScheduleEvent:EditScheduleEvent = event as EditScheduleEvent;
			var delegate:EditScheduleDelegate = new EditScheduleDelegate(editScheduleEvent.callbacks);
			
			delegate.handleUIEvent(editScheduleEvent);
		}
		
	}
}