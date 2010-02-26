package com.efi.printsmith.events.commandEvents.SystemPreferences
{
	import flash.events.Event;
	import com.efi.printsmith.events.commandEvents.*;
	import mx.containers.Canvas;
	import mx.rpc.IResponder;

	public class SystemPreferencesPendingListPanelEvent extends CommandEventBase
	{
		public static const COMMANDID:String = "CMD_Preferences_PendingList";

		public var panel:Canvas;
		public var enabled:Boolean;
		
		public function SystemPreferencesPendingListPanelEvent(item:Canvas, callbacks:IResponder=null)
		{
			this.panel = item;
			super(SystemPreferencesPendingListPanelEvent.COMMANDID, callbacks);
		}
		
		override public function clone():Event {
			return new SystemPreferencesPendingListPanelEvent(panel, callbacks);
		}
	}
}