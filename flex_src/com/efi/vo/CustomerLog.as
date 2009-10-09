package com.efi.vo
{
	import mx.collections.ArrayCollection; 
	import com.efi.vo.*;
[Bindable]

[RemoteClass(alias="com.efi.printsmith.data.CustomerLog")]

public class CustomerLog

{

public function CustomerLog()

{

}
public var id:Number;

public var created:Date;

public var modified:Date;

public var logEntry:String = "";

}
}