package com.efi.printsmith.events.commandEvents.EditForms
{
	import flash.events.Event;
	import mx.rpc.IResponder;
	import com.efi.printsmith.events.commandEvents.*;
	import com.efi.printsmith.data.InvoiceBase;

	public class EditWorkInProgressEvent extends CommandEventBase
	{
		public static const COMMANDID:String = "CMD_WorkInProgress";
		public var object:InvoiceBase;
		
		public function EditWorkInProgressEvent(object:InvoiceBase, callbacks:IResponder=null)
		{
			this.object = object;
			super(EditWorkInProgressEvent.COMMANDID, callbacks);
		}
		
		override public function clone():Event {
			return new EditWorkInProgressEvent(object, callbacks);
		}
	}
}