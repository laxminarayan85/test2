// ActionScript file
import com.efi.printsmith.common.components.CommonConfirmationComponent;

import flash.display.DisplayObject;
import flash.utils.ByteArray;

import mx.collections.ArrayCollection;
import mx.collections.Sort;
import mx.collections.SortField;
import mx.managers.PopUpManager;

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

 public function numToChar(num:int):String {
        if (num > 47 && num < 58) {
            var strNums:String = "0123456789";
            return strNums.charAt(num - 48);
        } else if (num > 64 && num < 91) {
            var strCaps:String = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
            return strCaps.charAt(num - 65);
        } else if (num > 96 && num < 123) {
            var strLow:String = "abcdefghijklmnopqrstuvwxyz";
            return strLow.charAt(num - 97);
        } else {
        	if (num == 32)
        		return " ";
        	else
            	return num.toString();
        }
    }   

	public function findFirstIndexByCondition(ac:ArrayCollection, propName:String, propValue:Object):int	{
		for (var i:int=0; i<ac.length; i++)	{
			var obj:Object = ac.getItemAt(i);
			if (obj[propName] == propValue)	{
				return i;
			}
		}
		return -1;
	}
		
	public function findFirstItemByCondition(ac:ArrayCollection, propName:String, propValue:Object):Object	{
		for (var i:int=0; i<ac.length; i++)	{
			var obj:Object = ac.getItemAt(i);
			if (obj[propName] == propValue)	{
				return obj;
			}
		}
		return null;
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

private function defaultToZeroIfNull(value:Number):Number {
	if(isNaN(value))
		return 0;
	return value; 
}

private function removeSymbols(value:String,symbol:String):String {
	for (;value.indexOf(symbol, 0) != -1;) {
		value = value.replace(symbol,"");
	}
	return value;
}

private function openConfirmationComponent(confirmationText:String=null, parentWindow:DisplayObject=null):void {
	var commonConfirmationComponent:CommonConfirmationComponent;
	if(parentWindow==null) {
		commonConfirmationComponent = PopUpManager.createPopUp(this,CommonConfirmationComponent,false) as CommonConfirmationComponent;
		commonConfirmationComponent.confirmationText = confirmationText;
	} else {
		commonConfirmationComponent = PopUpManager.createPopUp(parentWindow,CommonConfirmationComponent,false) as CommonConfirmationComponent;
		commonConfirmationComponent.confirmationText = confirmationText;
	}
}
 
public function cloneAC(src:ArrayCollection):ArrayCollection	{
	var dest:ArrayCollection;
	
	if (src != null)	{
		dest = new ArrayCollection();
		
		for (var i:int=0; i < src.length; i++)	{
			dest.addItem(src.getItemAt(i));
		}
	}
	return dest;	
}
 
public function stringIsAValidNumber(s: String) : Boolean {
    return Boolean(s.match(/^[0-9]+.?[0-9]+$/));
}