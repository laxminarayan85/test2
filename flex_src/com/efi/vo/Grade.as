package com.efi.vo
{
	import mx.collections.ArrayCollection; 
	import com.efi.vo.*;
[Bindable]

[RemoteClass(alias="com.efi.printsmith.data.Grade")]

public class Grade extends ModelBase

{

	public function Grade() {
	
	}
	public var name:String = "";
	public var gradeID:int = 0;

	}
}