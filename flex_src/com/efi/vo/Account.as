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

public var AccountId:Long;

public var Status:String;

public var MasterAcct:Long;

public var ResaleNumber:String;

public var Title:String;

public var CustomerPO:String;

public var ShipToAddress:Address;

public var BillToAddress:Address;

public var Contact:Contact;

public var BillToContact:Contact;

public var SalesRank:Long;

public var UserAcctId:String;

public var ExternalAcctId:String;

public var DollarDiscount:Boolean;

public var FileOriginals:Boolean;

public var WebAccessEnabled:Boolean;

public var Prospect:Boolean;

public var AutoPayEnabled:Boolean;

public var OptOutMarketing:Boolean;

public var AcctIsIndividual:Boolean;

public var TaxExempt:Boolean;

public var PayCommissions:String;

public var PoRequired:Boolean;

public var ApplyFinanceCharges:Boolean;

public var GenerateStatements:Boolean;

public var BusinessType:String;

public var SalesRep:SalesRep;

public var ShippingMode:String;


}
}