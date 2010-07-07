package com.efi.printsmith.data
{
	import mx.collections.ArrayCollection; 
	import com.efi.printsmith.data.*;
	
	[RemoteClass(alias="com.efi.printsmith.data.StockGrade")]
	[Managed]
	
	public dynamic class StockGrade extends ModelBase
	{

		public function StockGrade() {
			remoteObjectName = "com.efi.printsmith.data.StockGrade";
		}
				
		public var name:String = "";
		public var key:String = "";
	
	}
}