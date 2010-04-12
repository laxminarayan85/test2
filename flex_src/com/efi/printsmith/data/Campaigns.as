package com.efi.printsmith.data
{
	import mx.collections.ArrayCollection; 
	import com.efi.printsmith.data.*;
	
	[RemoteClass(alias="com.efi.printsmith.data.Campaigns")]
	[Managed]
	public class Campaigns extends ModelBase
	{

		public function Campaigns() {
			remoteObjectName = "com.efi.printsmith.data.Campaigns";
		}
				
		public var name:String = "";
		public var applied:Boolean = true;
		public var globalCampaign:Boolean = true;
		public var campaignId:String = "";
	
	}
}