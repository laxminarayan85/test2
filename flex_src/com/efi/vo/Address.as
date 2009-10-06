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
public var id:Number;

public var created:Date;

public var modified:Date;

public var name:String = "";
public var street1:String = "";
public var street2:String = "";
public var city:City = new City();
public var state:State = new State();
public var zip:Zip = new Zip();
public var country:Country = new Country();
public var zone:String = "";
public var firstName:String = "";
public var lastName:String = "";
public var jobTitle:String = "";
public var salutation:String = "";
public var comLinks:List;
public var prefix:String = "";
public var suffix:String = "";
public var takenBy:String = "";

}
}