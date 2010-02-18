package com.efi.printsmith.commands.commandCommands
{
	import com.adobe.cairngorm.commands.ICommand;
	import com.adobe.cairngorm.control.CairngormEvent;
	import com.efi.printsmith.events.ModelGetAllEvent;
	import com.efi.printsmith.events.commandEvents.EditEmployeeEvent;
	import com.efi.printsmith.business.commandDelegates.EditEmployeeDelegate;
	
	public class EditEmployeeCommand implements ICommand
	{
		public function EditEmployeeCommand()
		{
			
		}

		public function execute(event:CairngormEvent):void
		{
			var editEmployeeEvent:EditEmployeeEvent = event as EditEmployeeEvent;
			var delegate:EditEmployeeDelegate = new EditEmployeeDelegate(editEmployeeEvent.callbacks);
			
			delegate.handleUIEvent(editEmployeeEvent);
		}
		
	}
}