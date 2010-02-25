package com.efi.printsmith.commands.commandCommands.EditForms
{
	import com.adobe.cairngorm.commands.ICommand;
	import com.adobe.cairngorm.control.CairngormEvent;
	import com.efi.printsmith.events.ModelGetAllEvent;
	import com.efi.printsmith.events.commandEvents.EditForms.EditEditInvoiceEvent;
	import com.efi.printsmith.business.commandDelegates.EditForms.EditEditInvoiceDelegate;
	
	public class EditEditInvoiceCommand implements ICommand
	{
		public function EditEditInvoiceCommand()
		{
			
		}

		public function execute(event:CairngormEvent):void
		{
			var editEditInvoiceEvent:EditEditInvoiceEvent = event as EditEditInvoiceEvent;
			var delegate:EditEditInvoiceDelegate = new EditEditInvoiceDelegate(editEditInvoiceEvent.callbacks);
			
			delegate.handleUIEvent(editEditInvoiceEvent);
		}
		
	}
}