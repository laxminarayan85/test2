package com.efi.printsmith.data
{
	import mx.collections.ArrayCollection; 
	import com.efi.printsmith.data.*;
	
	[Bindable]
	[RemoteClass(alias="com.efi.printsmith.data.PhoneTags")]
	[Managed]
	public class PhoneTags extends ModelBase
	{

		public function PhoneTags() {
			remoteObjectName = "com.efi.printsmith.data.PhoneTags";
		}
				
		public var name:String = "";
	
	}
}