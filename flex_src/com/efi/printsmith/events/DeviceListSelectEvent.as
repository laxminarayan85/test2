package com.efi.printsmith.events
{
	import com.efi.printsmith.data.Account;
	
	import flash.events.Event;
	 
	public class DeviceListSelectEvent extends Event
	{
		public static const SELECTDEVICE:String = "SelectDevice";
		public static const CANCELSELECTDEVICE:String = "CancelSelectDevice";
		
		public var deviceId:String;
		
		public function DeviceListSelectEvent(type:String, deviceId:String)
		{
			super(type, true);
			this.deviceId = deviceId;
		}

		override public function clone():Event {
			return new DeviceListSelectEvent(type, deviceId);
		}
	}
}