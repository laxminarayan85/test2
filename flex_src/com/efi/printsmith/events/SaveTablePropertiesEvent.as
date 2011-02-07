package com.efi.printsmith.events
{
	import com.efi.printsmith.data.TableProperties;
	
	import flash.events.Event;
	
	public class SaveTablePropertiesEvent extends Event
	{
		public var tableProperties:TableProperties;
		public static const Save:String = "SaveTableProperties";
		public static const Cancel:String = "CancelTableProperties";
		public static const DontSave:String = "DontSaveTableProperties";

		public function SaveTablePropertiesEvent(type:String, tableProperties:TableProperties)
		{
			super(type, true);
			this.tableProperties = tableProperties;
		}

		override public function clone():Event {
			return new SaveTablePropertiesEvent(type, tableProperties);
		}
	}
}