package com.efi.mdi.event.compare
{
	import flash.events.Event;
	
	import mx.core.UIComponent;
	
	public class MDICompareObjectEvent extends Event
	{
		public function MDICompareObjectEvent(type:String,content:UIComponent,functionName:Function,inputArguments:Array=null) {
            super(type);
            this._content = content;
            this._functionName = functionName;
            this._inputArguments = inputArguments;
        }
        
        public static const MDI_COMPAREOBJECT:String = "mdiCompareObject";

        
        public var _content:UIComponent;
        
        public var _functionName:Function;
        
        public var _inputArguments:Array;

        // Override the inherited clone() method.
        override public function clone():Event {
            return new MDICompareObjectEvent(type, _content, _functionName, _inputArguments);
        }

	}
}