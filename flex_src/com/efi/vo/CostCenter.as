package com.efi.vo
{
	import mx.controls.List;
	import com.efi.vo.*;
[Bindable]

[RemoteClass(alias="com.efi.printsmith.data.CostCenter")]

public class CostCenter

{

public function CostCenter()

{

}
public var id:Number;

public var created:Date;

public var modified:Date;

public var name:String = "";

}
}