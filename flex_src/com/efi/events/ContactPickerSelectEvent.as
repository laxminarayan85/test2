package com.efi.events
{
	import com.efi.vo.Contact;
	
	import flash.events.Event;
	
	public class ContactPickerSelectEvent extends Event
	{
		public static const SELECTACCOUNT:String = "SelectAccount";
		public static const SELECTNEWACCOUNT:String = "SelectNewAccount";
		public static const CANCELSELECTACCOUNT:String = "CancelSelectAccount";
		
		public var contact:Contact;
		
		public function ContactPickerSelectEvent(type:String, contact:Contact)
		{
			super(type, true);
			this.contact = contact;
		}

		override public function clone():Event {
			return new ContactPickerSelectEvent(type, contact);
		}
	}
}