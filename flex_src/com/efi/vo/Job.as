package com.efi.vo
{
	import mx.collections.ArrayCollection; 
	import com.efi.vo.*;
	
	[Bindable]
	[RemoteClass(alias="com.efi.printsmith.data.Job")]

	public class Job extends ModelBase
	{

		public function Job() {
		
		}
		public var jobNumber:String = "";
		public var jobIndex:Number = 0;
		public var salesCategory:SalesCategory = new SalesCategory();
		public var productCode:ProductCode = new ProductCode();
		public var children:ArrayCollection;
		public var charges:ArrayCollection;
		public var jobNotes:String = "";
		public var jobTicketNotes:String = "";
		public var brokered:Boolean = true;
		public var taxable:Boolean = true;
		public var finished:Boolean = true;
		public var location:Location = new Location();
		public var comment:String = "";
		public var description:String = "";
		public var qtyOrdered:Number = 0;
		public var oversUnders:Number = 0;
		public var inSetsOf:Number = 0;
		public var sheets:Number = 0;
		public var up:Number = 0;
		public var on:Number = 0;
		public var press:Number = 0;
		public var binderyWaste:Number = 0;
		public var estWaste:Number = 0;
		public var signatures:Number = 0;
		public var pricingPress:PressDefinition = new PressDefinition();
		public var costingPress:PressDefinition = new PressDefinition();
		public var runMethod:String = "";
	
	}
}