package com.efi.printsmith.events.commandEvents
{
	import flash.events.Event;
	import mx.rpc.IResponder;
	import com.efi.printsmith.data.ModelBase;
	import com.efi.printsmith.data.StockDefinition;

	public class DeleteStockDefinitionEvent extends CommandEventBase
	{
		public static const COMMANDID:String = "CMD_StockDefinition_Delete";
		public var stockdef:StockDefinition;
		
		public function DeleteStockDefinitionEvent(stockdef:StockDefinition, callbacks:IResponder=null)
		{
			this.stockdef = stockdef;
			super(DeleteStockDefinitionEvent.COMMANDID, callbacks);
		}
		
		override public function clone():Event {
			return new DeleteStockDefinitionEvent(stockdef, callbacks);
		}
	}
}