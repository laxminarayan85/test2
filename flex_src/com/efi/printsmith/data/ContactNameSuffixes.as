package com.efi.printsmith.data
{
	import mx.collections.ArrayCollection; 
	import com.efi.printsmith.data.*;
	
	[RemoteClass(alias="com.efi.printsmith.data.ContactNameSuffixes")]
	[Managed]
	
	public dynamic class ContactNameSuffixes extends ModelBase
	{

		public function ContactNameSuffixes() {
			remoteObjectName = "com.efi.printsmith.data.ContactNameSuffixes";
		}
		public var isDeleted:Boolean=false;
				
		public var name:String = "";
	
	}
}