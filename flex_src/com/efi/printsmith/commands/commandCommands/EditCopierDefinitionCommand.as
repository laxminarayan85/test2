package com.efi.printsmith.commands.commandCommands
{
	import com.adobe.cairngorm.commands.ICommand;
	import com.adobe.cairngorm.control.CairngormEvent;
	import com.efi.printsmith.events.ModelGetAllEvent;
	import com.efi.printsmith.events.commandEvents.EditCopierDefinitionEvent;
	import com.efi.printsmith.business.commandDelegates.EditCopierDefinitionDelegate;
	
	public class EditCopierDefinitionCommand implements ICommand
	{
		public function EditCopierDefinitionCommand()
		{
			
		}

		public function execute(event:CairngormEvent):void
		{
			var editCopierDefinitionEvent:EditCopierDefinitionEvent = event as EditCopierDefinitionEvent;
			var delegate:EditCopierDefinitionDelegate = new EditCopierDefinitionDelegate(editCopierDefinitionEvent.callbacks);
			
			delegate.handleUIEvent(editCopierDefinitionEvent);
		}
		
	}
}