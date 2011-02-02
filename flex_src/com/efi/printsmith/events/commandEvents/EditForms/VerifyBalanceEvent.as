package com.efi.printsmith.events.commandEvents.EditForms
{
	import flash.events.Event;
	import mx.rpc.IResponder;
	import com.efi.printsmith.events.commandEvents.*;
	import com.efi.printsmith.data.Users;

	public class VerifyBalanceEvent extends CommandEventBase
	{
		public static const COMMANDID:String = "CMD_VerifyBalance";
		public var object:Users;
		
		public function VerifyBalanceEvent(object:Users, callbacks:IResponder=null)
		{
			this.object = object;
			super(VerifyBalanceEvent.COMMANDID, callbacks);
		}
		
		override public function clone():Event {
			return new VerifyBalanceEvent(object, callbacks);
		}
	}
}