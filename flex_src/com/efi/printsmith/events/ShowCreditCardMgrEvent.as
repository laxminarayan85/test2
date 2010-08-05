package com.efi.printsmith.events
{
	import flash.events.Event;
	import mx.rpc.IResponder;
	import com.efi.printsmith.events.commandEvents.*;
	import com.efi.printsmith.events.ShowCreditCardMgrEvent;

	public class ShowCreditCardMgrEvent extends CommandEventBase
	{
		public static const COMMANDID:String = "CMD_CreditCardMgr";
		
		public function ShowCreditCardMgrEvent(callbacks:IResponder=null)
		{
			super(ShowCreditCardMgrEvent.COMMANDID, callbacks);
		}
		
		override public function clone():Event {
			return new ShowCreditCardMgrEvent(callbacks);
		}
	}
}