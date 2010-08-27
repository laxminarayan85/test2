package com.efi.printsmith.data
{
	import mx.collections.ArrayCollection; 
	import com.efi.printsmith.data.*;
	
	[RemoteClass(alias="com.efi.printsmith.data.InkCharge")]
	[Managed]
	
	public dynamic class InkCharge extends Charge
	{

		public function InkCharge() {
			remoteObjectName = "com.efi.printsmith.data.InkCharge";
		}
		public override var isDeleted:Boolean=false;
				
		public var coverage:Number = 0;
		public var inkWeight:Number = 0;
		public var coverPerPound:Number = 0;
		public var pricePerPound:Number = 0;
		public var poundsOfInk:Number = 0;
	
	}
}