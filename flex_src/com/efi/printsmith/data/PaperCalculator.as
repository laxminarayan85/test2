package com.efi.printsmith.data
{
	import mx.collections.ArrayCollection; 
	import com.efi.printsmith.data.*;
	
	[RemoteClass(alias="com.efi.printsmith.data.PaperCalculator")]
	[Managed]
	
	public dynamic class PaperCalculator extends ModelBase
	{

		public function PaperCalculator() {
			remoteObjectName = "com.efi.printsmith.data.PaperCalculator";
		}
		public var isDeleted:Boolean=false;
				
		public var gripEdgeGap:Number = 0;
		public var name:String = "";
		public var across:int = 0;
		public var whichStartSize:int = 0;
		public var useFolioEdge:Boolean = false;
		public var folioEdge:Number = 0;
		public var useColorBar:Boolean = false;
		public var colorBar:Number = 0;
		public var useWhiteSpace:Boolean = false;
		public var whiteSpaceLeft:Number = 0;
		public var whiteSpaceTop:Number = 0;
		public var whiteSpaceRight:Number = 0;
		public var whiteSpaceBottom:Number = 0;
		public var useGutter:Boolean = false;
		public var gutter:Number = 0;
		public var gutterHorizontal:Number = 0;
		public var useBleed:Boolean = false;
		public var bleedLeft:Number = 0;
		public var bleedTop:Number = 0;
		public var bleedRight:Number = 0;
		public var bleedBottom:Number = 0;
		public var backTrimParent:Boolean = false;
		public var workandTurn:Boolean = false;
		public var runToFinishGrain:String = "";
		public var printParentToFinishSection:Boolean = false;
		public var printParentToRunSection:Boolean = false;
		public var attachToJobTicket:Boolean = false;
		public var printRunToFinishSection:Boolean = false;
		public var useGripEdgeGap:Boolean = false;
		public var gripLocation:String = "";
		public var cutstoFinish:int = 0;
		public var sheetsOut:int = 0;
		public var folioLocation:String = "";
		public var cutstoRun:int = 0;
		public var disableFSC:Boolean = false;
		public var down:int = 0;
		public var dAcross:int = 0;
		public var dDown:int = 0;
		public var dutchBottom:int = 0;
		public var parentSqrArea:Number = 0;
		public var usedSqrArea:Number = 0;
		public var rMargin:Number = 0;
		public var bMargin:Number = 0;
		public var tMargin:Number = 0;
		public var lMargin:Number = 0;
		public var backTrimRun:Boolean = false;
		public var swap:Boolean = false;
		public var runout:int = 0;
		public var runAndTumble:Boolean = false;
		public var finishout:int = 0;
	
	}
}