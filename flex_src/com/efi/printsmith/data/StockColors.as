package com.efi.printsmith.data
{
	import mx.collections.ArrayCollection; 
	import com.efi.printsmith.data.*;
	
	[RemoteClass(alias="com.efi.printsmith.data.StockColors")]
	[Managed]
	
	public dynamic class StockColors extends ModelBase
	{

		public function StockColors() {
			remoteObjectName = "com.efi.printsmith.data.StockColors";
		}
		public var isDeleted:Boolean=false;
				
		public var name:String = "";
	
	}
}