package com.efi.vo
{
	import mx.controls.List;
	import com.efi.vo.*;
[Bindable]

[RemoteClass(alias="com.efi.printsmith.StockQtyBreak")]

public class StockQtyBreak

{

public function StockQtyBreak()

{

}
public var id:Number;

public var created:Date;

public var modified:Date;

public var quantity:Number;

public var cost:Number;

public var cwt:Number;

public var markup:Number;

public var listPerM:Number;


}
}