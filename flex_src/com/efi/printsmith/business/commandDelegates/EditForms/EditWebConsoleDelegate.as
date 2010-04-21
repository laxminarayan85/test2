package com.efi.printsmith.business.commandDelegates.EditForms
{
	import com.efi.printsmith.business.commandDelegates.*;
	import com.efi.printsmith.data.*;
	import com.efi.printsmith.events.commandEvents.EditForms.EditWebConsoleEvent;
	import com.efi.printsmith.pages.EditWebConsole;
	
	import mx.rpc.Fault;
	import mx.rpc.IResponder;
	import mx.rpc.events.FaultEvent;
	import mx.rpc.events.ResultEvent;
	
	public class EditWebConsoleDelegate extends InterfaceCommandDelegate 
	{
		public function EditWebConsoleDelegate(responder:IResponder) {
			super(responder);
		}
		
		public function handleUIEvent(event:EditWebConsoleEvent):void {
			var child:EditWebConsole = new EditWebConsole();
			var resEvent:ResultEvent = new ResultEvent(ResultEvent.RESULT,false,true,child,null,null);
			responder.result(resEvent);
		}
	}
}