package com.efi.vo
{
	import mx.collections.ArrayCollection; 
	import com.efi.vo.*;
[Bindable]

[RemoteClass(alias="com.efi.printsmith.data.StockColors")]

public class StockColors extends ModelBase

{

	public function StockColors() {
	
	}
	public var name:String = "";
	public var genericColor:GenericColors = new GenericColors();

	}
}