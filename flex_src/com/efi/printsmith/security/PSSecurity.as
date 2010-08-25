package com.efi.printsmith.security
{
	import com.adobe.cairngorm.business.ServiceLocator;
	import com.efi.printsmith.data.PSMenuItem;
	import com.efi.printsmith.data.SecuritySetup;
	import com.efi.printsmith.data.Users;
	
	import flash.utils.Dictionary;
	
	import mx.collections.ArrayCollection;
	import mx.core.Application;
	import mx.rpc.Responder;
	import mx.rpc.events.FaultEvent;
	import mx.rpc.events.ResultEvent;
   
   	public class PSSecurity
	{
		private var setupComplete:Boolean = false;
		private var securityDictionary:Dictionary;
		
		private var menuItems:ArrayCollection = new ArrayCollection();
		private var lastLevel2Child:PSMenuItem;
		
		public function PSSecurity(user:Users)
		{
			setupComplete = false;
			var service:Object = ServiceLocator.getInstance().getRemoteObject("dataService");
			if (user.accessGroup != null) {
				var call:Object = service.getFromParent("SecuritySetup", "accessgroup",user.accessGroup.id);
				call.addResponder(new Responder(handleResult,handleFault));
			}
		}
		
		public function handleResult(evt:ResultEvent):void {
			var securitySetupList:ArrayCollection = evt.result as ArrayCollection;
			var i:int;
			securityDictionary = new Dictionary();
			
			for (i = 0; i<securitySetupList.length; i++) {
				var securitySetup:SecuritySetup = securitySetupList.getItemAt(i) as SecuritySetup;
					
				securityDictionary[securitySetup.commandId] = securitySetup.enable;
				
				addToMenuItems(securitySetup);
			}
			
			Application.application.menuItems = menuItems;
			setupComplete = true;
		}
		
		private function findParentInMenuList(ss:SecuritySetup):PSMenuItem	{
			for (var i:int=0; i < menuItems.length; i++)	{
				var p:PSMenuItem = menuItems.getItemAt(i) as PSMenuItem;
				if (p.label == ss.menu)	{
					return p;
				}
			}
			return null;
		}
		private function addToMenuItems(ss:SecuritySetup):void	{
			
			var menuItem:PSMenuItem = findParentInMenuList(ss);
			var child:PSMenuItem = new PSMenuItem(ss.commandName, null);
			child.enabled = ss.enable;
			if (ss.commandName.indexOf("rStandardMenuText.1") > -1)	
				child.type = "separator";
			child.ss = ss;
				
			if (menuItem == null)	{
				var ac:ArrayCollection = new ArrayCollection();
				ac.addItem(child);
				menuItem = new PSMenuItem(ss.menu, ac);
				menuItem.enabled = true;
				menuItem.ss = null;
				menuItems.addItem(menuItem);
				if (ss.commandName.indexOf('\t') > -1)
					lastLevel2Child = menuItem;
				else	
					lastLevel2Child = child;
			}
			else	{
				if (ss.commandName.indexOf('\t') > -1)	{
					// level 3 child, add to previous level 2 child
					if (lastLevel2Child != null)	{
						var ac2:ArrayCollection;
						if (lastLevel2Child.children == null)	{
							ac2 = new ArrayCollection();
							lastLevel2Child.children = ac2;
						}
						lastLevel2Child.children.addItem(child);							
					}
					else
						menuItem.children.addItem(child);
				}
				else	{
					menuItem.children.addItem(child);
					lastLevel2Child = child;
				}					
			}
			
			
		}
		
		public function handleFault(evt:FaultEvent):void {
			/* TODO - report error back to user */
		}
		
		public function commandEnabled(commandId:String):Boolean {
			if (setupComplete && securityDictionary.hasOwnProperty(commandId)) {
				return securityDictionary[commandId] as Boolean;
			} else {
				return false;
			}
		}
		
		
		
	}
}