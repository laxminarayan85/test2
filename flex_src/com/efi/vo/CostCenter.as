package com.efi.vo
{
	import mx.collections.ArrayCollection; 
	import com.efi.vo.*;
	
	[Bindable]
	[RemoteClass(alias="com.efi.printsmith.data.CostCenter")]

	public class CostCenter extends ModelBase
	{

		public function CostCenter() {
		
		}
		public var name:String = "";
		public var code:String = "";
		public var deviceId:String = "";
		public var minMinutesPerJob:int = 0;
		public var department:String = "";
		public var imageFile:String = "";
		public var processStage:int = 0;
		public var processStageType:String = "";
		public var delayMinBefore:int = 0;
		public var delayMinAfter:int = 0;
		public var delayMinBeforeSeqTag:int = 0;
		public var delayMinAfterSeqTag:int = 0;
		public var locationXRef:String = "";
		public var markInvReadyPickup:Boolean = true;
		public var treatAsNonProd:Boolean = true;
		public var completionCategory:String = "";
	
	}
}