package com.efi.vo
{
	import mx.collections.ArrayCollection; 
	import com.efi.vo.*;
	
	[Bindable]
	[RemoteClass(alias="com.efi.printsmith.data.TimeCard")]

	public class TimeCard extends ModelBase
	{

		public function TimeCard() {
		
		}
		public var period:String = "";
		public var startDateTime:Date = new Date();
		public var endDateTime:Date = new Date();
		public var billable:String = "";
		public var onClock:int = 0;
		public var breakTime:Date = new Date();
		public var employee:Employee;
	
	}
}