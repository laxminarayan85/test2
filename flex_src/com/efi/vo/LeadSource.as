package com.efi.vo
{
	import mx.collections.ArrayCollection; 
	import com.efi.vo.*;
	
	[Bindable]
	[RemoteClass(alias="com.efi.printsmith.data.LeadSource")]

	public class LeadSource extends ModelBase
	{

		public function LeadSource() {
			remoteObjectName = "com.efi.printsmith.data.LeadSource";
		}
				
		public var name:String = "";
	
	}
}