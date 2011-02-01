package com.efi.printsmith.events.commandEvents.EditForms
{
	import flash.events.Event;
	import mx.rpc.IResponder;
	import com.efi.printsmith.events.commandEvents.*;
	import com.efi.printsmith.data.StockOrder;

	public class OrderStockEvent extends CommandEventBase
	{
		public static const COMMANDID:String = "CMD_OrderStock";
		public var object:StockOrder;
		
		public function OrderStockEvent(object:StockOrder, callbacks:IResponder=null)
		{
			this.object = object;
			super(OrderStockEvent.COMMANDID, callbacks);
		}
		
		override public function clone():Event {
			return new OrderStockEvent(object, callbacks);
		}
	}
}