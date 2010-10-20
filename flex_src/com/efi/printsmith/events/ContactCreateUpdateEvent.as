package com.efi.printsmith.events
{
	import com.efi.printsmith.data.Contact;
	import com.efi.printsmith.view.EditContact;
	
	import flash.events.Event;

	public class ContactCreateUpdateEvent extends Event
	{
		public static const CONTACT_CREATE:String = "contactCreate";
		public static const CONTACT_UPDATE:String = "contactUpdate";
		public static const CONTACT_DELETE:String = "contactDelete";
		
		public var contact:Contact;
		
		public function ContactCreateUpdateEvent(type:String, contact:Contact)
		{
			super(type);
			this.contact = contact;
		}
		
		override public function clone():Event {
			return new ContactCreateUpdateEvent(type, contact);
		}
	}
}