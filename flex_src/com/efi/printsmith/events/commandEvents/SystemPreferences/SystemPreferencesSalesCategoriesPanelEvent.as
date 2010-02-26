package com.efi.printsmith.events.commandEvents.SystemPreferences
{
	import flash.events.Event;
	import com.efi.printsmith.events.commandEvents.*;
	import mx.containers.Canvas;
	import mx.rpc.IResponder;

	public class SystemPreferencesSalesCategoriesPanelEvent extends CommandEventBase
	{
		public static const COMMANDID:String = "CMD_Preferences_SalesCategories";

		public var panel:Canvas;
		public var enabled:Boolean;
		
		public function SystemPreferencesSalesCategoriesPanelEvent(item:Canvas, callbacks:IResponder=null)
		{
			this.panel = item;
			super(SystemPreferencesSalesCategoriesPanelEvent.COMMANDID, callbacks);
		}
		
		override public function clone():Event {
			return new SystemPreferencesSalesCategoriesPanelEvent(panel, callbacks);
		}
	}
}