package com.efi.printsmith.data
{
	import mx.collections.ArrayCollection; 
	import com.efi.printsmith.data.*;
	
	[RemoteClass(alias="com.efi.printsmith.data.PreferencesPricingMethod")]
	[Managed]
	
	public class PreferencesPricingMethod extends ModelBase
	{

		public function PreferencesPricingMethod() {
			remoteObjectName = "com.efi.printsmith.data.PreferencesPricingMethod";
		}
				
		public var used:Boolean = false;
		public var title:String = "";
		public var abbreviation:String = "";
		public var brokered:Boolean = false;
		public var taxable:Boolean = false;
		public var finished:Boolean = false;
		public var showNotes:Boolean = false;
		public var category:SalesCategory;
		public var estimator:EstimatorTypes;
	
	}
}