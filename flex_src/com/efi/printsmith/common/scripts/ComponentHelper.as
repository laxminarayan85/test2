// ActionScript file
import mx.collections.ArrayCollection;
import mx.formatters.NumberFormatter;


public function getCustomTextData(comboData:Object, temp:Object, value:Object):ArrayCollection{
	var tempCollection:ArrayCollection = new ArrayCollection();
	tempCollection.addItem(comboData);
	tempCollection.addItem(temp);
	tempCollection.addItem(value);
	return tempCollection;
}

public function getCustomTextForAutocomplete(comboData:Object, temp:Object, variableName:String, labelFieldId:String, labelFieldName:String, updateObject:Boolean=false, objectLabelFieldId:String=null):String{
	for each(var obj:Object in comboData) {
		if(temp != null) {
			if(updateObject){
				if(obj[labelFieldId] == temp[variableName][objectLabelFieldId]){
					return obj[labelFieldName];
				}
			} else {
				if(obj[labelFieldId] == temp[variableName]){
					return obj[labelFieldName];
				}
			}
		}
	}
	return "";
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

public function formatValuesWithAppendZerosPrecision(precison:Number,viewablePrecision:int,useThousandsSeparator:Boolean,rounding:String,value:Object):String{
	var number:String;
	var numberFormatter:NumberFormatter = new NumberFormatter();
	numberFormatter.precision=precison;
	numberFormatter.rounding=rounding;
	numberFormatter.useThousandsSeparator=useThousandsSeparator;
	if(isNaN(Number(value))){
		number = numberFormatter.format(0);
	} else {
		number = numberFormatter.format(value);
		if(Number(number) == 0){
			number = numberFormatter.format(0);
		}
	}
	if(viewablePrecision>0 && !(viewablePrecision>=precison)){
		if(number.indexOf(".")!=-1){
			if(Number(number.split(".")[1])==0){
				number =  number.split(".")[0]+".";
				for(var i:int=0;i<viewablePrecision;i++){
					number = number+"0";
				}
			} else {
				number = formatDecimalsWithPrecision(number,viewablePrecision);
			}
		}
	}
	return number;
}

private function formatDecimalsWithPrecision(formattedString:String,viewablePrecision:int):String{
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
		if(formattedNumber.split(".")[1].length<viewablePrecision){
			for(var j:int=0;j<(viewablePrecision-formattedNumber.split(".")[1].length);j++){
				formattedNumber = formattedNumber+"0";
			}
		}
	}
	else {
		formattedNumber = formattedString;
	}
	return formattedNumber;
}