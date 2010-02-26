package com.efi.printsmith.events.commandEvents.SystemPreferences
{
	import flash.events.Event;
	import com.efi.printsmith.events.commandEvents.*;
	import mx.containers.Canvas;
	import mx.rpc.IResponder;

	public class SystemPreferencesAgingPeriodsPanelEvent extends CommandEventBase
	{
		public static const COMMANDID:String = "CMD_Preferences_AgingPeriods";

		public var panel:Canvas;
		public var enabled:Boolean;
		
		public function SystemPreferencesAgingPeriodsPanelEvent(item:Canvas, callbacks:IResponder=null)
		{
			this.panel = item;
			super(SystemPreferencesAgingPeriodsPanelEvent.COMMANDID, callbacks);
		}
		
		override public function clone():Event {
			return new SystemPreferencesAgingPeriodsPanelEvent(panel, callbacks);
		}
	}
}