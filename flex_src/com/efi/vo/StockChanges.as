package com.efi.vo
{
	import mx.collections.ArrayCollection; 
	import com.efi.vo.*;
[Bindable]

[RemoteClass(alias="com.efi.printsmith.data.StockChanges")]

public class StockChanges extends ModelBase

{

	public function StockChanges() {
	
	}
	public var stockChangeID:Number = 0;
	public var user:String = "";
	public var date:Date = new Date();
	public var howChanged:String = "";
	public var quantity:int = 0;
	public var reference:String = "";
	public var stockDefinition:StockDefinition = new StockDefinition();

	}
}