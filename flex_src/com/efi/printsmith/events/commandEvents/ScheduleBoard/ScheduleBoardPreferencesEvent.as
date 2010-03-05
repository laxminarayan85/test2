package com.efi.printsmith.events.commandEvents.ScheduleBoard
{
	import flash.events.Event;
	import com.efi.printsmith.events.commandEvents.*;
	import mx.controls.Button;
	import mx.rpc.IResponder;

	public class ScheduleBoardPreferencesEvent extends CommandEventBase
	{
		public static const COMMANDID:String = "CMD_ScheduleBoard_Preferences";

		public var button:Button;
		public var enabled:Boolean;

		public function ScheduleBoardPreferencesEvent(item:Button, callbacks:IResponder=null)
		{
			this.button = item;
			super(ScheduleBoardPreferencesEvent.COMMANDID, callbacks);
		}
		
		override public function clone():Event {
			return new ScheduleBoardPreferencesEvent(button, callbacks);
		}
	}
}