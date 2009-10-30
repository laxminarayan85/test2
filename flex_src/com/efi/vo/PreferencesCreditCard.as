package com.efi.vo
{
	import mx.collections.ArrayCollection; 
	import com.efi.vo.*;
	
	[Bindable]
	[RemoteClass(alias="com.efi.printsmith.data.PreferencesCreditCard")]

	public class PreferencesCreditCard extends ModelBase
	{

		public function PreferencesCreditCard() {
		
		}
		public var use:Boolean = true;
		public var cardType:String = "";
		public var abbreviation:String = "";
		public var code:String = "";
	
	}
}