package com.efi.vo
{
	import mx.controls.List;
	import com.efi.vo.*;
[Bindable]

[RemoteClass(alias="com.efi.printsmith.data.TimeCard")]

public class TimeCard

{

public function TimeCard()

{

}
public var id:Number;

public var created:Date;

public var modified:Date;

public var period:String = "";
public var startDateTime:Date = new Date();
public var endDateTime:Date = new Date();
public var billable:String = "";
public var onClock:int = 0;
public var breakTime:Date = new Date();

}
}