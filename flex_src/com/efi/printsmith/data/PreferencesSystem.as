package com.efi.printsmith.data
{
	import mx.collections.ArrayCollection; 
	import com.efi.printsmith.data.*;
	
	[RemoteClass(alias="com.efi.printsmith.data.PreferencesSystem")]
	[Managed]
	
	public class PreferencesSystem extends ModelBase
	{

		public function PreferencesSystem() {
			remoteObjectName = "com.efi.printsmith.data.PreferencesSystem";
		}
				
		public var eliminateWarningMessages:Boolean = false;
		public var onlyPostMarkedReadyInvoices:Boolean = false;
		public var enablePricingSystem:Boolean = false;
		public var activateUserEventLogging:Boolean = false;
		public var enableAutoLogOut:Boolean = false;
		public var secondsOfInactivity:Boolean = false;
		public var autoLogOutSeconds:int = 0;
		public var triggerAfterPosting:Boolean = false;
		public var showInvoicesWithToday:Boolean = false;
		public var lineItemTaxes:Boolean = false;
		public var automaticQuit:Boolean = false;
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
		public var workSunday:Boolean = false;
		public var workMonday:Boolean = false;
		public var workTuesday:Boolean = false;
		public var workWednesday:Boolean = false;
		public var workThursday:Boolean = false;
		public var workFriday:Boolean = false;
		public var workSaturday:Boolean = false;
		public var workFirstDayOfWeek:int = 0;
		public var futureDatesExcludeClosed:Boolean = false;
		public var numbersIntegers:String = "";
		public var numbersPercentages:String = "";
		public var numbersAmount:String = "";
		public var numbersTaxRate:String = "";
		public var numbersRate:String = "";
		public var numbersFactor:String = "";
		public var numbersInvoice:String = "";
		public var numbersShortPercent:String = "";
		public var numbersRoundto:int = 0;
		public var alwaysRoundDown:Boolean = false;
		public var roundTaxUp:Boolean = false;
		public var useAlternateCurrency:Boolean = false;
		public var displayFormat:String = "";
		public var conversionFactor:Number = 0;
		public var alternateRoundto:int = 0;
		public var alternateAlwaysRoundDown:Boolean = false;
		public var disableTextStyles:Boolean = false;
		public var austrailianInvoiceRounding:Boolean = false;
		public var disableNonTaxableOptions:Boolean = false;
		public var inkWeightSingular:String = "";
		public var inkWeightPlural:String = "";
		public var authorizeDecrypt:String = "";
		public var creditCardApproval:String = "";
		public var trackerDataCollection:String = "";
		public var defaultCountry:int = 0;
		public var serialNumber:String = "";
		public var programType:String = "";
		public var webEnabled:Boolean = false;
		public var paymentPlanEnabled:Boolean = false;
		public var schedulerEnabled:Boolean = false;
		public var trackerEnabled:Boolean = false;
		public var maximumNodeCount:int = 0;
		public var expirationDate:Date = new Date();
		public var cCEncryptionData:String = "";
		public var pEK1:String = "";
		public var pEK2:String = "";
		public var pEK3:String = "";
		public var reportWriterEnabled:Boolean = false;
		public var extendedPriceBookEnabled:Boolean = false;
		public var maximumTransactionCount:int = 0;
	
	}
}