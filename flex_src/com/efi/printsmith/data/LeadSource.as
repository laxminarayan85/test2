package com.efi.printsmith.data
{
	import mx.collections.ArrayCollection; 
	import com.efi.printsmith.data.*;
	
	[RemoteClass(alias="com.efi.printsmith.data.LeadSource")]
	[Managed]
	
	public dynamic class LeadSource extends ModelBase
	{

		public function LeadSource() {
			remoteObjectName = "com.efi.printsmith.data.LeadSource";
		}
		public var isDeleted:Boolean=false;
				
		public var name:String = "";
	
	}
}