package com.efi.printsmith.events.commandEvents.Jobs
{
	import flash.events.Event;
	import com.efi.printsmith.events.commandEvents.*;
	import mx.controls.ComboBox;
	import mx.rpc.IResponder;

	public class JobsChangePricingMethodEvent extends CommandEventBase
	{
		public static const COMMANDID:String = "CMD_Jobs_ChangePricingMethod";

		public var control:ComboBox;
		public var enabled:Boolean;

		public function JobsChangePricingMethodEvent(item:ComboBox, callbacks:IResponder=null)
		{
			this.control = item;
			super(JobsChangePricingMethodEvent.COMMANDID, callbacks);
		}
		
		override public function clone():Event {
			return new JobsChangePricingMethodEvent(control, callbacks);
		}
	}
}