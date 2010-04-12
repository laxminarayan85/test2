package com.efi.printsmith.data
{
	import mx.collections.ArrayCollection; 
	import com.efi.printsmith.data.*;
	
	[RemoteClass(alias="com.efi.printsmith.data.StockClass")]
	[Managed]
	public class StockClass extends ModelBase
	{

		public function StockClass() {
			remoteObjectName = "com.efi.printsmith.data.StockClass";
		}
				
		public var name:String = "";
	
	}
}