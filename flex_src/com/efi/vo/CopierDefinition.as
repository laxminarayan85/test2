package com.efi.vo
{
	import mx.collections.ArrayCollection; 
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

public var copyDefID:Number = 0;
public var copyDefName:String = "";
public var machineName:String = "";
public var outputDescrip:String = "";
public var productionLocation:String = "";
public var costCenter:String = "";
public var oEMDeviceID:String = "";
public var costingCopy:Boolean = true;
public var blackwhite:Boolean = true;
public var color:Boolean = true;
public var integratedDevice:Boolean = true;
public var maxSize:String = "";
public var minSize:String = "";
public var monthlyLabor:Number = 0;
public var clickCost:Number = 0;
public var laborCopy:Number = 0;
public var largeFormat:Boolean = true;
public var maxWidth:String = "";
public var minWidth:String = "";
public var daysOpen:int = 0;
public var monthlyPayment:Number = 0;
public var percentUsage:String = "";
public var hourCostRate:int = 0;
public var tonerCopy:int = 0;
public var developerCopy:int = 0;
public var copyMarkup:int = 0;
public var hoursOpen:int = 0;
public var monthlyMaintenance:int = 0;
public var machineCostPerCopy:int = 0;
public var method:String = "";
public var salesCat:String = "";
public var copyID:int = 0;
public var monthlyBurdenRate:int = 0;
public var copyMinutes:int = 0;
public var defaultblackwhite:Boolean = true;
public var defaultcolor:Boolean = true;
public var defaultlargeformat:Boolean = true;

}
}