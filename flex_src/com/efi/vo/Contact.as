package com.efi.vo
{
	import mx.controls.List;
	import com.efi.vo.*;
[Bindable]

[RemoteClass(alias="com.efi.printsmith.data.Contact")]

public class Contact

{

public function Contact()

{

}
public var id:Number;

public var created:Date;

public var modified:Date;

public var shipToAddress:Address;
public var title:String = "";
public var address:Address;
public var userAcctId:String = "";
public var webAcctNameIncomplete:Boolean = true;
public var webCatalogChange:Boolean = true;
public var webStateChange:Boolean = true;
public var transmitted:Boolean = true;
public var doNotMail:Boolean = true;
public var useContactAddress:Boolean = true;
public var isIndividual:Boolean = true;
public var defaultSalesRep:SalesRep;
public var mailerCampaigns:Boolean = true;
public var creditCard:CreditCard;
public var marketing:Marketing;

}
}