package com.efi.printsmith.data.enums
{
	import flash.utils.describeType;
[Bindable]
[RemoteClass(alias="com.efi.printsmith.data.Estimator")]
	public class Estimator
	{
	 	public static const BlankStock:String = "BlankStock";
	 	public static const ChargesOnly:String = "ChargesOnly";
	 	public static const CopierDefinitions:String = "CopierDefinitions";
	 	public static const GeneralMerchandise:String = "GeneralMerchandise";
	 	public static const LinesAndInches:String = "LinesAndInches";
	 	public static const ListPrice:String = "ListPrice";
	 	public static const MultipleParts:String = "MultipleParts";
	 	public static const OutsideServices:String = "OutsideServices";
	 	public static const PressDefinitions:String = "PressDefinitions";
	
		public function Estimator() {}
	 
	 	public static function getString(value:String):String {
	 		return Snowmass.getInstance().getLocalizedEnum("Estimator", value);
	 	}
	 	
	 	public static function toArray():Array {
	 		var returnArray:Array = new Array();
			var object:Object;
			object = new Object();
			object.label = getString(BlankStock);
			object.data = BlankStock;
			returnArray.push(object);
			object = new Object();
			object.label = getString(ChargesOnly);
			object.data = ChargesOnly;
			returnArray.push(object);
			object = new Object();
			object.label = getString(CopierDefinitions);
			object.data = CopierDefinitions;
			returnArray.push(object);
			object = new Object();
			object.label = getString(GeneralMerchandise);
			object.data = GeneralMerchandise;
			returnArray.push(object);
			object = new Object();
			object.label = getString(LinesAndInches);
			object.data = LinesAndInches;
			returnArray.push(object);
			object = new Object();
			object.label = getString(ListPrice);
			object.data = ListPrice;
			returnArray.push(object);
			object = new Object();
			object.label = getString(MultipleParts);
			object.data = MultipleParts;
			returnArray.push(object);
			object = new Object();
			object.label = getString(OutsideServices);
			object.data = OutsideServices;
			returnArray.push(object);
			object = new Object();
			object.label = getString(PressDefinitions);
			object.data = PressDefinitions;
			returnArray.push(object);
			return returnArray;
		}
	}
}