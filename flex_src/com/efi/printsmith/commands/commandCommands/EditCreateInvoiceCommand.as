package com.efi.printsmith.commands.commandCommands
{
	import com.adobe.cairngorm.commands.ICommand;
	import com.adobe.cairngorm.control.CairngormEvent;
	import com.efi.printsmith.events.ModelGetAllEvent;
	import com.efi.printsmith.events.commandEvents.EditCreateInvoiceEvent;
	import com.efi.printsmith.business.commandDelegates.EditCreateInvoiceDelegate;
	
	public class EditCreateInvoiceCommand implements ICommand
	{
		public function EditCreateInvoiceCommand()
		{
			
		}

		public function execute(event:CairngormEvent):void
		{
			var editCreateInvoiceEvent:EditCreateInvoiceEvent = event as EditCreateInvoiceEvent;
			var delegate:EditCreateInvoiceDelegate = new EditCreateInvoiceDelegate(editCreateInvoiceEvent.callbacks);
			
			delegate.handleUIEvent(editCreateInvoiceEvent);
		}
		
	}
}