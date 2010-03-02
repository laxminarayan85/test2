package com.efi.printsmith.events.commandEvents.StockDefinitions
{
	import flash.events.Event;
	import com.efi.printsmith.events.commandEvents.*;
	import mx.controls.Button;
	import mx.rpc.IResponder;

	public class DeleteStockDefinitionEvent extends CommandEventBase
	{
		public static const COMMANDID:String = "CMD_StockDefinition_Delete";

		public var button:Button;
		public var enabled:Boolean;
		
		public function DeleteStockDefinitionEvent(item:Button, callbacks:IResponder=null)
		{
			this.button = item;
			super(DeleteStockDefinitionEvent.COMMANDID, callbacks);
		}
		
		override public function clone():Event {
			return new DeleteStockDefinitionEvent(button, callbacks);
		}
	}
}