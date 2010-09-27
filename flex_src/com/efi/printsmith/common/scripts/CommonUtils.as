// ActionScript file
import flash.utils.ByteArray;

import mx.collections.Sort;
import mx.collections.SortField;

public function sortArray(ac:ArrayCollection, prop:String):void	{
	var sortField:SortField = new SortField();
	sortField.name = prop;
	sortField.caseInsensitive = true;
	sortField.numeric = false;
	var sort:Sort = new Sort();
	sort.fields = [sortField];
	ac.sort = sort;
	ac.refresh();	
}

public function compareObject(obj1:Object,obj2:Object):Boolean
{
    var buffer1:ByteArray = new ByteArray();
    buffer1.writeObject(obj1);
    var buffer2:ByteArray = new ByteArray();
    buffer2.writeObject(obj2);
 
    // compare the lengths
    var size:uint = buffer1.length;
    if (buffer1.length == buffer2.length) {
        buffer1.position = 0;
        buffer2.position = 0;
 
        // then the bits
        while (buffer1.position < size) {
            var v1:int = buffer1.readByte();
            if (v1 != buffer2.readByte()) {
                return false;
            }
        }    
        return true;                        
    }
    return false;
}


 private function scrubTimeValue(value:Date):Date
 {
    if (value is Date)
    {
        return new Date(value.getFullYear(), value.getMonth(), value.getDate());
    }
    return null;
 }
