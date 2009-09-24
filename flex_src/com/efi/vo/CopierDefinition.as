package com.efi.vo
{
	import mx.controls.List;
	import com.efi.vo.*;
[Bindable]

[RemoteClass(alias="com.efi.printsmith.data.CopierDefinition")]

public class CopierDefinition

{

public function CopierDefinition()

{

}
public var id:Number;

public var created:Date;

public var modified:Date;

public var copyDefID:Number;

public var copyDefName:String;

public var machineName:String;

public var outputDescrip:String;

public var productionLocation:String;

public var costCenter:String;

public var oEMDeviceID:String;

public var costingCopy:Boolean;

public var blackwhite:Boolean;

public var color:Boolean;

public var integratedDevice:Boolean;

public var maxSize:String;

public var minSize:String;

public var monthlyLabor:Number;

public var clickCost:Number;

public var laborCopy:Number;

public var largeFormat:Boolean;

public var maxWidth:String;

public var minWidth:String;

public var daysOpen:Number;

public var monthlyPayment:Number;

public var percentUsage:String;

public var hourCostRate:Number;

public var tonerCopy:Number;

public var developerCopy:Number;

public var copyMarkup:Number;

public var hoursOpen:Number;

public var monthlyMaintenance:Number;

public var machineCostPerCopy:Number;

public var method:String;

public var salesCat:String;

public var copyID:Number;

public var monthlyBurdenRate:Number;

public var copyMinutes:Number;


}
}