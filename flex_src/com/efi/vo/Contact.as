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

public var Title:String;

public var Address:Address;

public var Contact:Contact;

public var UserAcctId:String;

public var WebAcctNameIncomplete:Boolean;

public var WebCatalogChange:Boolean;

public var WebStateChange:Boolean;

public var Transmitted:Boolean;

public var DoNotMail:Boolean;

public var UseContactAddress:Boolean;

public var IsIndividual:Boolean;

public var DefaultSalesRep:SalesRep;

public var MailerCampaigns:Boolean;


}
}