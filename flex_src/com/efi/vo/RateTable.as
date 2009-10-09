package com.efi.vo
{
	import mx.collections.ArrayCollection; 
	import com.efi.vo.*;
[Bindable]

[RemoteClass(alias="com.efi.printsmith.data.RateTable")]

public class RateTable

{

public function RateTable()

{

}
public var id:Number;

public var created:Date;

public var modified:Date;

public var name:String = "";

}
}