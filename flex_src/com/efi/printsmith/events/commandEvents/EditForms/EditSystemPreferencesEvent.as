package com.efi.printsmith.events.commandEvents.EditForms
{
	import flash.events.Event;
	import mx.rpc.IResponder;
	import com.efi.printsmith.events.commandEvents.*;
	import com.efi.printsmith.data.PreferencesSystem;

	public class EditSystemPreferencesEvent extends CommandEventBase
	{
		public static const COMMANDID:String = "CMD_SystemPreferences";
		public var object:PreferencesSystem;
		
		public function EditSystemPreferencesEvent(object:PreferencesSystem, callbacks:IResponder=null)
		{
			this.object = object;
			super(EditSystemPreferencesEvent.COMMANDID, callbacks);
		}
		
		override public function clone():Event {
			return new EditSystemPreferencesEvent(object, callbacks);
		}
	}
}