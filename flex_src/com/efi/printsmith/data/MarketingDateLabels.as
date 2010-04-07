package com.efi.printsmith.data
{
	import mx.collections.ArrayCollection; 
	import com.efi.printsmith.data.*;
	
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