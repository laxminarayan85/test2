package com.efi.vo
{
	import mx.collections.ArrayCollection; 
	import com.efi.vo.*;
	
	[Bindable]
	[RemoteClass(alias="com.efi.printsmith.data.Employee")]

	public class Employee extends ModelBase
	{

		public function Employee() {
		
		}
		public var firstName:String = "";
		public var lastName:String = "";
		public var address:Address = new Address();
		public var comLinks:ArrayCollection;
		public var sSN:String = "";
		public var exportCode:int = 0;
		public var clockIn:Boolean = true;
		public var clockOut:Boolean = true;
		public var clockBreak:Boolean = true;
		public var rate:Number = 0;
		public var active:Boolean = true;
		public var pinRequired:Boolean = true;
		public var pin:String = "";
		public var allowOverrideCost:Boolean = true;
		public var costingAmounts:Boolean = true;
		public var hideNonReleaseProduction:Boolean = true;
		public var hideEstimateTimeTracker:Boolean = true;
		public var productionSettings:Boolean = true;
		public var trackerNextLocation:Boolean = true;
		public var trackerClockIn:int = 0;
		public var showWorkCenter:Boolean = true;
		public var magCardReader:Boolean = true;
		public var includeInvoice:Boolean = true;
		public var includeEstimate:Boolean = true;
		public var includeJobs:Boolean = true;
		public var includeJobCharges:Boolean = true;
		public var includeInvoiceCharges:int = 0;
		public var allPricingMethods:Boolean = true;
		public var allPresses:Boolean = true;
		public var allCopiers:Boolean = true;
		public var allChargeTypes:Boolean = true;
		public var onlyShowProductionParents:ArrayCollection;
		public var employeePricing:ArrayCollection;
		public var employeeCharges:ArrayCollection;
		public var employeePresses:ArrayCollection;
		public var employeeCopiers:ArrayCollection;
	
	}
}