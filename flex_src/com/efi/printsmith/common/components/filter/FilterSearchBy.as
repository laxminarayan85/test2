package com.efi.printsmith.common.components.filter
{
	public class FilterSearchBy
	{
		public var displayLabel:String;
		public var property:FilterProperty;
		

		public function FilterSearchBy(label:String, prop:FilterProperty){
			this.displayLabel = label;
			this.property = prop;
		}
		

	}
}