package com.efi.printsmith.data
{
	import mx.collections.ArrayCollection; 
	import com.efi.printsmith.data.*;
	
	[RemoteClass(alias="com.efi.printsmith.data.ComLink")]
	[Managed]
	
	public dynamic class ComLink extends ModelBase
	{

		public function ComLink() {
			remoteObjectName = "com.efi.printsmith.data.ComLink";
		}
		public var isDeleted:Boolean=false;
				
		public var type:String = "";
		public var value:String = "";
	
	}
}