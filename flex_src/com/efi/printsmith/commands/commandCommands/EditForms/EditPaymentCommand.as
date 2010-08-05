package com.efi.printsmith.commands.commandCommands.EditForms
{
	import com.adobe.cairngorm.commands.ICommand;
	import com.adobe.cairngorm.control.CairngormEvent;
	import com.efi.printsmith.events.ModelGetAllEvent;
	import com.efi.printsmith.events.commandEvents.EditForms.EditPaymentEvent;
	import com.efi.printsmith.business.commandDelegates.EditForms.EditPaymentDelegate;
	
	public class EditPaymentCommand implements ICommand
	{
		public function EditPaymentCommand()
		{
			
		}

		public function execute(event:CairngormEvent):void
		{
			var editPaymentEvent:EditPaymentEvent = event as EditPaymentEvent;
			var delegate:EditPaymentDelegate = new EditPaymentDelegate(editPaymentEvent.callbacks);
			
			delegate.handleUIEvent(editPaymentEvent);
		}
		
	}
}