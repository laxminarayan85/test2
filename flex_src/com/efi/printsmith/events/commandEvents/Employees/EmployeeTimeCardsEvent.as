package com.efi.printsmith.events.commandEvents.Employees
{
	import flash.events.Event;
	import com.efi.printsmith.events.commandEvents.*;
	import mx.controls.Button;
	import mx.rpc.IResponder;

	public class EmployeeTimeCardsEvent extends CommandEventBase
	{
		public static const COMMANDID:String = "CMD_Employee_TimeCards";

		public var button:Button;
		public var enabled:Boolean;

		public function EmployeeTimeCardsEvent(item:Button, callbacks:IResponder=null)
		{
			this.button = item;
			super(EmployeeTimeCardsEvent.COMMANDID, callbacks);
		}
		
		override public function clone():Event {
			return new EmployeeTimeCardsEvent(button, callbacks);
		}
	}
}