package com.efi.vo
{
	import mx.collections.ArrayCollection; 
	import com.efi.vo.*;
[Bindable]

[RemoteClass(alias="com.efi.printsmith.data.Period")]

public class Period

{

public function Period()

{

}
public var id:Number;

public var created:Date;

public var modified:Date;

public var customtoDate:Date = new Date();
public var customfromDate:Date = new Date();
public var fromDate:Date = new Date();
public var toDate:Date = new Date();
public var day:String = "";
public var type:String = "";

}
}