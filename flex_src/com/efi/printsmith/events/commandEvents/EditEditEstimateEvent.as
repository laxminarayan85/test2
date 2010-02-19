package com.efi.printsmith.events.commandEvents
{
	import com.efi.printsmith.data.InvoiceBase;
	
	import flash.events.Event;
	
	import mx.rpc.IResponder;

	public class EditEditEstimateEvent extends CommandEventBase
	{
		public static const COMMANDID:String = "CMD_EditEstimate";
		public var object:InvoiceBase;
		
		public function EditEditEstimateEvent(object:InvoiceBase, callbacks:IResponder=null)
		{
			this.object = object;
			super(EditEditEstimateEvent.COMMANDID, callbacks);
		}
		
		override public function clone():Event {
			return new EditEditEstimateEvent(object, callbacks);
		}
	}
}