package com.efi.vo
{
	import mx.collections.ArrayCollection; 
	import com.efi.vo.*;
	
	[Bindable]
	[RemoteClass(alias="com.efi.printsmith.data.Products")]

	public class Products extends ModelBase
	{

		public function Products() {
		
		}
		public var name:String = "";
		public var key:String = "";
	
	}
}