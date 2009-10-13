package com.efi.vo
{
	import mx.collections.ArrayCollection; 
	import com.efi.vo.*;
	
	[Bindable]
	[RemoteClass(alias="com.efi.printsmith.data.SalesRep")]

	public class SalesRep extends ModelBase
	{

		public function SalesRep() {
		
		}
		public var name:String = "";
	
	}
}