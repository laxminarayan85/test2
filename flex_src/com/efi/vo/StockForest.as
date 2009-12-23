package com.efi.vo
{
	import mx.collections.ArrayCollection; 
	import com.efi.vo.*;
	
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