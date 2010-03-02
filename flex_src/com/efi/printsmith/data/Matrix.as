package com.efi.printsmith.data
{
	import mx.collections.ArrayCollection; 
	import com.efi.printsmith.data.*;
	
	[Bindable]
	[RemoteClass(alias="com.efi.printsmith.data.Matrix")]

	public class Matrix extends ModelBase
	{

		public function Matrix() {
			remoteObjectName = "com.efi.printsmith.data.Matrix";
		}
				
		public var headerValues:ArrayCollection;
		public var elements:ArrayCollection;
	
	}
}