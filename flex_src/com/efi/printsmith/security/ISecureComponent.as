package com.efi.printsmith.security
{
	public interface ISecureComponent
	{
		 function getSecurityCommand():String;
	
		 function checkSecurityAccess():Boolean;
		
		 function get securityCleared():Boolean
		
//		 function getCallbackFunction():Function;
//		 function getInputArgs():Array;
		
	}
}