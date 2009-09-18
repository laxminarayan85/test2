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

public var accountId:Number;

public var status:String;

public var masterAcct:Number;

public var resaleNumber:String;

public var title:String;

public var customerPO:String;

public var shipToAddress:Address;

public var billToAddress:Address;

public var contact:Contact;

public var billToContact:Contact;

public var salesRank:Number;

public var userAcctId:String;

public var externalAcctId:String;

public var dollarDiscount:Boolean;

public var fileOriginals:Boolean;

public var webAccessEnabled:Boolean;

public var prospect:Boolean;

public var autoPayEnabled:Boolean;

public var optOutMarketing:Boolean;

public var acctIsIndividual:Boolean;

public var taxExempt:Boolean;

public var payCommissions:String;

public var poRequired:Boolean;

public var applyFinanceCharges:Boolean;

public var generateStatements:Boolean;

public var businessType:String;

public var salesRep:SalesRep;

public var shippingMode:String;


}
}