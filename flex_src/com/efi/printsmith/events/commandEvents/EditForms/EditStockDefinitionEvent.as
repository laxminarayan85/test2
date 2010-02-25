package com.efi.printsmith.events.commandEvents.EditForms
{
	import flash.events.Event;
	import mx.rpc.IResponder;
	import com.efi.printsmith.events.commandEvents.*;
	import com.efi.printsmith.data.StockDefinition;

	public class EditStockDefinitionEvent extends CommandEventBase
	{
		public static const COMMANDID:String = "CMD_StockDefinition";
		public var stockdef:StockDefinition;
		
		public function EditStockDefinitionEvent(stockdef:StockDefinition, callbacks:IResponder=null)
		{
			this.stockdef = stockdef;
			super(EditStockDefinitionEvent.COMMANDID, callbacks);
		}
		
		override public function clone():Event {
			return new EditStockDefinitionEvent(stockdef, callbacks);
		}
	}
}