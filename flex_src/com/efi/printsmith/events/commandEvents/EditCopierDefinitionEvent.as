package com.efi.printsmith.events.commandEvents
{
	import com.efi.printsmith.data.CopierDefinition;
	
	import flash.events.Event;
	
	import mx.rpc.IResponder;

	public class EditCopierDefinitionEvent extends CommandEventBase
	{
		public static const COMMANDID:String = "CMD_CopierDefinition";
		public var object:CopierDefinition;
		
		public function EditCopierDefinitionEvent(object:CopierDefinition, callbacks:IResponder=null)
		{
			this.object = object;
			super(EditCopierDefinitionEvent.COMMANDID, callbacks);
		}
		
		override public function clone():Event {
			return new EditCopierDefinitionEvent(object, callbacks);
		}
	}
}