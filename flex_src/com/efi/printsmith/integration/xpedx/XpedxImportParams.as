package com.efi.printsmith.integration.xpedx
{
	[RemoteClass(alias="com.efi.printsmith.integration.xpedx.XpedxImportParams")]

	public class XpedxImportParams
	{
		public function XpedxImportParams()
		{
		}
		public var verifyEachStock:Boolean;
		public var fullUpdate:Boolean;
		public var updatePrice1:Boolean;
		public var updatePrice2:Boolean;
		public var updatePrice3:Boolean;
		public var updatePrice4:Boolean;
		public var updatePrice5:Boolean;
		public var adjustValue1:Number;
		public var adjustValue2:Number;
		public var adjustValue3:Number;
		public var adjustValue4:Number;
		public var adjustValue5:Number;
		public var updateType:int;
		public var selectMetric:Boolean;
		public var noBrokenCartons:Boolean;
		public var importAll:Boolean;
	}
}