package com.efi.printsmith.data
{
	import mx.collections.ArrayCollection; 
	import com.efi.printsmith.data.*;
	
	[Bindable]
	[RemoteClass(alias="com.efi.printsmith.data.Campaigns")]

	public class Campaigns extends ModelBase
	{

		public function Campaigns() {
			remoteObjectName = "com.efi.printsmith.data.Campaigns";
		}
				
		public var name:String = "";
		public var applied:Boolean = false;
		public var globalCampaign:Boolean = false;
		public var campaignId:String = "";
	
	}
}