package com.efi.printsmith.commands.commandCommands.EditForms
{
	import com.adobe.cairngorm.commands.ICommand;
	import com.adobe.cairngorm.control.CairngormEvent;
	import com.efi.printsmith.events.ModelGetAllEvent;
	import com.efi.printsmith.events.commandEvents.EditForms.EditChargeDefinitionEvent;
	import com.efi.printsmith.business.commandDelegates.EditForms.EditChargeDefinitionDelegate;
	
	public class EditChargeDefinitionCommand implements ICommand
	{
		public function EditChargeDefinitionCommand()
		{
			
		}

		public function execute(event:CairngormEvent):void
		{
			var editChargeDefinitionEvent:EditChargeDefinitionEvent = event as EditChargeDefinitionEvent;
			var delegate:EditChargeDefinitionDelegate = new EditChargeDefinitionDelegate(editChargeDefinitionEvent.callbacks);
			
			delegate.handleUIEvent(editChargeDefinitionEvent);
		}
		
	}
}