package com.efi.printsmith.data
{
	import mx.collections.ArrayCollection; 
	import com.efi.printsmith.data.*;
	
	[Bindable]
	[RemoteClass(alias="com.efi.printsmith.data.Employee")]

	public class Employee extends Party
	{

		public function Employee() {
			remoteObjectName = "com.efi.printsmith.data.Employee";
		}
				
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
		public var trackerClockIn:Boolean = true;
		public var showWorkCenter:Boolean = true;
		public var magCardReader:Boolean = true;
		public var includeInvoice:Boolean = true;
		public var includeEstimate:Boolean = true;
		public var includeJobs:Boolean = true;
		public var includeJobCharges:Boolean = true;
		public var includeInvoiceCharges:Boolean = true;
		public var allPricingMethods:Boolean = true;
		public var allPresses:Boolean = true;
		public var allCopiers:Boolean = true;
		public var allChargeTypes:Boolean = true;
		public var onlyShowProductionParents:Boolean = true;
		public var employeePricing:ArrayCollection;
		public var employeeCharges:ArrayCollection;
		public var employeePresses:ArrayCollection;
		public var employeeCopiers:ArrayCollection;
		public var anyPastDue:Boolean = true;
		public var customerWant:String = "";
		public var productionParents:ArrayCollection;
		public var autoHour:int = 0;
		public var autoMin:int = 0;
		public var message:String = "";
		public var showMessageClockout:Boolean = true;
		public var showMessageClockin:Boolean = true;
	
	}
}