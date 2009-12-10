package com.efi.vo
{
	import mx.collections.ArrayCollection; 
	import com.efi.vo.*;
	
	[Bindable]
	[RemoteClass(alias="com.efi.printsmith.data.PreferencesSalesCategory")]

	public class PreferencesSalesCategory extends ModelBase
	{

		public function PreferencesSalesCategory() {
		
		}
		public var category:SalesCategory;
		public var accountNumber:String = "";
	
	}
}