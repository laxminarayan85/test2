package com.efi.printsmith.events.commandEvents.ScheduleBoard
{
	import flash.events.Event;
	import com.efi.printsmith.events.commandEvents.*;
	import mx.controls.Button;
	import mx.rpc.IResponder;

	public class ScheduleBoardShowCostCentersEvent extends CommandEventBase
	{
		public static const COMMANDID:String = "CMD_ScheduleBoard_ShowCostCenters";

		public var button:Button;
		public var enabled:Boolean;

		public function ScheduleBoardShowCostCentersEvent(item:Button, callbacks:IResponder=null)
		{
			this.button = item;
			super(ScheduleBoardShowCostCentersEvent.COMMANDID, callbacks);
		}
		
		override public function clone():Event {
			return new ScheduleBoardShowCostCentersEvent(button, callbacks);
		}
	}
}