package com.efi.printsmith.data
{
	import mx.collections.ArrayCollection; 
	import com.efi.printsmith.data.*;
	
	[RemoteClass(alias="com.efi.printsmith.data.PreferencesStocks")]
	[Managed]
	public class PreferencesStocks extends ModelBase
	{

		public function PreferencesStocks() {
			remoteObjectName = "com.efi.printsmith.data.PreferencesStocks";
		}
				
		public var weight:String = "";
		public var points:String = "";
		public var microns:String = "";
		public var plies:String = "";
		public var millimeters:String = "";
		public var customerCost:Number = 0;
		public var customerQuantity:int = 0;
		public var customerMarkup:Number = 0;
		public var markupOnly:Boolean = true;
		public var stdQty1:int = 0;
		public var stdQty2:int = 0;
		public var stdQty3:int = 0;
		public var stdQty4:int = 0;
		public var stdQty5:int = 0;
		public var stdQty6:int = 0;
		public var stdMarkup1:Number = 0;
		public var stdMarkup2:Number = 0;
		public var stdMarkup3:Number = 0;
		public var stdMarkup4:Number = 0;
		public var stdMarkup5:Number = 0;
		public var stdMarkup6:Number = 0;
		public var blankQty1:int = 0;
		public var blankQty2:int = 0;
		public var blankQty3:int = 0;
		public var blankQty4:int = 0;
		public var blankQty5:int = 0;
		public var blankQty6:int = 0;
		public var blankMarkup1:Number = 0;
		public var blankMarkup2:Number = 0;
		public var blankMarkup3:Number = 0;
		public var blankMarkup4:Number = 0;
		public var blankMarkup5:Number = 0;
		public var blankMarkup6:Number = 0;
		public var sizeTable:SizeTable;
	
	}
}