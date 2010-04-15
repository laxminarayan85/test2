package com.efi.printsmith.data
{
	import mx.collections.ArrayCollection; 
	import com.efi.printsmith.data.*;
	
	[RemoteClass(alias="com.efi.printsmith.data.Products")]
	[Managed]
	
	public class Products extends ModelBase
	{

		public function Products() {
			remoteObjectName = "com.efi.printsmith.data.Products";
		}
				
		public var name:String = "";
		public var key:String = "";
	
	}
}