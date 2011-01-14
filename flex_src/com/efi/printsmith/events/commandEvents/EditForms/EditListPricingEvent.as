package com.efi.printsmith.events.commandEvents.EditForms
{
	import flash.events.Event;
	import mx.rpc.IResponder;
	import com.efi.printsmith.events.commandEvents.*;
	import com.efi.printsmith.data.PaperPrice;

	public class EditListPricingEvent extends CommandEventBase
	{
		public static const COMMANDID:String = "CMD_ListPriceSchedule";
		public var object:PaperPrice;
		
		public function EditListPricingEvent(object:PaperPrice, callbacks:IResponder=null)
		{
			this.object = object;
			super(EditListPricingEvent.COMMANDID, callbacks);
		}
		
		override public function clone():Event {
			return new EditListPricingEvent(object, callbacks);
		}
	}
}