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

public var title:String;

public var address:Address;

public var contact:Contact;

public var userAcctId:String;

public var webAcctNameIncomplete:Boolean;

public var webCatalogChange:Boolean;

public var webStateChange:Boolean;

public var transmitted:Boolean;

public var doNotMail:Boolean;

public var useContactAddress:Boolean;

public var isIndividual:Boolean;

public var defaultSalesRep:SalesRep;

public var mailerCampaigns:Boolean;


}
}