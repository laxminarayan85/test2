package com.efi.printsmith.events.commandEvents.SystemPreferences
{
	import flash.events.Event;
	import com.efi.printsmith.events.commandEvents.*;
	import mx.containers.Canvas;
	import mx.rpc.IResponder;

	public class SystemPreferencesCashRegisterPanelEvent extends CommandEventBase
	{
		public static const COMMANDID:String = "CMD_Preferences_CashRegister";

		public var panel:Canvas;
		public var enabled:Boolean;
		
		public function SystemPreferencesCashRegisterPanelEvent(item:Canvas, callbacks:IResponder=null)
		{
			this.panel = item;
			super(SystemPreferencesCashRegisterPanelEvent.COMMANDID, callbacks);
		}
		
		override public function clone():Event {
			return new SystemPreferencesCashRegisterPanelEvent(panel, callbacks);
		}
	}
}