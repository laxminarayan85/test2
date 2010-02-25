package com.efi.printsmith.events.commandEvents.EditForms
{
	import flash.events.Event;
	import mx.rpc.IResponder;
	import com.efi.printsmith.events.commandEvents.*;
	import com.efi.printsmith.data.Account;

	public class EditAccountHistoryEvent extends CommandEventBase
	{
		public static const COMMANDID:String = "CMD_AccountHistory";
		public var object:Account;
		
		public function EditAccountHistoryEvent(object:Account, callbacks:IResponder=null)
		{
			this.object = object;
			super(EditAccountHistoryEvent.COMMANDID, callbacks);
		}
		
		override public function clone():Event {
			return new EditAccountHistoryEvent(object, callbacks);
		}
	}
}