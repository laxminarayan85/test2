package com.efi.printsmith.events.commandEvents.SystemPreferences
{
	import flash.events.Event;
	import com.efi.printsmith.events.commandEvents.*;
	import mx.containers.Canvas;
	import mx.rpc.IResponder;

	public class SystemPreferencesQuantityBreaksPanelEvent extends CommandEventBase
	{
		public static const COMMANDID:String = "CMD_Preferences_QuantityBreaks";

		public var panel:Canvas;
		public var enabled:Boolean;
		
		public function SystemPreferencesQuantityBreaksPanelEvent(item:Canvas, callbacks:IResponder=null)
		{
			this.panel = item;
			super(SystemPreferencesQuantityBreaksPanelEvent.COMMANDID, callbacks);
		}
		
		override public function clone():Event {
			return new SystemPreferencesQuantityBreaksPanelEvent(panel, callbacks);
		}
	}
}