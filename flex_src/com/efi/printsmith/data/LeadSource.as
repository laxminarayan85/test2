package com.efi.printsmith.data
{
	import mx.collections.ArrayCollection; 
	import com.efi.printsmith.data.*;
	
	[RemoteClass(alias="com.efi.printsmith.data.LeadSource")]
	[Managed]
	public class LeadSource extends ModelBase
	{

		public function LeadSource() {
			remoteObjectName = "com.efi.printsmith.data.LeadSource";
		}
				
		public var name:String = "";
	
	}
}