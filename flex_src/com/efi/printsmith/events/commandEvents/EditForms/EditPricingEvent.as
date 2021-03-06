package com.efi.printsmith.events.commandEvents.EditForms
{
	import flash.events.Event;
	import mx.rpc.IResponder;
	import com.efi.printsmith.events.commandEvents.*;
	import com.efi.printsmith.data.PaperPrice;

	public class EditPricingEvent extends CommandEventBase
	{
		public static const COMMANDID:String = "CMD_PriceList";
		public var object:PaperPrice;
		
		public function EditPricingEvent(object:PaperPrice, callbacks:IResponder=null)
		{
			this.object = object;
			super(EditPricingEvent.COMMANDID, callbacks);
		}
		
		override public function clone():Event {
			return new EditPricingEvent(object, callbacks);
		}
	}
}