package com.efi.printsmith.commands.commandCommands.EditForms
{
	import com.adobe.cairngorm.commands.ICommand;
	import com.adobe.cairngorm.control.CairngormEvent;
	import com.efi.printsmith.events.ModelGetAllEvent;
	import com.efi.printsmith.events.commandEvents.EditForms.EditSystemPreferencesEvent;
	import com.efi.printsmith.business.commandDelegates.EditForms.EditSystemPreferencesDelegate;
	
	public class EditSystemPreferencesCommand implements ICommand
	{
		public function EditSystemPreferencesCommand()
		{
			
		}

		public function execute(event:CairngormEvent):void
		{
			var editSystemPreferencesEvent:EditSystemPreferencesEvent = event as EditSystemPreferencesEvent;
			var delegate:EditSystemPreferencesDelegate = new EditSystemPreferencesDelegate(editSystemPreferencesEvent.callbacks);
			
			delegate.handleUIEvent(editSystemPreferencesEvent);
		}
		
	}
}