package com.efi.vo
{
	import mx.controls.List;
	import com.efi.vo.*;
[Bindable]

[RemoteClass(alias="com.efi.printsmith.StockBlankSheets")]

public class StockBlankSheets

{

public function StockBlankSheets()

{

}
public var id:Number;

public var created:Date;

public var modified:Date;

public var quantity:Number;

public var price:Number;


}
}