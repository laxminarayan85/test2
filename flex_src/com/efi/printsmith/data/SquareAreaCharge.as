package com.efi.printsmith.data
{
	import mx.collections.ArrayCollection; 
	import com.efi.printsmith.data.*;
	
	[RemoteClass(alias="com.efi.printsmith.data.SquareAreaCharge")]
	[Managed]
	
	public class SquareAreaCharge extends Charge
	{

		public function SquareAreaCharge() {
			remoteObjectName = "com.efi.printsmith.data.SquareAreaCharge";
		}
				
		public var overrideArea:Boolean = false;
		public var area:Number = 0;
	
	}
}