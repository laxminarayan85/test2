package com.efi.printsmith.events.commandEvents.EditForms
{
	import flash.events.Event;
	import mx.rpc.IResponder;
	import com.efi.printsmith.events.commandEvents.*;
	import com.efi.printsmith.data.Users;

	public class WasteChartEvent extends CommandEventBase
	{
		public static const COMMANDID:String = "CMD_WasteChart";
		public var object:Users;
		
		public function WasteChartEvent(object:Users, callbacks:IResponder=null)
		{
			this.object = object;
			super(WasteChartEvent.COMMANDID, callbacks);
		}
		
		override public function clone():Event {
			return new WasteChartEvent(object, callbacks);
		}
	}
}