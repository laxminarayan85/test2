package com.efi.printsmith.data.enums
{
	import flash.utils.describeType;
[Bindable]
[RemoteClass(alias="com.efi.printsmith.data.ApplicationCommandId")]
	public class ApplicationCommandId
	{
public enum ApplicationCommandId implements CommandId {
		public static const QuickAccess = "QuickAccess";
		public static const AccountPicker = "AccountPicker";
		public static const CashRegister = "CashRegister";
		public static const ChargeDefinitions = "ChargeDefinitions";
		public static const ChargePicker = "ChargePicker";
		public static const ClockInOut = "ClockInOut";
		public static const CopierDefinitions = "CopierDefinitions";
		public static const EditCampaigns = "EditCampaigns";
		public static const EditContact = "EditContact";
		public static const EditCustomer = "EditCustomer";
		public static const EditEmployee = "EditEmployee";
		public static const EditInvoice = "EditInvoice";
		public static const EditJob = "EditJob";
		public static const EditUser = "EditUser";
		public static const EmployeeManager = "EmployeeManager";
		public static const EmployeePicker = "EmployeePicker";
		public static const EstimateHistory = "EstimateHistory";
		public static const ListUsers = "ListUsers";
		public static const NotePadEditor = "NotePadEditor";
		public static const PendingList = "PendingList";
		public static const PressDefinitions = "PressDefinitions";
		public static const PriceListEditor = "PriceListEditor";
		public static const PriceListPicker = "PriceListPicker";
		public static const ScheduleManager = "ScheduleManager";
		public static const SecurityManager = "SecurityManager";
		public static const StockDefinitions = "StockDefinitions";
		public static const StockPicker = "StockPicker";
		public static const SystemPreferences = "SystemPreferences";
		public static const TimeCardView = "TimeCardView";
		public static const TimePeriodView = "TimePeriodView";
		public static const Tracker = "Tracker";
		public static const Utilities = "Utilities";
		
		public function ApplicationCommandId() {}
	 
		public static function toArray():Array
		{
			var returnArray:Array = new Array();
			var classInfo:XML = describeType(ChargeMarkupType);
			for each (var v:XML in classInfo..constant)
			{
				var name:String = String(v.@name);
			    	var value:String = ChargeMarkupType[name];
			    	returnArray.push(value);
			}
			returnArray.sort();
			return returnArray;
		}

	}
}