package com.efi.vo
{
	import mx.collections.ArrayCollection; 
	import com.efi.vo.*;
	
	[Bindable]
	[RemoteClass(alias="com.efi.printsmith.data.ProductionPriority")]

	public class ProductionPriority extends ModelBase
	{

		public function ProductionPriority() {
		
		}
		public var name:String = "";
		public var key:String = "";
	
	}
}