package com.efi.vo
{
	import mx.collections.ArrayCollection; 
	import com.efi.vo.*;
	
	[Bindable]
	[RemoteClass(alias="com.efi.printsmith.data.EstimatorTypes")]

	public class EstimatorTypes extends ModelBase
	{

		public function EstimatorTypes() {
		
		}
		public var name:String = "";
	
	}
}