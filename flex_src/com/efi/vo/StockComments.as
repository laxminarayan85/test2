package com.efi.vo
{
	import mx.controls.List;
	import com.efi.vo.*;
[Bindable]

[RemoteClass(alias="com.efi.printsmith.StockComments")]

public class StockComments

{

public function StockComments()

{

}
public var id:Number;

public var created:Date;

public var modified:Date;

public var value:UnlimitedNatural;


}
}