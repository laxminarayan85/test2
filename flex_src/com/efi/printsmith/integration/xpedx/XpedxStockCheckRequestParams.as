package com.efi.printsmith.integration.xpedx
{
	[RemoteClass(alias="com.efi.printsmith.integration.xpedx.XpedxStockCheckRequestParams")]

	public class XpedxStockCheckRequestParams
	{
		public function XpedxStockCheckRequestParams()
		{
		}
		public var id:Number;
		public var xpedxId:String;
		public var qty:Number;
	}
}