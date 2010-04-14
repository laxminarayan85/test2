package com.efi.printsmith.data
{
	import mx.collections.ArrayCollection; 
	import com.efi.printsmith.data.*;
	
	[Bindable]
	[RemoteClass(alias="com.efi.printsmith.data.WebTranslation")]

	public class WebTranslation extends ModelBase
	{

		public function WebTranslation() {
			remoteObjectName = "com.efi.printsmith.data.WebTranslation";
		}
				
		public var name:String = "";
	
	}
}