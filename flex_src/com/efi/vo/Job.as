package com.efi.vo
{
	import mx.collections.ArrayCollection; 
	import com.efi.vo.*;
	
	[Bindable]
	[RemoteClass(alias="com.efi.printsmith.data.Job")]

	public class Job extends ModelBase
	{

		public function Job() {
		
		}
		public var jobNumber:String = "";
	
	}
}