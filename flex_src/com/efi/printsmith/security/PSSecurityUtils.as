package com.efi.printsmith.security
{
	import com.efi.mdi.view.window.MDIWindow;
	
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
		

		public function hasPermission(commandId:String):Boolean	{
			if (Snowmass.getInstance().permissions.contains(commandId))	{
				return true;	
			}			
			return false;
		}

		public function checkSecurityAccess(secureComponent:ISecureComponent = null):Boolean	{
			var retVal:Boolean = false;
			
			if (Snowmass.getInstance().permissions.contains(secureComponent.getSecurityCommand())) 
			{
				retVal = true;
			}
			else	{
				Alert.show(ResourceManager.getInstance().getString(Snowmass.RESOURCE_BUNDLE, 'genericPrefCmd.Insufficientaccessle'));
				if (
					((secureComponent as UIComponent).parent != null) 
					&& 
					((secureComponent as UIComponent).parent is MDIWindow)	
					)	{	
					Snowmass.getInstance().containerManager.getWindowWithChild(secureComponent as UIComponent, true).closeWindow();
					}
				retVal = false;
			}
			
//			if (secureComponent.getCallbackFunction() != null)
//				(secureComponent as UIComponent).callLater (secureComponent.getCallbackFunction(), secureComponent.getInputArgs());
			
							
			return retVal;
				
					
		}
		
	}
}