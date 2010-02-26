package com.efi.printsmith.events.commandEvents.SystemPreferences
{
	import flash.events.Event;
	import com.efi.printsmith.events.commandEvents.*;
	import mx.containers.Canvas;
	import mx.rpc.IResponder;

	public class SystemPreferencesStocksandSizesPanelEvent extends CommandEventBase
	{
		public static const COMMANDID:String = "CMD_Preferences_StocksandSizes";

		public var panel:Canvas;
		public var enabled:Boolean;
		
		public function SystemPreferencesStocksandSizesPanelEvent(item:Canvas, callbacks:IResponder=null)
		{
			this.panel = item;
			super(SystemPreferencesStocksandSizesPanelEvent.COMMANDID, callbacks);
		}
		
		override public function clone():Event {
			return new SystemPreferencesStocksandSizesPanelEvent(panel, callbacks);
		}
	}
}