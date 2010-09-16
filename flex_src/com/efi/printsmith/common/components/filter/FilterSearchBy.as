package com.efi.printsmith.common.components.filter
{
	public class FilterSearchBy
	{
		public var displayLabel:String;
		public var property:FilterProperty;
		
		public var searchFunction:Function;
		
		public function FilterSearchBy(label:String, prop:FilterProperty, searchFunction:Function = null){
			this.displayLabel = label;
			this.property = prop;
			this.searchFunction = searchFunction;
		}
		

	}
}