package com.efi.vo
{
	import mx.collections.ArrayCollection; 
	import com.efi.vo.*;
	
	[Bindable]
	[RemoteClass(alias="com.efi.printsmith.data.SizeTable")]

	public class SizeTable extends ModelBase
	{

		public function SizeTable() {
		
		}
		public var name:int = 0;
	
	}
}