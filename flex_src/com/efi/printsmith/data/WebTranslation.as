package com.efi.printsmith.data
{
	import mx.collections.ArrayCollection; 
	import com.efi.printsmith.data.*;
	
	[RemoteClass(alias="com.efi.printsmith.data.WebTranslation")]
	[Managed]
	
	public dynamic class WebTranslation extends ModelBase
	{

		public function WebTranslation() {
			remoteObjectName = "com.efi.printsmith.data.WebTranslation";
		}
		public var isDeleted:Boolean=false;
				
		public var name:String = "";
	
	}
}