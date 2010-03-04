package com.efi.printsmith.events.commandEvents.Jobs
{
	import flash.events.Event;
	import com.efi.printsmith.events.commandEvents.*;
	import com.adobe.flex.extras.controls.AutoComplete
	import mx.rpc.IResponder;

	public class JobsChangePressEvent extends CommandEventBase
	{
		public static const COMMANDID:String = "CMD_Jobs_ChangePress";

		public var control:AutoComplete;
		public var enabled:Boolean;

		public function JobsChangePressEvent(item:AutoComplete, callbacks:IResponder=null)
		{
			this.control = item;
			super(JobsChangePressEvent.COMMANDID, callbacks);
		}
		
		override public function clone():Event {
			return new JobsChangePressEvent(control, callbacks);
		}
	}
}