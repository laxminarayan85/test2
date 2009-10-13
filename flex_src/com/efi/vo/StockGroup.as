package com.efi.vo
{
	import mx.collections.ArrayCollection; 
	import com.efi.vo.*;
	
	[Bindable]
	[RemoteClass(alias="com.efi.printsmith.data.StockGroup")]

	public class StockGroup extends ModelBase
	{

		public function StockGroup() {
		
		}
		public var name:String = "";
		public var key:String = "";
	
	}
}