package com.efi.printsmith.data
{
	import mx.collections.ArrayCollection; 
	import com.efi.printsmith.data.*;
	
	[RemoteClass(alias="com.efi.printsmith.data.FontDefinition")]
	[Managed]
	
	public dynamic class FontDefinition extends ModelBase
	{

		public function FontDefinition() {
			remoteObjectName = "com.efi.printsmith.data.FontDefinition";
		}
				
		public var fontName:String = "";
		public var size:int = 0;
		public var isBold:Boolean = false;
		public var isItalic:Boolean = false;
		public var isUnderline:Boolean = false;
		public var isOutline:Boolean = false;
		public var isShadow:Boolean = false;
		public var isCondensed:Boolean = false;
		public var extended:Boolean = false;
	
	}
}