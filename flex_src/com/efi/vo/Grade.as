package com.efi.vo
{
	import mx.controls.List;
	import com.efi.vo.*;
[Bindable]

[RemoteClass(alias="com.efi.printsmith.data.Grade")]

public class Grade

{

public function Grade()

{

}
public var id:Number;

public var created:Date;

public var modified:Date;

public var name:String = "";
public var gradeID:int = 0;

}
}