package com.efi.events
{
	import flash.events.Event;
	import com.efi.vo.Address;
	
	public class SaveAddressEvent extends Event
	{
		public var address:Address;
		
		public function SaveAddressEvent(address:Address)
		{
			super("SaveAddressEvent");
			this.address = address;
		}

		override public function clone():Event {
			return new SaveAddressEvent(address);
		}
	}
}