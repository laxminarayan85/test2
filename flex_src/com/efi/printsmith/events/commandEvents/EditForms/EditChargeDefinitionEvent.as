package com.efi.printsmith.events.commandEvents.EditForms
{
	import flash.events.Event;
	import mx.rpc.IResponder;
	import com.efi.printsmith.events.commandEvents.*;
	import com.efi.printsmith.data.ChargeDefinition;

	public class EditChargeDefinitionEvent extends CommandEventBase
	{
		public static const COMMANDID:String = "CMD_ChargeDefinition";
		public var object:ChargeDefinition;
		
		public function EditChargeDefinitionEvent(object:ChargeDefinition, callbacks:IResponder=null)
		{
			this.object = object;
			super(EditChargeDefinitionEvent.COMMANDID, callbacks);
		}
		
		override public function clone():Event {
			return new EditChargeDefinitionEvent(object, callbacks);
		}
	}
}