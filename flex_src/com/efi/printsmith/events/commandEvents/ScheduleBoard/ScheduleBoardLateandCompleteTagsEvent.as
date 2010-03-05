package com.efi.printsmith.events.commandEvents.ScheduleBoard
{
	import flash.events.Event;
	import com.efi.printsmith.events.commandEvents.*;
	import mx.controls.Button;
	import mx.rpc.IResponder;

	public class ScheduleBoardLateandCompleteTagsEvent extends CommandEventBase
	{
		public static const COMMANDID:String = "CMD_ScheduleBoard_LateandCompleteTags";

		public var button:Button;
		public var enabled:Boolean;

		public function ScheduleBoardLateandCompleteTagsEvent(item:Button, callbacks:IResponder=null)
		{
			this.button = item;
			super(ScheduleBoardLateandCompleteTagsEvent.COMMANDID, callbacks);
		}
		
		override public function clone():Event {
			return new ScheduleBoardLateandCompleteTagsEvent(button, callbacks);
		}
	}
}