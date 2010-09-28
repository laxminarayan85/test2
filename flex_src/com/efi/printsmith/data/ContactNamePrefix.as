package com.efi.printsmith.data
{
	import mx.collections.ArrayCollection; 
	import com.efi.printsmith.data.*;
	
	[RemoteClass(alias="com.efi.printsmith.data.ContactNamePrefix")]
	[Managed]
	
	public dynamic class ContactNamePrefix extends ModelBase
	{

		public function ContactNamePrefix() {
			remoteObjectName = "com.efi.printsmith.data.ContactNamePrefix";
		}
		public var isDeleted:Boolean=false;
				
		public var name:String = "";
	
	}
}