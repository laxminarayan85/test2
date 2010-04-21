package com.efi.printsmith.business.commandDelegates.EditForms
{
	import com.efi.printsmith.business.commandDelegates.*;
	import com.efi.printsmith.data.*;
	import com.efi.printsmith.events.commandEvents.EditForms.EditWebLocationsEvent;
	import com.efi.printsmith.pages.EditWebLocations;
	
	import mx.rpc.Fault;
	import mx.rpc.IResponder;
	import mx.rpc.events.FaultEvent;
	import mx.rpc.events.ResultEvent;
	
	public class EditWebLocationsDelegate extends InterfaceCommandDelegate 
	{
		public function EditWebLocationsDelegate(responder:IResponder) {
			super(responder);
		}
		
		public function handleUIEvent(event:EditWebLocationsEvent):void {
			var child:EditWebLocations = new EditWebLocations();
			var resEvent:ResultEvent = new ResultEvent(ResultEvent.RESULT,false,true,child,null,null);
			responder.result(resEvent);
		}
	}
}