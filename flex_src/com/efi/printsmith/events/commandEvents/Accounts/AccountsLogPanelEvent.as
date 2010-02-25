package com.efi.printsmith.events.commandEvents.Accounts
{
	import flash.events.Event;
	import com.efi.printsmith.events.commandEvents.*;
	import mx.containers.Canvas;
	import mx.rpc.IResponder;

	public class AccountsLogPanelEvent extends CommandEventBase
	{
		public static const COMMANDID:String = "CMD_Account_LogPanel";

		public var panel:Canvas;
		public var enabled:Boolean;
		
		public function AccountsLogPanelEvent(item:Canvas, callbacks:IResponder=null)
		{
			this.panel = item;
			super(AccountsLogPanelEvent.COMMANDID, callbacks);
		}
		
		override public function clone():Event {
			return new AccountsLogPanelEvent(panel, callbacks);
		}
	}
}