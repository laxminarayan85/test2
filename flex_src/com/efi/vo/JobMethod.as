package com.efi.vo
{
	import mx.collections.ArrayCollection; 
	import com.efi.vo.*;
	
	[Bindable]
	[RemoteClass(alias="com.efi.printsmith.data.JobMethod")]

	public class JobMethod extends ModelBase
	{

		public function JobMethod() {
		
		}
		public var name:String = "";
	
	}
}