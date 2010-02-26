package com.efi.printsmith.events.commandEvents.SystemPreferences
{
	import flash.events.Event;
	import com.efi.printsmith.events.commandEvents.*;
	import mx.containers.Canvas;
	import mx.rpc.IResponder;

	public class SystemPreferencesJournalEntriesPanelEvent extends CommandEventBase
	{
		public static const COMMANDID:String = "CMD_Preferences_JournalEntries";

		public var panel:Canvas;
		public var enabled:Boolean;
		
		public function SystemPreferencesJournalEntriesPanelEvent(item:Canvas, callbacks:IResponder=null)
		{
			this.panel = item;
			super(SystemPreferencesJournalEntriesPanelEvent.COMMANDID, callbacks);
		}
		
		override public function clone():Event {
			return new SystemPreferencesJournalEntriesPanelEvent(panel, callbacks);
		}
	}
}