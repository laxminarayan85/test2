package com.efi.printsmith.data
{
	import mx.collections.ArrayCollection; 
	import com.efi.printsmith.data.*;
	
	[RemoteClass(alias="com.efi.printsmith.data.ComLinkType")]
	[Managed]
	
	public dynamic class ComLinkType extends ModelBase
	{

		public function ComLinkType() {
			remoteObjectName = "com.efi.printsmith.data.ComLinkType";
		}
		public var isDeleted:Boolean=false;
				
		public var type:String = "";
	
	}
}