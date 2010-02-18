package com.efi.printsmith.commands.commandCommands
{
	import com.adobe.cairngorm.commands.ICommand;
	import com.adobe.cairngorm.control.CairngormEvent;
	import com.efi.printsmith.events.ModelGetAllEvent;
	import com.efi.printsmith.events.commandEvents.EditPressDefinitionEvent;
	import com.efi.printsmith.business.commandDelegates.EditPressDefinitionDelegate;
	
	public class EditPressDefinitionCommand implements ICommand
	{
		public function EditPressDefinitionCommand()
		{
			
		}

		public function execute(event:CairngormEvent):void
		{
			var editPressDefinitionEvent:EditPressDefinitionEvent = event as EditPressDefinitionEvent;
			var delegate:EditPressDefinitionDelegate = new EditPressDefinitionDelegate(editPressDefinitionEvent.callbacks);
			
			delegate.handleUIEvent(editPressDefinitionEvent);
		}
		
	}
}