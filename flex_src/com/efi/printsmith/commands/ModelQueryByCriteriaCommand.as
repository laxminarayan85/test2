package com.efi.printsmith.commands
{
	import com.adobe.cairngorm.commands.ICommand;
	import com.adobe.cairngorm.control.CairngormEvent;
	import com.efi.printsmith.events.ModelQueryByCriteriaEvent;;
	import com.efi.printsmith.business.ModelQueryByCriteriaDelegate;

	public class ModelQueryByCriteriaCommand implements ICommand
	{
		public function ModelQueryByCriteriaCommand()
		{
		}

		public function execute(event:CairngormEvent):void
		{
			var queryByCriteriaEvent:ModelQueryByCriteriaEvent = event as ModelQueryByCriteriaEvent;
			var delegate:ModelQueryByCriteriaDelegate = new ModelQueryByCriteriaDelegate(queryByCriteriaEvent.callbacks);
			delegate.queryByCriteria(queryByCriteriaEvent.modelType, queryByCriteriaEvent.criteria);
		}
		
	}
}