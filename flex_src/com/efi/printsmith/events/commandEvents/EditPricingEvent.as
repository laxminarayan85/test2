package com.efi.printsmith.events.commandEvents
{
	import flash.events.Event;
	import mx.rpc.IResponder;
	import com.efi.printsmith.data.ModelBase;
	import com.efi.printsmith.data.PriceList;

	public class EditPricingEvent extends CommandEventBase
	{
		public static const COMMANDID:String = "CMD_PriceList";
		public var object:PriceList;
		
		public function EditPricingEvent(object:PriceList, callbacks:IResponder=null)
		{
			this.object = object;
			super(EditPricingEvent.COMMANDID, callbacks);
		}
		
		override public function clone():Event {
			return new EditPricingEvent(object, callbacks);
		}
	}
}