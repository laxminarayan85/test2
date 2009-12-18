package com.efi.components
{
    import com.efi.vo.ChargeCommand;
    
    import flash.events.Event;
    
    import mx.collections.ArrayCollection;
    import mx.controls.Tree;
    import mx.core.UIComponent;

    [Event(name="dataChanged", type="flash.events.Event")]

    public class DataManagerCharges extends UIComponent    {
        
        // this instance stores a static reference to itself
        private static var dataMangerCharges : DataManagerCharges;
        
        private var model:AppModelLocator = AppModelLocator.getInstance();
        
        public function DataManagerCharges() : void {
            super();
        }

        // singleton: always returns the one existing static instance to itself
        public static function getInstance() : DataManagerCharges {
            if ( dataMangerCharges == null ){
                dataMangerCharges = new DataManagerCharges();
            }
            return dataMangerCharges;
        }
        
        public function handleData(chargeCommands:ArrayCollection):void{
        	if (model.acData == null)
        	{
	            model.acData = new ArrayCollection();
	        }else
	        {
	        	model.acData.removeAll();
	        }
            //you could pass this an xml file from a remote service, and handle it here
			
			for each(var item:ChargeCommand in chargeCommands)
			{
				model.acData.addItem(item);
			} 

            model.acData.filterFunction=model.processACFilter;
        }
        
        public function dataChanged():void{
            var e:Event = new Event("dataChanged");
            this.dispatchEvent(e);
        }
        
    }
}