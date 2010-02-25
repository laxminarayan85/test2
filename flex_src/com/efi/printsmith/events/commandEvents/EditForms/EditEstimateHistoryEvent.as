package com.efi.printsmith.events.commandEvents.EditForms
{
	import flash.events.Event;
	import mx.rpc.IResponder;
	import com.efi.printsmith.events.commandEvents.*;
	import com.efi.printsmith.data.Account;

	public class EditEstimateHistoryEvent extends CommandEventBase
	{
		public static const COMMANDID:String = "CMD_EstimateHistory";
		public var object:Account;
		
		public function EditEstimateHistoryEvent(object:Account, callbacks:IResponder=null)
		{
			this.object = object;
			super(EditEstimateHistoryEvent.COMMANDID, callbacks);
		}
		
		override public function clone():Event {
			return new EditEstimateHistoryEvent(object, callbacks);
		}
	}
}