package com.efi.printsmith.data
{
	import mx.collections.ArrayCollection; 
	import com.efi.printsmith.data.*;
	
	[RemoteClass(alias="com.efi.printsmith.data.PreferencesCreditCard")]
	[Managed]
	
	public class PreferencesCreditCard extends ModelBase
	{

		public function PreferencesCreditCard() {
			remoteObjectName = "com.efi.printsmith.data.PreferencesCreditCard";
		}
				
		public var used:Boolean = false;
		public var cardType:String = "";
		public var abbreviation:String = "";
		public var code:String = "";
	
	}
}