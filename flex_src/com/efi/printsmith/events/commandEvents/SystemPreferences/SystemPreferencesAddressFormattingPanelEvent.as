package com.efi.printsmith.events.commandEvents.SystemPreferences
{
	import flash.events.Event;
	import com.efi.printsmith.events.commandEvents.*;
	import mx.containers.Canvas;
	import mx.rpc.IResponder;

	public class SystemPreferencesAddressFormattingPanelEvent extends CommandEventBase
	{
		public static const COMMANDID:String = "CMD_Preferences_AddressFormatting";

		public var panel:Canvas;
		public var enabled:Boolean;
		
		public function SystemPreferencesAddressFormattingPanelEvent(item:Canvas, callbacks:IResponder=null)
		{
			this.panel = item;
			super(SystemPreferencesAddressFormattingPanelEvent.COMMANDID, callbacks);
		}
		
		override public function clone():Event {
			return new SystemPreferencesAddressFormattingPanelEvent(panel, callbacks);
		}
	}
}