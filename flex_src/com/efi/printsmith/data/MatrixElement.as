package com.efi.printsmith.data
{
	import mx.collections.ArrayCollection; 
	import com.efi.printsmith.data.*;
	
	[Bindable]
	[RemoteClass(alias="com.efi.printsmith.data.MatrixElement")]

	public class MatrixElement extends ModelBase
	{

		public function MatrixElement() {
			remoteObjectName = "com.efi.printsmith.data.MatrixElement";
		}
				
		public var qty:int = 0;
		public var price1:Number = 0;
		public var price2:Number = 0;
		public var price3:Number = 0;
		public var price4:Number = 0;
		public var price5:Number = 0;
		public var price6:Number = 0;
		public var price7:Number = 0;
		public var price8:Number = 0;
		public var price9:Number = 0;
		public var price10:Number = 0;
	
	}
}