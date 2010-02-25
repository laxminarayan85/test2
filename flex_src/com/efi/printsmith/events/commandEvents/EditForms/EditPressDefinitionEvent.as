package com.efi.printsmith.events.commandEvents.EditForms
{
	import flash.events.Event;
	import mx.rpc.IResponder;
	import com.efi.printsmith.events.commandEvents.*;
	import com.efi.printsmith.data.PressDefinition;

	public class EditPressDefinitionEvent extends CommandEventBase
	{
		public static const COMMANDID:String = "CMD_PressDefinition";
		public var object:PressDefinition;
		
		public function EditPressDefinitionEvent(object:PressDefinition, callbacks:IResponder=null)
		{
			this.object = object;
			super(EditPressDefinitionEvent.COMMANDID, callbacks);
		}
		
		override public function clone():Event {
			return new EditPressDefinitionEvent(object, callbacks);
		}
	}
}