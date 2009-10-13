package com.efi.vo
{
	import mx.collections.ArrayCollection; 
	import com.efi.vo.*;
	
	[Bindable]
	[RemoteClass(alias="com.efi.printsmith.data.SportsInterest")]

	public class SportsInterest extends ModelBase
	{

		public function SportsInterest() {
		
		}
		public var name:String = "";
	
	}
}