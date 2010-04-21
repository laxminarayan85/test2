package com.efi.printsmith.commands.commandCommands.EditForms
{
	import com.adobe.cairngorm.commands.ICommand;
	import com.adobe.cairngorm.control.CairngormEvent;
	import com.efi.printsmith.events.ModelGetAllEvent;
	import com.efi.printsmith.events.commandEvents.EditForms.EditWebLocationsEvent;
	import com.efi.printsmith.business.commandDelegates.EditForms.EditWebLocationsDelegate;
	
	public class EditWebLocationsCommand implements ICommand
	{
		public function EditWebLocationsCommand()
		{
			
		}

		public function execute(event:CairngormEvent):void
		{
			var events:EditWebLocationsEvent = event as EditWebLocationsEvent;
			var delegate:EditWebLocationsDelegate = new EditWebLocationsDelegate(events.callbacks);
			
			delegate.handleUIEvent(events);
		}
		
	}
}