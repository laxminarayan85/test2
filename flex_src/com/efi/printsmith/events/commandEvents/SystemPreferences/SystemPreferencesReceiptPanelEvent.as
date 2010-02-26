package com.efi.printsmith.events.commandEvents.SystemPreferences
{
	import flash.events.Event;
	import com.efi.printsmith.events.commandEvents.*;
	import mx.containers.Canvas;
	import mx.rpc.IResponder;

	public class SystemPreferencesReceiptPanelEvent extends CommandEventBase
	{
		public static const COMMANDID:String = "CMD_Preferences_Receipt";

		public var panel:Canvas;
		public var enabled:Boolean;
		
		public function SystemPreferencesReceiptPanelEvent(item:Canvas, callbacks:IResponder=null)
		{
			this.panel = item;
			super(SystemPreferencesReceiptPanelEvent.COMMANDID, callbacks);
		}
		
		override public function clone():Event {
			return new SystemPreferencesReceiptPanelEvent(panel, callbacks);
		}
	}
}