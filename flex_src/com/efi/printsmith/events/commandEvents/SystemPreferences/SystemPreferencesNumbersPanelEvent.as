package com.efi.printsmith.events.commandEvents.SystemPreferences
{
	import flash.events.Event;
	import com.efi.printsmith.events.commandEvents.*;
	import mx.containers.Canvas;
	import mx.rpc.IResponder;

	public class SystemPreferencesNumbersPanelEvent extends CommandEventBase
	{
		public static const COMMANDID:String = "CMD_Preferences_Numbers";

		public var panel:Canvas;
		public var enabled:Boolean;
		
		public function SystemPreferencesNumbersPanelEvent(item:Canvas, callbacks:IResponder=null)
		{
			this.panel = item;
			super(SystemPreferencesNumbersPanelEvent.COMMANDID, callbacks);
		}
		
		override public function clone():Event {
			return new SystemPreferencesNumbersPanelEvent(panel, callbacks);
		}
	}
}