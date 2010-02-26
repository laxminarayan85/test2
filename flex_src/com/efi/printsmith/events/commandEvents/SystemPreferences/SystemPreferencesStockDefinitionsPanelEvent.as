package com.efi.printsmith.events.commandEvents.SystemPreferences
{
	import flash.events.Event;
	import com.efi.printsmith.events.commandEvents.*;
	import mx.containers.Canvas;
	import mx.rpc.IResponder;

	public class SystemPreferencesStockDefinitionsPanelEvent extends CommandEventBase
	{
		public static const COMMANDID:String = "CMD_Preferences_StockDefinitions";

		public var panel:Canvas;
		public var enabled:Boolean;
		
		public function SystemPreferencesStockDefinitionsPanelEvent(item:Canvas, callbacks:IResponder=null)
		{
			this.panel = item;
			super(SystemPreferencesStockDefinitionsPanelEvent.COMMANDID, callbacks);
		}
		
		override public function clone():Event {
			return new SystemPreferencesStockDefinitionsPanelEvent(panel, callbacks);
		}
	}
}