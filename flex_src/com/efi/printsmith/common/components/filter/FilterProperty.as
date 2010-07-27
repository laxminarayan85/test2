package com.efi.printsmith.common.components.filter
{
	public class FilterProperty
	{
		public var subProperty:FilterProperty;
		public var propName:String;
		
		public function FilterProperty(subp:FilterProperty, prop:String){
			this.subProperty = subp;
			this.propName = prop;
		}
		
		public function getValueOf(baseObj:Object):Object	{
			if (baseObj == null)
				return null;
				
			if (subProperty == null)	
				return baseObj[propName];
			else {
				return subProperty.getValueOf(baseObj[propName]);
			}
		}

	}
}