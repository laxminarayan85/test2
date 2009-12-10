package com.efi.vo
{
	import mx.collections.ArrayCollection; 
	import com.efi.vo.*;
	
	[Bindable]
	[RemoteClass(alias="com.efi.printsmith.data.Charge")]

	public class Charge extends ModelBase
	{

		public function Charge() {
		
		}
		public var chargeDefinition:ChargeDefinition;
		public var description:String = "";
		public var notes:String = "";
		public var productionLocation:Location;
		public var showNotes:Boolean = true;
		public var finished:Boolean = true;
		public var attribute1:int = 0;
		public var taxable:Boolean = true;
		public var attribute2:int = 0;
		public var brokered:Boolean = true;
		public var attribute3:int = 0;
		public var displayQty:Boolean = true;
		public var hidden:Boolean = true;
		public var hidePrice:Boolean = true;
	
	}
}