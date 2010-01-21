package com.efi.printsmith.data
{
	import mx.collections.ArrayCollection; 
	import com.efi.printsmith.data.*;
	
	[Bindable]
	[RemoteClass(alias="com.efi.printsmith.data.PreferencesCreditCard")]

	public class PreferencesCreditCard extends ModelBase
	{

		public function PreferencesCreditCard() {
			remoteObjectName = "com.efi.printsmith.data.PreferencesCreditCard";
		}
				
		public var used:Boolean = true;
		public var cardType:String = "";
		public var abbreviation:String = "";
		public var code:String = "";
	
	}
}