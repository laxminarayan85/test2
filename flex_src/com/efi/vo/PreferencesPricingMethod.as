package com.efi.vo
{
	import mx.collections.ArrayCollection; 
	import com.efi.vo.*;
	
	[Bindable]
	[RemoteClass(alias="com.efi.printsmith.data.PreferencesPricingMethod")]

	public class PreferencesPricingMethod extends ModelBase
	{

		public function PreferencesPricingMethod() {
		
		}
		public var used:Boolean = true;
		public var title:String = "";
		public var abbreviation:String = "";
		public var brokered:Boolean = true;
		public var taxable:Boolean = true;
		public var finished:Boolean = true;
		public var showNotes:Boolean = true;
		public var category:SalesCategory;
		public var estimator:String = "";
	
	}
}