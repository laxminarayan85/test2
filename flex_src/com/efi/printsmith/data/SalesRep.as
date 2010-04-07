package com.efi.printsmith.data
{
	import mx.collections.ArrayCollection; 
	import com.efi.printsmith.data.*;
	
	[Bindable]
	[RemoteClass(alias="com.efi.printsmith.data.SalesRep")]
	[Managed]
	public class SalesRep extends ModelBase
	{

		public function SalesRep() {
			remoteObjectName = "com.efi.printsmith.data.SalesRep";
		}
				
		public var name:String = "";
	
	}
}