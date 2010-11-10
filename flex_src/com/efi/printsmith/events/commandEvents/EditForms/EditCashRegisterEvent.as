package com.efi.printsmith.events.commandEvents.EditForms
{
	import flash.events.Event;
	import mx.rpc.IResponder;
	import com.efi.printsmith.events.commandEvents.*;
	import com.efi.printsmith.data.TapeSessionBatch;

	public class EditCashRegisterEvent extends CommandEventBase
	{
		public static const COMMANDID:String = "CMD_CashRegister";
		public var object:TapeSessionBatch;
		
		public function EditCashRegisterEvent(object:TapeSessionBatch, callbacks:IResponder=null)
		{
			this.object = object;
			super(EditCashRegisterEvent.COMMANDID, callbacks);
		}
		
		override public function clone():Event {
			return new EditCashRegisterEvent(object, callbacks);
		}
	}
}