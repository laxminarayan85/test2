package com.efi.printsmith.events.commandEvents.Jobs
{
	import flash.events.Event;
	import com.efi.printsmith.events.commandEvents.*;
	import mx.controls.Button;
	import mx.rpc.IResponder;

	public class JobsChangeStockEvent extends CommandEventBase
	{
		public static const COMMANDID:String = "CMD_Jobs_ChangeStock";

		public var control:Button;
		public var enabled:Boolean;

		public function JobsChangeStockEvent(item:Button, callbacks:IResponder=null)
		{
			this.control = item;
			super(JobsChangeStockEvent.COMMANDID, callbacks);
		}
		
		override public function clone():Event {
			return new JobsChangeStockEvent(control, callbacks);
		}
	}
}