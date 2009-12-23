package com.efi.vo
{
	import mx.collections.ArrayCollection; 
	import com.efi.vo.*;
	
	[Bindable]
	[RemoteClass(alias="com.efi.printsmith.data.MarketingDateLabels")]

	public class MarketingDateLabels extends ModelBase
	{

		public function MarketingDateLabels() {
			remoteObjectName = "com.efi.printsmith.data.MarketingDateLabels";
		}
				
		public var name:String = "";
	
	}
}