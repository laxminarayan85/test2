package com.efi.printsmith.data
{
	import mx.collections.ArrayCollection; 
	import com.efi.printsmith.data.*;
	
	[Bindable]
	[RemoteClass(alias="com.efi.printsmith.data.StockFinish")]

	public class StockFinish extends ModelBase
	{

		public function StockFinish() {
			remoteObjectName = "com.efi.printsmith.data.StockFinish";
		}
				
		public var name:String = "";
		public var key:String = "";
	
	}
}