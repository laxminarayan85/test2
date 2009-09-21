package com.efi.vo
{
	import mx.controls.List;
	import com.efi.vo.*;
[Bindable]

[RemoteClass(alias="com.efi.printsmith.data.PressDefinitions")]

public class PressDefinitions

{

public function PressDefinitions()

{

}
public var id:Number;

public var created:Date;

public var modified:Date;

public var pressDefID:Number;

public var pressDefName:String;

public var machineName:String;

public var outputDescrip:String;

public var productionLocation:String;

public var costCenter:String;

public var oEMDeiveID:Number;

public var machineID:Number;

public var costingPress:Short;

public var sheetFed:Short;

public var rolltoRoll:Short;

public var integratedDevice:Short;

public var maxPaperSize:String;

public var minPaperSize:String;

public var laborRate:Number;

public var laborMarkup:Number;

public var fixedWaste:Number;

public var minLabor:Number;

public var setupMin:Number;

public var setupAddSig:Number;

public var workTurnSetup:Number;

public var setupAddHead:Number;

public var washupFee:Number;

public var addSigAddHead:Number;

public var washupMin:Number;

public var washupPerFountain:Number;

public var gripEdge:Number;

public var perfector:Short;


}
}