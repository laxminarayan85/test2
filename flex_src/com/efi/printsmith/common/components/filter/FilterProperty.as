package com.efi.printsmith.common.components.filter
{
	import mx.collections.ArrayCollection;
	
	public class FilterProperty
	{
		public var subProperty:FilterProperty;
		public var propName:String;
		
		public var isArrayCollection:Boolean;
		public var childObjPropName:String;
		public var conditionalProp:String;
		public var conditionalPropValue:Object;
		
	public function FilterProperty(subp:FilterProperty, prop:String, isArray:Boolean = false, childObjPropName:String = null, conditionalProp:String=null, conditionalPropValue:Object=null){
			this.subProperty = subp;
			this.propName = prop;
			this.isArrayCollection = isArray;
			this.childObjPropName = childObjPropName;
			this.conditionalProp = conditionalProp;
			this.conditionalPropValue = conditionalPropValue;
		}
		
		public function getValueOf(baseObj:Object):Object	{
			if (baseObj == null)
				return null;
				
			if (subProperty == null)	{
				if (!isArrayCollection)
					return baseObj[propName];
				else	{
					if (baseObj[propName] != null)	{
						for (var i:int=0; i<(baseObj[propName] as ArrayCollection).length; i++)	{
							var childObj:Object = (baseObj[propName] as ArrayCollection).getItemAt(i);
							if (childObj[conditionalProp] == conditionalPropValue)	{
								return childObj[childObjPropName]; 
							}
						}
					}
					return null;
				}
			}
			else {
				return subProperty.getValueOf(baseObj[propName]);
			}
		}

	}
}