package com.efi.printsmith.commands.commandCommands
{
	import com.adobe.cairngorm.commands.ICommand;
	import com.adobe.cairngorm.control.CairngormEvent;
	import com.efi.printsmith.events.ModelGetAllEvent;
	import com.efi.printsmith.events.commandEvents.EditSystemPreferencesEvent;
	import com.efi.printsmith.business.commandDelegates.EditSystemPreferencesDelegate;
	
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