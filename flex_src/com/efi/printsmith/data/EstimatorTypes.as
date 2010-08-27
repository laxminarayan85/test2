package com.efi.printsmith.data
{
	import mx.collections.ArrayCollection; 
	import com.efi.printsmith.data.*;
	
	[RemoteClass(alias="com.efi.printsmith.data.EstimatorTypes")]
	[Managed]
	
	public dynamic class EstimatorTypes extends ModelBase
	{

		public function EstimatorTypes() {
			remoteObjectName = "com.efi.printsmith.data.EstimatorTypes";
		}
		public var isDeleted:Boolean=false;
				
		public var name:String = "";
	
	}
}