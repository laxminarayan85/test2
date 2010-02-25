package com.efi.printsmith.events.commandEvents.Accounts
{
	import flash.events.Event;
	import com.efi.printsmith.events.commandEvents.*;
	import mx.containers.Canvas;
	import mx.rpc.IResponder;

	public class AccountsWebPanelEvent extends CommandEventBase
	{
		public static const COMMANDID:String = "CMD_Account_WEBPanel";

		public var panel:Canvas;
		public var enabled:Boolean;
		
		public function AccountsWebPanelEvent(item:Canvas, callbacks:IResponder=null)
		{
			this.panel = item;
			super(AccountsWebPanelEvent.COMMANDID, callbacks);
		}
		
		override public function clone():Event {
			return new AccountsWebPanelEvent(panel, callbacks);
		}
	}
}