package com.efi.printsmith.events.commandEvents.EditForms
{
	import flash.events.Event;
	import mx.rpc.IResponder;
	import com.efi.printsmith.events.commandEvents.*;

	public class EditWebLocationsEvent extends CommandEventBase
	{
		public static const COMMANDID:String = "CMD_EditWebLocations";
		
		public function EditWebLocationsEvent(callbacks:IResponder=null)
		{
			super(EditWebLocationsEvent.COMMANDID, callbacks);
		}
		
		override public function clone():Event {
			return new EditWebLocationsEvent(callbacks);
		}
	}
}