package com.efi.vo
{
	import mx.controls.List;
	import com.efi.vo.*;
[Bindable]

[RemoteClass(alias="com.efi.printsmith.Stock")]

public class Stock

{

public function Stock()

{

}
public var id:Number;

public var created:Date;

public var modified:Date;

public var stockId:Number;

public var group:StockGroup;

//public var class:String;

public var ismetric:Boolean;

public var name:String;

public var finish:StockFinish;

public var weight:Number;

public var color:StockColor;

public var grade:StockGrade;

public var coated:Number;

public var genericColor:StockColor;

public var vendor:Vendor;

public var stockNumber:String;

public var type:StockType;

public var basicsize:String;

public var parentsize:String;

public var thickness:Number;

public var mweight:Number;

public var sheetspercarton:Number;

public var minorder:Number;

public var forestmgmt:String;

public var recyclepct:Number;

public var certification:StockCertification;

public var qtyAdjustments:StockQty;

public var comments:StockComments;

public var pricing:StockPricing;

public var additional:StockAdditionalCharges;

public var inventory:Number;


}
}