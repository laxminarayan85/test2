package com.efi.printsmith.events.commandEvents.SystemPreferences
{
	import flash.events.Event;
	import com.efi.printsmith.events.commandEvents.*;
	import mx.containers.Canvas;
	import mx.rpc.IResponder;

	public class SystemPreferencesCreditCardInfoPanelEvent extends CommandEventBase
	{
		public static const COMMANDID:String = "CMD_Preferences_CreditCardInfo";

		public var panel:Canvas;
		public var enabled:Boolean;
		
		public function SystemPreferencesCreditCardInfoPanelEvent(item:Canvas, callbacks:IResponder=null)
		{
			this.panel = item;
			super(SystemPreferencesCreditCardInfoPanelEvent.COMMANDID, callbacks);
		}
		
		override public function clone():Event {
			return new SystemPreferencesCreditCardInfoPanelEvent(panel, callbacks);
		}
	}
}