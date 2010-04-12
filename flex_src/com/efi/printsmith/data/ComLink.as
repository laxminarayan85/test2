package com.efi.printsmith.data
{
	import mx.collections.ArrayCollection; 
	import com.efi.printsmith.data.*;
	
	[RemoteClass(alias="com.efi.printsmith.data.ComLink")]
	[Managed]
	public class ComLink extends ModelBase
	{

		public function ComLink() {
			remoteObjectName = "com.efi.printsmith.data.ComLink";
		}
				
		public var type:String = "";
		public var value:String = "";
	
	}
}