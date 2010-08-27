package com.efi.printsmith.data
{
	import mx.collections.ArrayCollection; 
	import com.efi.printsmith.data.*;
	
	[RemoteClass(alias="com.efi.printsmith.data.Matrix")]
	[Managed]
	
	public dynamic class Matrix extends ModelBase
	{

		public function Matrix() {
			remoteObjectName = "com.efi.printsmith.data.Matrix";
		}
		public var isDeleted:Boolean=false;
				
		public var header1:Number = 0;
		public var header2:Number = 0;
		public var header3:Number = 0;
		public var header4:Number = 0;
		public var header5:Number = 0;
		public var header6:Number = 0;
		public var header7:Number = 0;
		public var header8:Number = 0;
		public var header9:Number = 0;
		public var header10:Number = 0;
		public var elements:ArrayCollection;
	
	}
}