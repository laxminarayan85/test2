package com.efi.printsmith.commands.commandCommands.EditForms
{
	import com.adobe.cairngorm.commands.ICommand;
	import com.adobe.cairngorm.control.CairngormEvent;
	import com.efi.printsmith.business.commandDelegates.EditForms.TableEditorDelegate;
	import com.efi.printsmith.events.commandEvents.EditForms.TableEditorEvent;
	
	public class TableEditorCommand implements ICommand
	{
		public function TableEditorCommand()
		{
			
		}

		public function execute(event:CairngormEvent):void
		{
			var tableEditorEvent: TableEditorEvent = event as TableEditorEvent;
			var delegate: TableEditorDelegate = new TableEditorDelegate(tableEditorEvent.callbacks);
			
			delegate.handleUIEvent(tableEditorEvent);
		}
		
	}
}