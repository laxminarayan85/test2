// ActionScript file

public function parseCurrencyFloat(str:String):Number {
	var regEx:RegExp = /[,$]/g;
	return parseFloat(str.replace(regEx,""));
}
