package com.efi.printsmith.events.commandEvents.EditForms
{
	import flash.events.Event;
	import mx.rpc.IResponder;
	import com.efi.printsmith.events.commandEvents.*;

	public class TableEditorEvent extends CommandEventBase
	{
		public static const COMMANDID:String = "CMD_Table_Editor";
		
		public function TableEditorEvent(callbacks:IResponder=null)
		{
			super(TableEditorEvent.COMMANDID, callbacks);
		}
		
		override public function clone():Event {
			return new TableEditorEvent(callbacks); 
		}
	}
}