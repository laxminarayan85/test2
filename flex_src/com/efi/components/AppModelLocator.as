package com.efi.components{
    import mx.collections.ArrayCollection;
    import com.efi.vo.Charge;
    import com.efi.vo.ChargeCategory;
    import com.efi.vo.ChargeCommand;
    import flash.utils.describeType;
    
    [Bindable]
    public class AppModelLocator{
        // this instance stores a static reference to itself
        private static var model : AppModelLocator;
        
        public var searchString:String="";
        public var acData:ArrayCollection;
        
        // singleton: constructor only allows one model locator
        public function AppLocator() : void {
            if ( AppModelLocator.model != null ){
                throw new Error( "Only one ModelLocator instance should be instantiated" );
            }
        }

        // singleton: always returns the one existing static instance to itself
        public static function getInstance() : AppModelLocator {
            if ( model == null ){
                model = new AppModelLocator();
            }
            return model;
        }
        
        public function processACFilter(item:Object):Boolean{
            var result:Boolean = false;
            var classInfo:XML = describeType(item)

            var tempName:String = item.name;
            var tempType:String = classInfo.@name.toString();
            
            if(
                !tempName.length || 
                tempName.toUpperCase().indexOf(model.searchString.toUpperCase()) >=0 
                ){
                    
                    result = true;
                    return result;
            }
            //if true, then this is a folder or a branch of a tree
            if(tempType == 'com.efi.vo::ChargeCommand'){
                result = filterACChildren(item);
                return result;
            }
            
            return result;
        }
        private function filterACChildren(item:Object):Boolean{
            var result:Boolean = false;
            var tempItem:ChargeCommand = item as ChargeCommand;
            
            for each(var f:ChargeCategory in tempItem.children){
                if(
                    !f.name.length || 
                    f.name.toUpperCase().indexOf(model.searchString.toUpperCase()) >= 0 
                    
                    ){

                    result = true;
                    break;
                }
            }
                
            return result;
        }
        
    }
}