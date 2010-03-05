package com.efi.printsmith.events.commandEvents.ScheduleBoard
{
	import flash.events.Event;
	import com.efi.printsmith.events.commandEvents.*;
	import mx.controls.Button;
	import mx.rpc.IResponder;

	public class ScheduleBoardEditCostCentersEvent extends CommandEventBase
	{
		public static const COMMANDID:String = "CMD_ScheduleBoard_EditCostCenters";

		public var button:Button;
		public var enabled:Boolean;

		public function ScheduleBoardEditCostCentersEvent(item:Button, callbacks:IResponder=null)
		{
			this.button = item;
			super(ScheduleBoardEditCostCentersEvent.COMMANDID, callbacks);
		}
		
		override public function clone():Event {
			return new ScheduleBoardEditCostCentersEvent(button, callbacks);
		}
	}
}