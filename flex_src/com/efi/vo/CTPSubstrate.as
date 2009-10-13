package com.efi.vo
{
	import mx.collections.ArrayCollection; 
	import com.efi.vo.*;
	
	[Bindable]
	[RemoteClass(alias="com.efi.printsmith.data.CTPSubstrate")]

	public class CTPSubstrate extends ModelBase
	{

		public function CTPSubstrate() {
		
		}
		public var name:String = "";
		public var key:String = "";
	
	}
}