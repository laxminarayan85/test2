package com.efi.printsmith.data
{
	import mx.collections.ArrayCollection; 
	import com.efi.printsmith.data.*;
	
	[RemoteClass(alias="com.efi.printsmith.data.EstimateTemplate")]
	[Managed]
	
	public dynamic class EstimateTemplate extends Estimate
	{

		public function EstimateTemplate() {
			remoteObjectName = "com.efi.printsmith.data.EstimateTemplate";
		}
		public override var isDeleted:Boolean=false;
				
		public var templateName:String = "";
	
	}
}