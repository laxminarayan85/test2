package com.efi.printsmith.data
{
	import mx.collections.ArrayCollection; 
	import com.efi.printsmith.data.*;
	
	[RemoteClass(alias="com.efi.printsmith.data.CuttingCharge")]
	[Managed]
	
	public dynamic class CuttingCharge extends Charge
	{

		public function CuttingCharge() {
			remoteObjectName = "com.efi.printsmith.data.CuttingCharge";
		}
		public override var isDeleted:Boolean=false;
			
		public var overrideCuts:Boolean = false;	
		public var cuts:int = 0;
		
	}
}