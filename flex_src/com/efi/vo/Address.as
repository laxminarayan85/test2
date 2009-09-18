package com.efi.vo
{
	import mx.controls.List;
	import com.efi.vo.*;
[Bindable]

[RemoteClass(alias="com.efi.printsmith.data.Address")]

public class Address

{

public function Address()

{

}

public var Name:String;

public var Street1:String;

public var Street2:String;

public var City:String;

public var State:String;

public var Zip:String;

public var Country:String;

public var Zone:String;

public var FirstName:String;

public var LastName:String;

public var JobTitle:String;

public var Salutation:String;

public var ComLinks:ComLink;

public var Prefix:String;

public var Suffix:String;

public var TakenBy:String;


}
}