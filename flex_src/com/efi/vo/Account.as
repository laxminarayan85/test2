package com.efi.vo
{
	import mx.controls.List;
	import com.efi.vo.*;
[Bindable]

[RemoteClass(alias="com.efi.printsmith.data.Account")]

public class Account

{

public function Account()

{

}
public var id:Number;

public var created:Date;

public var modified:Date;

public var accountId:Number = 0;
public var status:String = "";
public var masterAcct:Number = 0;
public var resaleNumber:String = "";
public var title:String = "";
public var customerPO:String = "";
public var shipToAddress:Address;
public var billToAddress:Address;
public var contact:Contact;
public var billToContact:Contact;
public var salesRank:Number = 0;
public var userAcctId:String = "";
public var externalAcctId:String = "";
public var dollarDiscount:Boolean = true;
public var fileOriginals:Boolean = true;
public var webAccessEnabled:Boolean = true;
public var prospect:Boolean = true;
public var autoPayEnabled:Boolean = true;
public var optOutMarketing:Boolean = true;
public var acctIsIndividual:Boolean = true;
public var taxExempt:Boolean = true;
public var payCommissions:String = "";
public var poRequired:Boolean = true;
public var applyFinanceCharges:Boolean = true;
public var generateStatements:Boolean = true;
public var businessType:String = "";
public var salesRep:SalesRep;
public var shippingMode:String = "";

}
}