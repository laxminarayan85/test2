package com.efi.vo
{
	import mx.collections.ArrayCollection; 
	import com.efi.vo.*;
[Bindable]

[RemoteClass(alias="com.efi.printsmith.data.ChargeCommand")]

public class ChargeCommand

{

public function ChargeCommand()

{

}
public var id:Number;

public var created:Date;

public var modified:Date;

public var children:ArrayCollection;
public var name:String = "";

}
}