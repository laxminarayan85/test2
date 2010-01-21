package com.efi.printsmith.data
{
	import mx.collections.ArrayCollection; 
	import com.efi.printsmith.data.*;
	
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