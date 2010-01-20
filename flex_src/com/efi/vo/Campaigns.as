package com.efi.vo
{
	import mx.collections.ArrayCollection; 
	import com.efi.vo.*;
	
	[Bindable]
	[RemoteClass(alias="com.efi.printsmith.data.Campaigns")]

	public class Campaigns extends ModelBase
	{

		public function Campaigns() {
		
		}
		public var name:String = "";
		public var applied:Boolean = true;
		public var globalCampaign:Boolean = true;
	
	}
}