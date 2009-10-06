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

public var shipToAddress:Address = new Address();
public var title:String = "";
public var address:Address = new Address();
public var userAcctId:Number = 0;
public var webAcctNameIncomplete:Boolean = true;
public var webCatalogChange:Boolean = true;
public var webStateChange:Boolean = true;
public var transmitted:Boolean = true;
public var useContactAddress:Boolean = true;
public var isIndividual:Boolean = true;
public var defaultSalesRep:SalesRep = new SalesRep();
public var mailerCampaigns:Boolean = true;
public var creditCard:CreditCard = new CreditCard();
public var marketing:Marketing = new Marketing();

}
}