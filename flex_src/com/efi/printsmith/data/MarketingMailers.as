package com.efi.printsmith.data
{
	import mx.collections.ArrayCollection; 
	import com.efi.printsmith.data.*;
	
	[RemoteClass(alias="com.efi.printsmith.data.MarketingMailers")]
	[Managed]
	
	public dynamic class MarketingMailers extends ModelBase
	{

		public function MarketingMailers() {
			remoteObjectName = "com.efi.printsmith.data.MarketingMailers";
		}
		public var isDeleted:Boolean=false;
				
		public var name:String = "";
	
	}
}