package com.efi.vo
{
	import mx.controls.List;
	import com.efi.vo.*;
[Bindable]

[RemoteClass(alias="com.efi.printsmith.data.Campaigns")]

public class Campaigns

{

public function Campaigns()

{

}
public var id:Number;

public var created:Date;

public var modified:Date;

public var name:String = "";
public var campaignID:int = 0;
public var campaignGradeID:int = 0;

}
}