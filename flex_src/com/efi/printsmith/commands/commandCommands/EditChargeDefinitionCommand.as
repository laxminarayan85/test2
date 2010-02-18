package com.efi.printsmith.commands.commandCommands
{
	import com.adobe.cairngorm.commands.ICommand;
	import com.adobe.cairngorm.control.CairngormEvent;
	import com.efi.printsmith.events.ModelGetAllEvent;
	import com.efi.printsmith.events.commandEvents.EditChargeDefinitionEvent;
	import com.efi.printsmith.business.commandDelegates.EditChargeDefinitionDelegate;
	
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