package com.efi.printsmith.events.commandEvents.EditForms
{
	import flash.events.Event;
	import mx.rpc.IResponder;
	import com.efi.printsmith.events.commandEvents.*;
	import com.efi.printsmith.data.Users;

	public class SalesTaxEvent extends CommandEventBase
	{
		public static const COMMANDID:String = "CMD_SalesTax";
		public var object:Users;
		
		public function SalesTaxEvent(object:Users, callbacks:IResponder=null)
		{
			this.object = object;
			super(SalesTaxEvent.COMMANDID, callbacks);
		}
		
		override public function clone():Event {
			return new SalesTaxEvent(object, callbacks);
		}
	}
}