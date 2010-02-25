package com.efi.printsmith.events.commandEvents.Accounts
{
	import flash.events.Event;
	import com.efi.printsmith.events.commandEvents.*;
	import mx.containers.Canvas;
	import mx.rpc.IResponder;

	public class AccountsNotesPanelEvent extends CommandEventBase
	{
		public static const COMMANDID:String = "CMD_Account_NotesPanel";

		public var panel:Canvas;
		public var enabled:Boolean;
		
		public function AccountsNotesPanelEvent(item:Canvas, callbacks:IResponder=null)
		{
			this.panel = item;
			super(AccountsNotesPanelEvent.COMMANDID, callbacks);
		}
		
		override public function clone():Event {
			return new AccountsNotesPanelEvent(panel, callbacks);
		}
	}
}