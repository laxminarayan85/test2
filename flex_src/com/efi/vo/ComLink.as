package com.efi.vo
{
	import mx.collections.ArrayCollection; 
	import com.efi.vo.*;
[Bindable]

[RemoteClass(alias="com.efi.printsmith.data.ComLink")]

public class ComLink

{

public function ComLink()

{

}
public var id:Number;

public var created:Date;

public var modified:Date;

public var type:String = "";
public var value:String = "";

}
}