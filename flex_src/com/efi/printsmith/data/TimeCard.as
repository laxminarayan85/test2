package com.efi.printsmith.data
{
	import mx.collections.ArrayCollection; 
	import com.efi.printsmith.data.*;
	
	[RemoteClass(alias="com.efi.printsmith.data.TimeCard")]
	[Managed]
	
	public dynamic class TimeCard extends ModelBase
	{

		public function TimeCard() {
			remoteObjectName = "com.efi.printsmith.data.TimeCard";
		}
		public var isDeleted:Boolean=false;
				
		public var period:int = 0;
		public var startDateTime:Date = new Date();
		public var endDateTime:Date = new Date();
		public var billable:String = "";
		public var onClock:int = 0;
		public var breakTime:Date = new Date();
		public var employee:Employee;
		public var breakHour:String = "";
		public var paidTimeOff:Boolean = false;
	
	}
}