package com.efi.vo
{
	import mx.collections.ArrayCollection; 
	import com.efi.vo.*;
[Bindable]

[RemoteClass(alias="com.efi.printsmith.data.Employee")]

public class Employee

{

public function Employee()

{

}
public var id:Number;

public var created:Date;

public var modified:Date;

public var firstName:String = "";
public var lastName:String = "";
public var address:Address = new Address();
public var comLinks:ArrayCollection;
public var sSN:String = "";
public var exportCode:int = 0;
public var clockIn:Boolean = true;
public var clockOut:Boolean = true;
public var clockBreak:Boolean = true;

}
}