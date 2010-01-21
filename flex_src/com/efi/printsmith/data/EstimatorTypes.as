package com.efi.printsmith.data
{
	import mx.collections.ArrayCollection; 
	import com.efi.printsmith.data.*;
	
	[Bindable]
	[RemoteClass(alias="com.efi.printsmith.data.EstimatorTypes")]

	public class EstimatorTypes extends ModelBase
	{

		public function EstimatorTypes() {
			remoteObjectName = "com.efi.printsmith.data.EstimatorTypes";
		}
				
		public var name:String = "";
	
	}
}