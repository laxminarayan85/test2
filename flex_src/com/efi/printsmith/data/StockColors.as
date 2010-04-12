package com.efi.printsmith.data
{
	import mx.collections.ArrayCollection; 
	import com.efi.printsmith.data.*;
	
	[RemoteClass(alias="com.efi.printsmith.data.StockColors")]
	[Managed]
	public class StockColors extends ModelBase
	{

		public function StockColors() {
			remoteObjectName = "com.efi.printsmith.data.StockColors";
		}
				
		public var name:String = "";
	
	}
}