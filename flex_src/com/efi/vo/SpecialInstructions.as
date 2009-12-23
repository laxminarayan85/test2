package com.efi.vo
{
	import mx.collections.ArrayCollection; 
	import com.efi.vo.*;
	
	[Bindable]
	[RemoteClass(alias="com.efi.printsmith.data.SpecialInstructions")]

	public class SpecialInstructions extends ModelBase
	{

		public function SpecialInstructions() {
			remoteObjectName = "com.efi.printsmith.data.SpecialInstructions";
		}
				
		public var instructions:String = "";
	
	}
}