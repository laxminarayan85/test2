package com.efi.vo
{
	import mx.controls.List;
	import com.efi.vo.*;
[Bindable]

[RemoteClass(alias="com.efi.printsmith.data.CreditCard")]

public class CreditCard

{

public function CreditCard()

{

}
public var id:Number;

public var created:Date;

public var modified:Date;

public var cardHolderName:String = "";
public var cardNumber:String = "";
public var expiresDate:Date = new Date();
public var address:Address;
public var creditCardID:int = 0;
public var type:String = "";

}
}