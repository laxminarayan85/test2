package com.efi.printsmith.events
{
	import flash.events.Event;
	import com.efi.printsmith.data.ModelBase;
	
	public class UpdateDataProviderEvent extends Event
	{
		public var provider:String;
		public var value:ModelBase;
		
		public function UpdateDataProviderEvent(provider:String, value:ModelBase)
		{
			super("UpdateDataProviderEvent", true, false);
			this.provider = provider;
			this.value = value;
		}

		override public function clone():Event {
			return new UpdateDataProviderEvent(provider, value);
		}
	}
}