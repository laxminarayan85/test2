package com.efi.printsmith.data
{
	import mx.collections.ArrayCollection; 
	import com.efi.printsmith.data.*;
	
	[RemoteClass(alias="com.efi.printsmith.data.EstimatorTypes")]
	[Managed]
	
	public class EstimatorTypes extends ModelBase
	{

		public function EstimatorTypes() {
			remoteObjectName = "com.efi.printsmith.data.EstimatorTypes";
		}
				
		public var name:String = "";
	
	}
}