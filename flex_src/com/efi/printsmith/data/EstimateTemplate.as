package com.efi.printsmith.data
{
	import mx.collections.ArrayCollection; 
	import com.efi.printsmith.data.*;
	
	[Bindable]
	[RemoteClass(alias="com.efi.printsmith.data.EstimateTemplate")]
	[Managed]
	public class EstimateTemplate extends Estimate
	{

		public function EstimateTemplate() {
			remoteObjectName = "com.efi.printsmith.data.EstimateTemplate";
		}
				
		public var templateName:String = "";
	
	}
}