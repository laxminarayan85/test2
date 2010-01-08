package com.efi.vo
{
	import mx.collections.ArrayCollection; 
	import com.efi.vo.*;
	
	[Bindable]
	[RemoteClass(alias="com.efi.printsmith.data.PreferencesQuantityBreaks")]

	public class PreferencesQuantityBreaks extends ModelBase
	{

		public function PreferencesQuantityBreaks() {
		
		}
		public var quantity:int = 0;
		public var qtyBreak:Boolean = true;
		public var jobMethod:JobMethod;
	
	}
}