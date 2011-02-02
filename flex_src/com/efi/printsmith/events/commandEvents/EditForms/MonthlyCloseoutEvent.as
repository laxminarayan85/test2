package com.efi.printsmith.events.commandEvents.EditForms
{
	import flash.events.Event;
	import mx.rpc.IResponder;
	import com.efi.printsmith.events.commandEvents.*;
	import com.efi.printsmith.data.Users;

	public class MonthlyCloseoutEvent extends CommandEventBase
	{
		public static const COMMANDID:String = "CMD_MonthlyCloseout";
		public var object:Users;
		
		public function MonthlyCloseoutEvent(object:Users, callbacks:IResponder=null)
		{
			this.object = object;
			super(MonthlyCloseoutEvent.COMMANDID, callbacks);
		}
		
		override public function clone():Event {
			return new MonthlyCloseoutEvent(object, callbacks);
		}
	}
}