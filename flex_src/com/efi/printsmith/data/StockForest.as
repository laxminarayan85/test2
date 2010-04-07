package com.efi.printsmith.data
{
	import mx.collections.ArrayCollection; 
	import com.efi.printsmith.data.*;
	
	[Bindable]
	[RemoteClass(alias="com.efi.printsmith.data.StockForest")]

	public class StockForest extends ModelBase
	{

		public function StockForest() {
			remoteObjectName = "com.efi.printsmith.data.StockForest";
		}
				
		public var name:String = "";
		public var key:String = "";
	
	}
}