package com.efi.printsmith.events.commandEvents.EditForms
{
	import flash.events.Event;
	import mx.rpc.IResponder;
	import com.efi.printsmith.events.commandEvents.*;
	import com.efi.printsmith.data.Users;

	public class VerifyCustomerBalanceEvent extends CommandEventBase
	{
		public static const COMMANDID:String = "CMD_VerifyCustomerBalance";
		public var object:Users;
		
		public function VerifyCustomerBalanceEvent(object:Users, callbacks:IResponder=null)
		{
			this.object = object;
			super(VerifyCustomerBalanceEvent.COMMANDID, callbacks);
		}
		
		override public function clone():Event {
			return new VerifyCustomerBalanceEvent(object, callbacks);
		}
	}
}