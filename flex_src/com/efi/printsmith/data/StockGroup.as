package com.efi.printsmith.data
{
	import mx.collections.ArrayCollection; 
	import com.efi.printsmith.data.*;
	
	[RemoteClass(alias="com.efi.printsmith.data.StockGroup")]
	[Managed]
	
	public class StockGroup extends ModelBase
	{

		public function StockGroup() {
			remoteObjectName = "com.efi.printsmith.data.StockGroup";
		}
				
		public var name:String = "";
		public var key:String = "";
	
	}
}