package com.efi.printsmith.commands.commandCommands.EditForms
{
	import com.adobe.cairngorm.commands.ICommand;
	import com.adobe.cairngorm.control.CairngormEvent;
	import com.efi.printsmith.events.ModelGetAllEvent;
	import com.efi.printsmith.events.commandEvents.EditForms.EditWebAdminEvent;
	import com.efi.printsmith.business.commandDelegates.EditForms.EditWebAdminDelegate;
	
	public class EditWebAdminCommand implements ICommand
	{
		public function EditWebAdminCommand()
		{
			
		}

		public function execute(event:CairngormEvent):void
		{
			var editWebAdminEvent:EditWebAdminEvent = event as EditWebAdminEvent;
			var delegate:EditWebAdminDelegate = new EditWebAdminDelegate(editWebAdminEvent.callbacks);
			
			delegate.handleUIEvent(editWebAdminEvent);
		}
		
	}
}