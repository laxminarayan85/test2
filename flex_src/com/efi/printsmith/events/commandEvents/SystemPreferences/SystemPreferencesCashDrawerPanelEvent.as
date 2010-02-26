package com.efi.printsmith.events.commandEvents.SystemPreferences
{
	import flash.events.Event;
	import com.efi.printsmith.events.commandEvents.*;
	import mx.containers.Canvas;
	import mx.rpc.IResponder;

	public class SystemPreferencesCashDrawerPanelEvent extends CommandEventBase
	{
		public static const COMMANDID:String = "CMD_Preferences_CashDrawer";

		public var panel:Canvas;
		public var enabled:Boolean;
		
		public function SystemPreferencesCashDrawerPanelEvent(item:Canvas, callbacks:IResponder=null)
		{
			this.panel = item;
			super(SystemPreferencesCashDrawerPanelEvent.COMMANDID, callbacks);
		}
		
		override public function clone():Event {
			return new SystemPreferencesCashDrawerPanelEvent(panel, callbacks);
		}
	}
}