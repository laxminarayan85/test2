// ActionScript file
import mx.collections.ArrayCollection;
import mx.formatters.NumberFormatter;


public function getCustomTextData(comboData:Object, temp:Object):ArrayCollection{
	var tempCollection:ArrayCollection = new ArrayCollection();
	tempCollection.addItem(comboData);
	tempCollection.addItem(temp);
	return tempCollection;
}

public function formatValues(precison:Number,useThousandsSeparator:Boolean,rounding:String,value:Object):String{
	if(isNaN(Number(value))){
		return "";
	}
	var numberFormatter:NumberFormatter = new NumberFormatter();
	numberFormatter.precision=precison;
	numberFormatter.rounding=rounding;
	numberFormatter.useThousandsSeparator=useThousandsSeparator;
	var number:String = formatDecimals(numberFormatter.format(value))
	if(number=="0"){
		return "";
	} else 
		return number;
}

private function formatDecimals(formattedString:String):String{
	var index:Number=0;
	var formattedNumber:String="";
	if(formattedString.indexOf(".")!=-1){
		for(var i:int=formattedString.length-1;i>=formattedString.indexOf(".");i--){
			if(formattedString.charAt(i)=="0"){
				index=i;
			}
			else {
				break;
			}
		}
		if(index==0){
			formattedNumber = formattedString;
		}
		else {
			if(formattedString.substring(index-1,index)=="."){
				formattedNumber = formattedString.substring(0,index-1);
			}
			else {
				formattedNumber = formattedString.substring(0,index);
			}
		}
	}
	else {
		formattedNumber = formattedString;
	}
	return formattedNumber;
}

public function formatValuesWithAppendZeros(precison:Number,useThousandsSeparator:Boolean,rounding:String,value:Object):String{
	var numberFormatter:NumberFormatter = new NumberFormatter();
	numberFormatter.precision=precison;
	numberFormatter.rounding=rounding;
	numberFormatter.useThousandsSeparator=useThousandsSeparator;
	if(isNaN(Number(value))){
		return numberFormatter.format(0);
	}
	var number:String = numberFormatter.format(value);
	if(Number(number) == 0){
		return numberFormatter.format(0);
	}
	return number;
}