package com.efi.vo
{
	import mx.controls.List;
	import com.efi.vo.*;
[Bindable]

[RemoteClass(alias="com.efi.printsmith.StockQty")]

public class StockQty

{

public function StockQty()

{

}
public var id:Number;

public var created:Date;

public var modified:Date;

public var costUnits:Number;

public var sheetsPerSet:Number;

public var isCostInSets:Number;

public var qtyBreak:StockQtyBreak;

public var priceExpires:Number;


}
}