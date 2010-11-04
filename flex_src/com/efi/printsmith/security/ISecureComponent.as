package com.efi.printsmith.security
{
	public interface ISecureComponent
	{
		 function getSecurityCommand():String;
	
		 function checkSecurityAccess():Boolean;
		
		 function isSecurityCleared():Boolean;
		
		 function getCallbackFunction():Function;
		 function getInputArgs():Array;
		
	}
}