package com.efi.vo
{
	import mx.collections.ArrayCollection; 
	import com.efi.vo.*;
	
	[Bindable]
	[RemoteClass(alias="com.efi.printsmith.data.PreferencesMarkups")]

	public class PreferencesMarkups extends ModelBase
	{

		public function PreferencesMarkups() {
		
		}
		public var outsideService:Boolean = true;
		public var merchandise:int = 0;
		public var totalCost:Number = 0;
		public var markup:Number = 0;
		public var above:Boolean = true;
	
	}
}