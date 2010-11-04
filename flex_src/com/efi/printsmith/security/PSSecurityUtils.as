package com.efi.printsmith.security
{
	import mx.controls.Alert;
	import mx.core.UIComponent;
	import mx.resources.ResourceManager;
	
	public class PSSecurityUtils
	{
		private static var _instance:PSSecurityUtils = null;
		
		public static function getInstance():PSSecurityUtils	{
			if (_instance == null)
				_instance = new PSSecurityUtils();
			return _instance;
		}
		
		private function showAccessDenied():void	{
			Alert.show(ResourceManager.getInstance().getString(Snowmass.RESOURCE_BUNDLE, 'genericPrefCmd.Insufficientaccessle'));
		}
		

		public function checkSecurityAccess(secureComponent:ISecureComponent = null):Boolean	{
			var retVal:Boolean = false;
			
			if (Snowmass.getInstance().permissions.contains(secureComponent.getSecurityCommand()))
			{
				retVal = true;
			}
			else	{
				showAccessDenied();
				retVal = false;
			}
			
			if (secureComponent.getCallbackFunction() != null)
				(secureComponent as UIComponent).callLater (secureComponent.getCallbackFunction(), secureComponent.getInputArgs());
				
			return retVal;
				
					
		}
		
	}
}