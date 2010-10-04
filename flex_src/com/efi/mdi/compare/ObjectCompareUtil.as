package com.efi.mdi.compare
{
	import flash.utils.ByteArray;
	import flash.utils.Dictionary;
	import flash.utils.getQualifiedClassName;
	
	import mx.collections.IList;
	import mx.utils.ObjectUtil;
	
	public class ObjectCompareUtil
	{
		public static function compare(a:Object, b:Object, depth:int = -1):int
	    {
	        return internalCompare(a, b, 0, depth, new Dictionary(true));
	    }
	    
	    private static function internalCompare(a:Object, b:Object,
                                            currentDepth:int, desiredDepth:int,
                                            refs:Dictionary, propertyName:Object=null):int
	    {
	        if (a == null && b == null)
	            return 0;
	    
	        if (a == null)
	            return 1;
	    
	        if (b == null)
	            return -1;
	            
	        var typeOfA:String = typeof(a);
	        var typeOfB:String = typeof(b);
	        
	        var result:int = 0;
	        
	        if (typeOfA == typeOfB)
	        {
	            switch(typeOfA)
	            {
	                case "boolean":
	                {
	                    result = numericCompare(Number(a), Number(b));
	                    break;
	                }
	                
	                case "number":
	                {
	                    result = numericCompare(a as Number, b as Number);
	                    break;
	                }
	                
	                case "string":
	                {
	                    result = stringCompare(a as String, b as String);
	                    break;
	                }
	                
	                case "object":
	                {
	                    var newDepth:int = desiredDepth > 0 ? desiredDepth -1 : desiredDepth;
	                    // refs help us avoid circular reference infinite recursion.
	                    // Each time an object is encoumtered it is pushed onto the
	                    // refs stack so that we can determine if we have visited
	                    // this object already.
	                    // Here since we are comparing two objects we can short
	                    // circuit at the first encounter but have to exhaust all
	                    // references found.  A visited reference makes an object 
	                    // "greater" than another object, only if both objects
	                    // have a visited reference will the result be 0
	                    var aRef:Boolean = refs[a];
	                    var bRef:Boolean = refs[b];
	                    
	                    if (aRef && !bRef)
	                        return 1;
	                    else if (bRef && !aRef)
	                        return -1;
	                    else if (bRef && aRef)
	                        return 0;
	                    
	                    refs[a] = true;
	                    refs[b] = true;
	                    
	                    if (desiredDepth != -1 && (currentDepth > desiredDepth))
	                    {
	                        // once we try to go beyond the desired depth we should 
	                        // toString() our way out
	                        result = stringCompare(a.toString(), b.toString());
	                    }
	                    else if ((a is Array) && (b is Array))
	                    {
	                        result = arrayCompare(a as Array, b as Array, currentDepth, desiredDepth, refs);
	                    }
	                    else if ((a is Date) && (b is Date))
	                    {
	                        result = dateCompare(a as Date, b as Date);
	                    }
	                    else if ((a is IList) && (b is IList))
	                    {
	                        result = listCompare(a as IList, b as IList, currentDepth, desiredDepth, refs);
	                    }
	                    else if ((a is ByteArray) && (b is ByteArray))
	                    {
	                        result = byteArrayCompare(a as ByteArray, b as ByteArray);
	                    }
	                    else if (getQualifiedClassName(a) == getQualifiedClassName(b))
	                    {
	                        var aProps:Array = ObjectUtil.getClassInfo(a).properties;
	                        var bProps:Array;
	                        
	                        // if the objects are anonymous they could have different 
	                        // # of properties and should be treated on that basis first
	                        if (getQualifiedClassName(a) == "Object")
	                        {
	                            bProps = ObjectUtil.getClassInfo(b).properties;
	                            result = arrayCompare(aProps, bProps, currentDepth, newDepth, refs);
	                        }
	                        
	                        if (result != 0)
	                        {
	                            return result;
	                        }
	                        
	                        // loop through all of the properties and compare
	                        var propName:QName;
	                        var aProp:Object;
	                        var bProp:Object;
	                        for (var i:int = 0; i < aProps.length; i++)
	                        {
	                            propName = aProps[i];
	                            aProp = a[propName];
	                            bProp = b[propName];
	                            if(propName.localName=="uid"){
	                            	continue;
	                            }
	                            result = internalCompare(aProp, bProp, currentDepth+1, newDepth, refs, propName);
	                            if (result != 0)
	                            {
	                                i = aProps.length;
	                            }
	                        }
	                    }
	                    else
	                    {
	                        // We must be inequal, so return 1
	                        return 1;
	                    }
	                    break;
	                }
	            }
	        }
	        else // be consistent with the order we return here
	        {
	            return stringCompare(typeOfA, typeOfB);
	        }
	
			if(result!=0){
				if(propertyName!=null){
					trace("propertyName==>"+propertyName.toString());
				}
				trace("result==>"+result);
			}
	        return result;
	    }
	    
	    public static function numericCompare(a:Number, b:Number):int
	    {
	        if (isNaN(a) && isNaN(b))
	            return 0;
	
	        if (isNaN(a))
	            return 1;
	
	        if (isNaN(b))
	           return -1;
	
	        if (a < b)
	            return -1;
	
	        if (a > b)
	            return 1;
	
	        return 0;
	    }
	    
	    public static function stringCompare(a:String, b:String,
                                         caseInsensitive:Boolean = false):int
	    {
	        if (a == null && b == null)
	            return 0;
	
	        if (a == null)
	          return 1;
	
	        if (b == null)
	           return -1;
	
	        // Convert to lowercase if we are case insensitive.
	        if (caseInsensitive)
	        {
	            a = a.toLocaleLowerCase();
	            b = b.toLocaleLowerCase();
	        }
	
	        var result:int = a.localeCompare(b);
	        
	        if (result < -1)
	            result = -1;
	        else if (result > 1)
	            result = 1;
	
	        return result;
	    }
	    
	    public static function dateCompare(a:Date, b:Date):int
	    {
	        if (a == null && b == null)
	            return 0;
	
	        if (a == null)
	          return 1;
	
	        if (b == null)
	           return -1;
	
	        var na:Number = a.getTime();
	        var nb:Number = b.getTime();
	        
	        if (na < nb)
	            return -1;
	
	        if (na > nb)
	            return 1;
	
	        return 0;
	    }
	    
	    private static function arrayCompare(a:Array, b:Array,
                                         currentDepth:int, desiredDepth:int,
                                         refs:Dictionary):int
	    {
	        var result:int = 0;
	
	        if (a.length != b.length)
	        {
	            if (a.length < b.length)
	                result = -1;
	            else
	                result = 1;
	        }
	        else
	        {
	            var key:Object;
	            for (key in a)
	            {
	                if (b.hasOwnProperty(key))
	                {
	                    result = internalCompare(a[key], b[key], currentDepth,
	                                         desiredDepth, refs, key);
	
	                    if (result != 0)
	                        return result;
	                }
	                else
	                {
	                    return -1;
	                }
	            }
	
	            for (key in b)
	            {
	                if (!a.hasOwnProperty(key))
	                {
	                    return 1;
	                }
	            }
	        }
	
	        return result;
	    }
	    
	    private static function listCompare(a:IList, b:IList, currentDepth:int, 
                                        desiredDepth:int, refs:Dictionary):int
	    {
	        var result:int = 0;
	
	        if (a.length != b.length)
	        {
	            if (a.length < b.length)
	                result = -1;
	            else
	                result = 1;
	        }
	        else
	        {
	            for (var i:int = 0; i < a.length; i++)
	            {
	                result = internalCompare(a.getItemAt(i), b.getItemAt(i), 
	                                         currentDepth+1, desiredDepth, refs);
	                if (result != 0)
	                {
	                    i = a.length;
	                }
	            }
	        }
	
	        return result;
    	}
    	
    	private static function byteArrayCompare(a:ByteArray, b:ByteArray):int
	    {
	        var result:int = 0;
	        if (a.length != b.length)
	        {
	            if (a.length < b.length)
	                result = -1;
	            else
	                result = 1;
	        }
	        else
	        {
	            a.position = 0;
	            b.position = 0;
	            for (var i:int = 0; i < a.length; i++)
	            {
	                result = numericCompare(a.readByte(), b.readByte());
	                if (result != 0)
	                {
	                    i = a.length;
	                }
	            }
	        }
	        return result;
	    }

	}
}