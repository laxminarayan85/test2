package com.efi.events
{
	import flash.events.Event;
	import com.efi.vo.ModelBase;
	
	public class UpdateDataProviderEvent extends Event
	{
		public var provider:String;
		public var value:ModelBase;
		
		public function UpdateDataProviderEvent(provider:String, value:ModelBase)
		{
			super("UpdateDataProviderEvent");
			this.provider = provider;
			this.value = value;
		}

		override public function clone():Event {
			return new UpdateDataProviderEvent(provider, value);
		}
	}
}