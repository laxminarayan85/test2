package com.efi.printsmith.data
{
	import mx.collections.ArrayCollection; 
	import com.efi.printsmith.data.*;
	
	[Bindable]
	[RemoteClass(alias="com.efi.printsmith.data.CuttingCharge")]
	[Managed]
	public class CuttingCharge extends Charge
	{

		public function CuttingCharge() {
			remoteObjectName = "com.efi.printsmith.data.CuttingCharge";
		}
				
		public var cuts:int = 0;
	
	}
}