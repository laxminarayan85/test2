package com.efi.vo
{
	import mx.controls.List;
	import com.efi.vo.*;
[Bindable]

[RemoteClass(alias="com.efi.printsmith.StockInventory")]

public class StockInventory

{

public function StockInventory()

{

}
public var id:Number;

public var created:Date;

public var modified:Date;

public var standardItem:Boolean;

public var onHand:Number;

public var committed:Number;

public var available:Number;

public var onOrder:Number;

public var targetLevel:Number;

public var reOrderPoint:Number;

public var minOrderQty:Number;

public var evenIncrements:Boolean;

public var expires:Number;

public var binLocation:Number;


}
}