package com.efi.printsmith.commands.commandCommands.EditForms
{
	import com.adobe.cairngorm.commands.ICommand;
	import com.adobe.cairngorm.control.CairngormEvent;
	import com.efi.printsmith.events.ModelGetAllEvent;
	import com.efi.printsmith.events.commandEvents.EditForms.EditSecurityEvent;
	import com.efi.printsmith.business.commandDelegates.EditForms.EditSecurityDelegate;
	
	public class EditSecurityCommand implements ICommand
	{
		public function EditSecurityCommand()
		{
			
		}

		public function execute(event:CairngormEvent):void
		{
			var editSecurityEvent:EditSecurityEvent = event as EditSecurityEvent;
			var delegate:EditSecurityDelegate = new EditSecurityDelegate(editSecurityEvent.callbacks);
			
			delegate.handleUIEvent(editSecurityEvent);
		}
		
	}
}