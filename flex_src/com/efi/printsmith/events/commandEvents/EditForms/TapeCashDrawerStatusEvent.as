package com.efi.printsmith.events.commandEvents.EditForms
{
	import flash.events.Event;
	import mx.rpc.IResponder;
	import com.efi.printsmith.events.commandEvents.*;

	public class TapeCashDrawerStatusEvent extends CommandEventBase
	{
		public static const COMMANDID:String = "CMD_TapeCashDrawerStatusEvent";
		
		public function TapeCashDrawerStatusEvent(callbacks:IResponder=null)
		{
			super(TapeCashDrawerStatusEvent.COMMANDID, callbacks);
		}
		
		override public function clone():Event {
			return new TapeCashDrawerStatusEvent(callbacks);
		}
	}
}