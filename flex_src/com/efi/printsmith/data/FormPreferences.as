package com.efi.printsmith.data
{
	import mx.collections.ArrayCollection; 
	import com.efi.printsmith.data.*;
	
	[RemoteClass(alias="com.efi.printsmith.data.FormPreferences")]
	[Managed]
	
	public dynamic class FormPreferences extends ModelBase
	{

		public function FormPreferences() {
			remoteObjectName = "com.efi.printsmith.data.FormPreferences";
		}
		public var isDeleted:Boolean=false;
				
		public var title:String = "";
		public var styleOption:String = "";
		public var showFromAddress:Boolean = false;
		public var showToAddress:Boolean = false;
		public var showAttn:Boolean = false;
		public var showShipVia:Boolean = false;
		public var showDeliveryDate:Boolean = false;
		public var showCustomPO:Boolean = false;
		public var showOrderNumber:Boolean = false;
		public var showPartNumber:Boolean = false;
		public var showTrackingNumber:Boolean = false;
		public var showReference:Boolean = false;
		public var showDescription:Boolean = false;
		public var showComment:Boolean = false;
		public var showSignature:Boolean = false;
		public var showBarCodes:Boolean = false;
		public var showLogo:Boolean = false;
		public var showDeliveryNumber:Boolean = false;
		public var showDriver:Boolean = false;
		public var showCartonCount:Boolean = false;
		public var logoLeftPosition:Number = 0;
		public var logoTopPosition:Number = 0;
		public var logoAcrossWidth:Number = 0;
		public var logoDownWidth:Number = 0;
		public var fromAddressLeftPosition:Number = 0;
		public var fromAddressTopPosition:Number = 0;
		public var fromAddressAcrossWidth:Number = 0;
		public var fromAddressDownWidth:Number = 0;
		public var toAddressLeftPosition:Number = 0;
		public var toAddressTopPosition:Number = 0;
		public var toAddressAcrossWidth:Number = 0;
		public var toAddressDownWidth:Number = 0;
		public var attnLeftPosition:Number = 0;
		public var attnTopPosition:Number = 0;
		public var attnAcrossWidth:Number = 0;
		public var attnDownWidth:Number = 0;
		public var lineLeftPosition:Number = 0;
		public var lineTopPosition:Number = 0;
		public var lineAcrossWidth:Number = 0;
		public var lineDownWidth:Number = 0;
		public var commentLeftPosition:Number = 0;
		public var commentTopPosition:Number = 0;
		public var commentAcrossWidth:Number = 0;
		public var commentDownWidth:Number = 0;
		public var deliveryDateLeftPosition:Number = 0;
		public var deliveryDateTopPosition:Number = 0;
		public var referenceLeftPosition:Number = 0;
		public var referenceTopPosition:Number = 0;
		public var shipViaLeftPosition:Number = 0;
		public var shipViaTopPosition:Number = 0;
		public var customerPOLeftPosition:Number = 0;
		public var customerPOTopPosition:Number = 0;
		public var orderNumberLeftPosition:Number = 0;
		public var orderNumberTopPosition:Number = 0;
		public var partNumberLeftPosition:Number = 0;
		public var partNumberTopPosition:Number = 0;
		public var trackingNumberLeftPosition:Number = 0;
		public var trackingNumberTopPosition:Number = 0;
		public var deliveryNumberLeftPosition:Number = 0;
		public var deliveryNumberTopPosition:Number = 0;
		public var driverLeftPosition:Number = 0;
		public var driverTopPosition:Number = 0;
		public var cartonCountLeftPosition:Number = 0;
		public var cartonCountTopPosition:Number = 0;
		public var codLeftPosition:Number = 0;
		public var codTopPosition:Number = 0;
		public var descriptionLeftPosition:Number = 0;
		public var descriptionTopPosition:Number = 0;
		public var signatureLeftPosition:Number = 0;
		public var signatureTopPosition:Number = 0;
		public var showDeliveryDateTitle:Boolean = false;
		public var showReferenceTitle:Boolean = false;
		public var showShipViaTitle:Boolean = false;
		public var showCustomerPOTitle:Boolean = false;
		public var showOrderNumberTitle:Boolean = false;
		public var showPartNumberTitle:Boolean = false;
		public var showTrackingNumberTitle:Boolean = false;
		public var showDeliveryNumberTitle:Boolean = false;
		public var showDriverTitle:Boolean = false;
		public var showCartonCountTitle:Boolean = false;
		public var invoiceNumberMargin:Number = 0;
		public var orderedQtyMargin:Number = 0;
		public var shippedQtyMargin:Number = 0;
		public var descriptionMargin:Number = 0;
		public var weightMargin:Number = 0;
		public var invoiceNumberWidth:Number = 0;
		public var orderedQtyWidth:Number = 0;
		public var shippedQtyWidth:Number = 0;
		public var descriptionWidth:Number = 0;
		public var weightWidth:Number = 0;
		public var widthOfAllItems:Number = 0;
		public var addressFontBean:FontDefinition;
		public var dateFontBean:FontDefinition;
		public var bodyTextFontBean:FontDefinition;
		public var formFontBean:FontDefinition;
		public var formImageSource:String = "";
		public var formImagePath:String = "";
		public var logoImageSource:String = "";
		public var logoImagePath:String = "";
		public var dataOffsetLeftRight:Number = 0;
		public var dataOffsetDownUp:Number = 0;
		public var imageOffsetLeftRight:Number = 0;
		public var imageOffsetDownUp:Number = 0;
		public var measurement:String = "";
		public var defaultFlag:Boolean = false;
	
	}
}