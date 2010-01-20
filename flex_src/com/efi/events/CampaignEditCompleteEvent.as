package com.efi.events
{

	import com.efi.vo.Campaigns;
	
	import flash.events.Event;
	
	public class CampaignEditCompleteEvent extends Event
	{
		public static const SAVE:String = "CampaignEditSave";
		public static const CANCEL:String = "CampaignEditCancel";
		
		public var campaign:Campaigns;
		
		public function CampaignEditCompleteEvent(type:String, Campaign:Campaigns)
		{
			super(type, true);
			this.campaign = campaign;
		}

		override public function clone():Event {
			return new CampaignEditCompleteEvent(type, campaign);
		}
	}
}