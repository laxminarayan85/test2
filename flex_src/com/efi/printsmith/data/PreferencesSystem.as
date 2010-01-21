package com.efi.printsmith.data
{
	import mx.collections.ArrayCollection; 
	import com.efi.printsmith.data.*;
	
	[Bindable]
	[RemoteClass(alias="com.efi.printsmith.data.PreferencesSystem")]

	public class PreferencesSystem extends ModelBase
	{

		public function PreferencesSystem() {
			remoteObjectName = "com.efi.printsmith.data.PreferencesSystem";
		}
				
		public var eliminateWarningMessages:Boolean = true;
		public var onlyPostMarkedReadyInvoices:Boolean = true;
		public var enablePricingSystem:Boolean = true;
		public var activateUserEventLogging:Boolean = true;
		public var enableAutoLogOut:Boolean = true;
		public var secondsOfInactivity:Boolean = true;
		public var autoLogOutSeconds:int = 0;
		public var triggerAfterPosting:Boolean = true;
		public var showInvoicesWithToday:Boolean = true;
		public var lineItemTaxes:Boolean = true;
		public var automaticQuit:Boolean = true;
		public var quitTime:String = "";
		public var shutdownMessage:String = "";
		public var companyAddress:Address;
		public var companyPhone:String = "";
		public var companyFax:String = "";
		public var companyEmail:String = "";
		public var companyOther1:String = "";
		public var companyOther2:String = "";
		public var companyIdLabel:String = "";
		public var companyId:String = "";
		public var companyStoreNumber:String = "";
		public var companyStoreLocationRef:String = "";
		public var fiscalYearStartMonth:String = "";
		public var workSunday:Boolean = true;
		public var workMonday:Boolean = true;
		public var workTuesday:Boolean = true;
		public var workWednesday:Boolean = true;
		public var workThursday:Boolean = true;
		public var workFriday:Boolean = true;
		public var workSaturday:Boolean = true;
		public var workFirstDayOfWeek:int = 0;
		public var futureDatesExcludeClosed:Boolean = true;
		public var numbersIntegers:String = "";
		public var numbersPercentages:String = "";
		public var numbersAmount:String = "";
		public var numbersTaxRate:String = "";
		public var numbersRate:String = "";
		public var numbersFactor:String = "";
		public var numbersInvoice:String = "";
		public var numbersShortPercent:String = "";
		public var numbersRoundto:int = 0;
		public var alwaysRoundDown:Boolean = true;
		public var roundTaxUp:Boolean = true;
		public var useAlternateCurrency:Boolean = true;
		public var displayFormat:String = "";
		public var conversionFactor:Number = 0;
		public var alternateRoundto:int = 0;
		public var alternateAlwaysRoundDown:Boolean = true;
		public var disableTextStyles:Boolean = true;
		public var austrailianInvoiceRounding:Boolean = true;
		public var disableNonTaxableOptions:Boolean = true;
		public var inkWeightSingular:String = "";
		public var inkWeightPlural:String = "";
		public var authorizeDecrypt:String = "";
		public var creditCardApproval:String = "";
		public var trackerDataCollection:String = "";
		public var defaultCountry:int = 0;
	
	}
}