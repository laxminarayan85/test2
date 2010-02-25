package com.efi.printsmith.events.commandEvents.Accounts
{
	import flash.events.Event;
	import com.efi.printsmith.events.commandEvents.*;
	import mx.containers.Canvas;
	import mx.rpc.IResponder;

	public class AccountsMarketingPanelEvent extends CommandEventBase
	{
		public static const COMMANDID:String = "CMD_Account_MarketingPanel";

		public var panel:Canvas;
		public var enabled:Boolean;
		
		public function AccountsMarketingPanelEvent(item:Canvas, callbacks:IResponder=null)
		{
			this.panel = item;
			super(AccountsMarketingPanelEvent.COMMANDID, callbacks);
		}
		
		override public function clone():Event {
			return new AccountsMarketingPanelEvent(panel, callbacks);
		}
	}
}