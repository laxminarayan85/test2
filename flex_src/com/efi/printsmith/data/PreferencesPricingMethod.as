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
				
		public var used:Boolean = true;
		public var title:String = "";
		public var abbreviation:String = "";
		public var brokered:Boolean = true;
		public var taxable:Boolean = true;
		public var finished:Boolean = true;
		public var showNotes:Boolean = true;
		public var category:SalesCategory;
		public var estimator:EstimatorTypes;
	
	}
}