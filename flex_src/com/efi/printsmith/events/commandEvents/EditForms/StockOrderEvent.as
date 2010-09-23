package com.efi.printsmith.events.commandEvents.EditForms
{
	import flash.events.Event;
	import mx.rpc.IResponder;
	import com.efi.printsmith.events.commandEvents.*;
	import com.efi.printsmith.data.Users;

	public class StockOrderEvent extends CommandEventBase
	{
		public static const COMMANDID:String = "CMD_StockOrder";
		public var object:Users;
		
		public function StockOrderEvent(object:Users, callbacks:IResponder=null)
		{
			this.object = object;
			super(StockOrderEvent.COMMANDID, callbacks);
		}
		
		override public function clone():Event {
			return new StockOrderEvent(object, callbacks);
		}
	}
}