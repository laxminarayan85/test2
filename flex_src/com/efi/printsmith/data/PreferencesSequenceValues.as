package com.efi.printsmith.data
{
	import mx.collections.ArrayCollection; 
	import com.efi.printsmith.data.*;
	
	[RemoteClass(alias="com.efi.printsmith.data.PreferencesSequenceValues")]
	[Managed]
	
	public dynamic class PreferencesSequenceValues extends ModelBase
	{

		public function PreferencesSequenceValues() {
			remoteObjectName = "com.efi.printsmith.data.PreferencesSequenceValues";
		}
		public var isDeleted:Boolean=false;
				
		public var invoice:Number = 0;
		public var job:Number = 0;
		public var pressDefinition:Number = 0;
		public var chargeDefinition:Number = 0;
		public var account:Number = 0;
		public var contact:Number = 0;
		public var stockDefinition:Number = 0;
		public var employee:Number = 0;
		public var broker:Number = 0;
		public var copierDefinition:Number = 0;
		public var campaign:Number = 0;
		public var grade:Number = 0;
		public var creditCard:Number = 0;
		public var estimate:Number = 0;
		public var stockOrder:Number = 0;
		public var deliveryTicket:Number = 0;
		public var charge:Number = 0;
	
	}
}