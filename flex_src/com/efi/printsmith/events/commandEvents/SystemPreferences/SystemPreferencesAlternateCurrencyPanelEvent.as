package com.efi.printsmith.events.commandEvents.SystemPreferences
{
	import flash.events.Event;
	import com.efi.printsmith.events.commandEvents.*;
	import mx.containers.Canvas;
	import mx.rpc.IResponder;

	public class SystemPreferencesAlternateCurrencyPanelEvent extends CommandEventBase
	{
		public static const COMMANDID:String = "CMD_Preferences_AlternateCurrency";

		public var panel:Canvas;
		public var enabled:Boolean;
		
		public function SystemPreferencesAlternateCurrencyPanelEvent(item:Canvas, callbacks:IResponder=null)
		{
			this.panel = item;
			super(SystemPreferencesAlternateCurrencyPanelEvent.COMMANDID, callbacks);
		}
		
		override public function clone():Event {
			return new SystemPreferencesAlternateCurrencyPanelEvent(panel, callbacks);
		}
	}
}