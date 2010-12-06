package com.efi.printsmith.data
{
	import mx.collections.ArrayCollection; 
	import com.efi.printsmith.data.*;
	
	[RemoteClass(alias="com.efi.printsmith.data.LabelFormat")]
	[Managed]
	
	public dynamic class LabelFormat extends ModelBase
	{

		public function LabelFormat() {
			remoteObjectName = "com.efi.printsmith.data.LabelFormat";
		}
		public var isDeleted:Boolean=false;
				
		public var name:String = "";
		public var fontDefinition:FontDefinition;
		public var noOfLabelsAcross:Number = 0;
		public var noOfLabelsDown:Number = 0;
		public var labelWidth:Number = 0;
		public var labelHeight:Number = 0;
		public var leftMargin:Number = 0;
		public var topMargin:Number = 0;
		public var spaceOnRight:Number = 0;
		public var spaceOnBottom:Number = 0;
		public var measurements:String = "";
	
	}
}