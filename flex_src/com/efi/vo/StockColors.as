package com.efi.vo
{
	import mx.collections.ArrayCollection; 
	import com.efi.vo.*;
[Bindable]

[RemoteClass(alias="com.efi.printsmith.data.StockColors")]

public class StockColors

{

public function StockColors()

{

}
public var id:Number;

public var created:Date;

public var modified:Date;

public var name:String = "";
public var genericColor:GenericColors = new GenericColors();

}
}