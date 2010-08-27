package com.efi.printsmith.data
{
	import mx.collections.ArrayCollection; 
	import com.efi.printsmith.data.*;
	
	[RemoteClass(alias="com.efi.printsmith.data.StockType")]
	[Managed]
	
	public dynamic class StockType extends ModelBase
	{

		public function StockType() {
			remoteObjectName = "com.efi.printsmith.data.StockType";
		}
				
		public var size:Dimension;
		public var name:String = "";
		public var viewableID:int = 0;
	
	}
}