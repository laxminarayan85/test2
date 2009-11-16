package com.efi.events
{
	import com.efi.vo.Contact;
	
	import flash.events.Event;
	
	public class SaveContactEvent extends Event
	{
		public var contact:Contact;
		
		public function SaveContactEvent(type:String, contact:Contact)
		{
			super(type, true);
			this.contact = contact;
		}

		override public function clone():Event {
			return new SaveContactEvent(type, contact);
		}
	}
}