package com.efi.vo
{
	import mx.controls.List;
	import com.efi.vo.*;
[Bindable]

[RemoteClass(alias="com.efi.printsmith.data.ChargeCategory")]

public class ChargeCategory

{

public function ChargeCategory()

{

}
public var id:Number;

public var created:Date;

public var modified:Date;

public var children:List;
public var name:String = "";
public var parent:ChargeCommand = new ChargeCommand();

}
}