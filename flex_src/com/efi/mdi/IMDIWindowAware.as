package com.efi.mdi
{
	import com.efi.printsmith.data.ModelBase;
	
	import mx.collections.ArrayCollection;
	
	public interface IMDIWindowAware
	{
		
		function getOriginalObject():ArrayCollection;
		
		function getUpdatedObject():ArrayCollection;
		
		function getConfirmationText():String;
		
		function onClose():void;
		
		function onSave():void;
		
		function onDontSave():void;
		
		function onCancel():void;
		
	}
}