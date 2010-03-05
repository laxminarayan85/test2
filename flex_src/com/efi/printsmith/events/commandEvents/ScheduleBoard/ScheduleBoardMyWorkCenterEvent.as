package com.efi.printsmith.events.commandEvents.ScheduleBoard
{
	import flash.events.Event;
	import com.efi.printsmith.events.commandEvents.*;
	import mx.controls.Button;
	import mx.rpc.IResponder;

	public class ScheduleBoardMyWorkCenterEvent extends CommandEventBase
	{
		public static const COMMANDID:String = "CMD_ScheduleBoard_MyWorkCenter";

		public var button:Button;
		public var enabled:Boolean;

		public function ScheduleBoardMyWorkCenterEvent(item:Button, callbacks:IResponder=null)
		{
			this.button = item;
			super(ScheduleBoardMyWorkCenterEvent.COMMANDID, callbacks);
		}
		
		override public function clone():Event {
			return new ScheduleBoardMyWorkCenterEvent(button, callbacks);
		}
	}
}