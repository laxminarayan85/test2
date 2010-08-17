package com.efi.printsmith.data
{
	import mx.collections.ArrayCollection; 
	import com.efi.printsmith.data.*;
	
	[RemoteClass(alias="com.efi.printsmith.data.Employee")]
	[Managed]
	
	public dynamic class Employee extends Party
	{

		public function Employee() {
			remoteObjectName = "com.efi.printsmith.data.Employee";
		}
				
		public var socialSecurity:String = "";
		public var exportCode:int = 0;
		public var clockIn:Boolean = false;
		public var clockOut:Boolean = false;
		public var clockBreak:Boolean = false;
		public var rate:Number = 0;
		public var active:Boolean = false;
		public var pinRequired:Boolean = false;
		public var pin:String = "";
		public var allowOverrideCost:Boolean = false;
		public var costingAmounts:Boolean = false;
		public var hideNonReleaseProduction:Boolean = false;
		public var hideEstimateTimeTracker:Boolean = false;
		public var productionSettings:Boolean = false;
		public var trackerNextLocation:Boolean = false;
		public var trackerClockIn:Boolean = false;
		public var showWorkCenter:Boolean = false;
		public var magCardReader:Boolean = false;
		public var includeInvoice:Boolean = false;
		public var includeEstimate:Boolean = false;
		public var includeJobs:Boolean = false;
		public var includeJobCharges:Boolean = false;
		public var includeInvoiceCharges:Boolean = false;
		public var allPricingMethods:Boolean = false;
		public var allPresses:Boolean = false;
		public var allCopiers:Boolean = false;
		public var allChargeTypes:Boolean = false;
		public var onlyShowProductionParents:Boolean = false;
		public var employeePricings:ArrayCollection;
		public var employeeCharges:ArrayCollection;
		public var employeePresses:ArrayCollection;
		public var employeeCopiers:ArrayCollection;
		public var anyPastDue:Boolean = false;
		public var customerWant:String = "";
		public var productionParents:ArrayCollection;
		public var autoHour:int = 0;
		public var autoMin:int = 0;
		public var message:String = "";
		public var showMessageClockout:Boolean = false;
		public var showMessageClockin:Boolean = false;
		public var employeeId:String = "";
	
	}
}