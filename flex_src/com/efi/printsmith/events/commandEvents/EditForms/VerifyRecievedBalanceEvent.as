package com.efi.printsmith.events.commandEvents.EditForms
{
	import flash.events.Event;
	import mx.rpc.IResponder;
	import com.efi.printsmith.events.commandEvents.*;
	import com.efi.printsmith.data.Users;

	public class VerifyRecievedBalanceEvent extends CommandEventBase
	{
		public static const COMMANDID:String = "CMD_VerifyRecievedBalance";
		public var object:Users;
		
		public function VerifyRecievedBalanceEvent(object:Users, callbacks:IResponder=null)
		{
			this.object = object;
			super(VerifyRecievedBalanceEvent.COMMANDID, callbacks);
		}
		
		override public function clone():Event {
			return new VerifyRecievedBalanceEvent(object, callbacks);
		}
	}
}