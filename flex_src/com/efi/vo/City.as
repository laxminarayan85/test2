package com.efi.vo
{
	import mx.collections.ArrayCollection; 
	import com.efi.vo.*;
[Bindable]

[RemoteClass(alias="com.efi.printsmith.data.City")]

public class City

{

public function City()

{

}
public var id:Number;

public var created:Date;

public var modified:Date;

public var name:String = "";

}
}