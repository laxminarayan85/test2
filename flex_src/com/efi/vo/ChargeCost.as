package com.efi.vo
{
	import mx.collections.ArrayCollection; 
	import com.efi.vo.*;
[Bindable]

[RemoteClass(alias="com.efi.printsmith.data.ChargeCost")]

public class ChargeCost

{

public function ChargeCost()

{

}
public var id:Number;

public var created:Date;

public var modified:Date;

public var setupCost:Number = 0;
public var unitCost:Number = 0;
public var rateTable:RateTable = new RateTable();
public var fixedMaterials:Number = 0;
public var unitMaterials:Number = 0;
public var laborRate:Number = 0;
public var setupMinutes:Number = 0;
public var piecesPerHour:Number = 0;
public var totalUnitCost:Number = 0;
public var speedTable:SpeedTable = new SpeedTable();
public var costingMethod:String = "";

}
}