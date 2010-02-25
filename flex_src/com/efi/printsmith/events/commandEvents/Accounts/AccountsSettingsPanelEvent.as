package com.efi.printsmith.events.commandEvents.Accounts
{
	import flash.events.Event;
	import com.efi.printsmith.events.commandEvents.*;
	import mx.containers.Canvas;
	import mx.rpc.IResponder;

	public class AccountsSettingsPanelEvent extends CommandEventBase
	{
		public static const COMMANDID:String = "CMD_Account_SettingsPanel";

		public var panel:Canvas;
		public var enabled:Boolean;
		
		public function AccountsSettingsPanelEvent(item:Canvas, callbacks:IResponder=null)
		{
			this.panel = item;
			super(AccountsSettingsPanelEvent.COMMANDID, callbacks);
		}
		
		override public function clone():Event {
			return new AccountsSettingsPanelEvent(panel, callbacks);
		}
	}
}