package com.efi.printsmith.data
{
	import mx.collections.ArrayCollection; 
	import com.efi.printsmith.data.*;
	
	[Bindable]
	[RemoteClass(alias="com.efi.printsmith.data.BusinessType")]

	public class BusinessType extends ModelBase
	{

		public function BusinessType() {
			remoteObjectName = "com.efi.printsmith.data.BusinessType";
		}
				
		public var name:String = "";
		public var key:String = "";
	
	}
}