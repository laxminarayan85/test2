package com.efi.vo
{
	import mx.collections.ArrayCollection; 
	import com.efi.vo.*;
	
	[Bindable]
	[RemoteClass(alias="com.efi.printsmith.data.CommonInterest")]

	public class CommonInterest extends ModelBase
	{

		public function CommonInterest() {
			remoteObjectName = "com.efi.printsmith.data.CommonInterest";
		}
				
		public var name:String = "";
	
	}
}