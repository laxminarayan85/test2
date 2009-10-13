package com.efi.vo
{
	import mx.collections.ArrayCollection; 
	import com.efi.vo.*;
	
	[Bindable]
	[RemoteClass(alias="com.efi.printsmith.data.ProductCode")]

	public class ProductCode extends ModelBase
	{

		public function ProductCode() {
		
		}
		public var name:String = "";
	
	}
}