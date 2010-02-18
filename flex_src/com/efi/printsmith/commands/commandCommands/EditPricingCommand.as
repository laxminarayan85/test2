package com.efi.printsmith.commands.commandCommands
{
	import com.adobe.cairngorm.commands.ICommand;
	import com.adobe.cairngorm.control.CairngormEvent;
	import com.efi.printsmith.events.ModelGetAllEvent;
	import com.efi.printsmith.events.commandEvents.EditPricingEvent;
	import com.efi.printsmith.business.commandDelegates.EditPricingDelegate;
	
	public class EditPricingCommand implements ICommand
	{
		public function EditPricingCommand()
		{
			
		}

		public function execute(event:CairngormEvent):void
		{
			var editPricingEvent:EditPricingEvent = event as EditPricingEvent;
			var delegate:EditPricingDelegate = new EditPricingDelegate(editPricingEvent.callbacks);
			
			delegate.handleUIEvent(editPricingEvent);
		}
		
	}
}