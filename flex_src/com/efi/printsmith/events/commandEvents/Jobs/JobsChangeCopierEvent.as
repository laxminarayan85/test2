package com.efi.printsmith.events.commandEvents.Jobs
{
	import flash.events.Event;
	import com.efi.printsmith.events.commandEvents.*;
	import mx.controls.ComboBox;
	import mx.rpc.IResponder;

	public class JobsChangeCopierEvent extends CommandEventBase
	{
		public static const COMMANDID:String = "CMD_Jobs_ChangePress";

		public var control:ComboBox;
		public var enabled:Boolean;

		public function JobsChangeCopierEvent(item:ComboBox, callbacks:IResponder=null)
		{
			this.control = item;
			super(JobsChangeCopierEvent.COMMANDID, callbacks);
		}
		
		override public function clone():Event {
			return new JobsChangeCopierEvent(control, callbacks);
		}
	}
}