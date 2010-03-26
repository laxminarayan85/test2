package com.efi.printsmith.events.commandEvents.EditForms
{
	import flash.events.Event;
	import mx.rpc.IResponder;
	import com.efi.printsmith.events.commandEvents.*;
	import com.efi.printsmith.data.TimeCard;

	public class EditClockInOutEvent extends CommandEventBase
	{
		public static const COMMANDID:String = "CMD_Employee_ClockInOut";
		public var object:TimeCard;
		
		public function EditClockInOutEvent(object:TimeCard, callbacks:IResponder=null)
		{
			this.object = object;
			super(EditClockInOutEvent.COMMANDID, callbacks);
		}
		
		override public function clone():Event {
			return new EditClockInOutEvent(object, callbacks);
		}
	}
}