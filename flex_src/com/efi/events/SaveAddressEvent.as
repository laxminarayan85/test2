package com.efi.events
{
	import com.efi.vo.Address;
	
	import flash.events.Event;
	
	public class SaveAddressEvent extends Event
	{
		public var address:Address;
		
		public function SaveAddressEvent(type:String, address:Address)
		{
			super(type, true);
			this.address = address;
		}

		override public function clone():Event {
			return new SaveAddressEvent(type, address);
		}
	}
}