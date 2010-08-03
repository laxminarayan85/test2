package com.efi.printsmith.model
{
	import mx.collections.ArrayCollection;
	
	[Bindable]
	public dynamic class EmployeeTimeExportBean
	{
		public var format:String;
		
		public var rangeType:String;
		
		public var periodFrom:Number;
		
		public var periodTo:Number;
		
		public var dateFrom:Date;
		
		public var dateTo:Date;
		
		public var includeFieldNames:Boolean = false;
		
		public var delimitedType:String;
		
		public var lineEndType:String;
		
		public var selectedEmployees:ArrayCollection = new ArrayCollection();
		
		public var selectedFields:ArrayCollection = new ArrayCollection();

	}
}