package com.efi.printsmith.security
{
	import com.adobe.cairngorm.business.ServiceLocator;
	import com.efi.printsmith.data.PSMenuItem;
	import com.efi.printsmith.data.SecurityCommands;
	import com.efi.printsmith.data.SecuritySetup;
	import com.efi.printsmith.data.Users;
	
	import flash.utils.Dictionary;
	
	import mx.collections.ArrayCollection;
	import mx.core.Application;
	import mx.rpc.Responder;
	import mx.rpc.events.FaultEvent;
	import mx.rpc.events.ResultEvent;
	import mx.rpc.remoting.mxml.RemoteObject;
	import mx.utils.StringUtil;
   
   	public class PSSecurity
	{
		private var setupComplete:Boolean = false;
		private var securityDictionary:Dictionary;
		
		private var menuItems:ArrayCollection = new ArrayCollection();
		private var lastLevel2Child:PSMenuItem;
		
		private var ro:RemoteObject;
		
		public function PSSecurity(user:Users)
		{
			setupComplete = false;

			ro = new RemoteObject("dataService");
			ro.addEventListener(FaultEvent.FAULT,handleFault,false,0,true);
			ro.addEventListener(ResultEvent.RESULT,handleMenuRes,false,0,true);
			ro.getAllQuery("SecurityCommands"," where menuItemFlag = true ");


			var service:Object = ServiceLocator.getInstance().getRemoteObject("dataService");
			if (user.accessGroup != null) {
				var call:Object = service.getAllQuery("SecuritySetup", "  where accessGroup.id = " + user.accessGroup.id);
				call.addResponder(new Responder(handleResult,handleFault));
			}
			
		}
		
		public function handleMenuRes(evt:ResultEvent):void	{
			var scList:ArrayCollection = evt.result as ArrayCollection;
			
		 	if (scList != null)	{
		 		for (var i:int=0; i<scList.length; i++)	{
		 			var sc:SecurityCommands = scList.getItemAt(i) as SecurityCommands;
		 			addToMenuItems(sc);
		 		}
		 	}
		 	
		}
		public function handleResult(evt:ResultEvent):void {
			var securitySetupList:ArrayCollection = evt.result as ArrayCollection;
			var i:int;
			securityDictionary = new Dictionary();
			var perms:ArrayCollection = new ArrayCollection();
			
			for (i = 0; i<securitySetupList.length; i++) {
				var securitySetup:SecuritySetup = securitySetupList.getItemAt(i) as SecuritySetup;
					
				securityDictionary[securitySetup.commandId] = true;
				if (securitySetup.securityCmd.menuItemFlag == true)
					updateMenuItems(securitySetup.securityCmd);
				if (securitySetup.securityCmd.commandId != null)
					perms.addItem(securitySetup.securityCmd.commandId);
				
			}
			
			Application.application.menuItems= menuItems;
			
			setupComplete = true;
			
			Application.application.permissions = perms;
			Application.application.openQAP();
		
		}
		
		private function updateMenuItems(ss:SecurityCommands):void	{
			for (var i:int=0; i < menuItems.length; i++)	{
				var p:PSMenuItem = menuItems.getItemAt(i) as PSMenuItem;
				if (p.label == ss.menu)	{
					var level1Children:ArrayCollection = p.children;
					if (level1Children != null)	{
						for (var j:int=0; j < level1Children.length; j++)	{
							var p1:PSMenuItem = level1Children.getItemAt(j) as PSMenuItem;
							if (ss.commandName.indexOf('\t') == -1)	{
								if (p1.ss.commandId == ss.commandId)	{
									p1.enabled = true;
									return;
								}
								else	{
									var level2Children:ArrayCollection = p1.children;
									if (level2Children != null)	{
										for (var k:int=0; k < level2Children.length; k++)	{
											var p2:PSMenuItem = level2Children.getItemAt(k) as PSMenuItem;
											if (p2.ss.commandId == StringUtil.trim(ss.commandId))	{
												p2.enabled = true;
												return;
											}
										}
									}
								}	
							}		
						}		
					}
				}
			} 
		}
		private function findParentInMenuList(ss:SecurityCommands):PSMenuItem	{
			for (var i:int=0; i < menuItems.length; i++)	{
				var p:PSMenuItem = menuItems.getItemAt(i) as PSMenuItem;
				if (p.label == ss.menu)	{
					return p;
				}
			}
			return null;
		}
		private function addToMenuItems(ss:SecurityCommands):void	{
			
			var menuItem:PSMenuItem = findParentInMenuList(ss);
			var child:PSMenuItem = new PSMenuItem(ss.commandName, null);
			child.enabled = false; //ss.enable;
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
//			if (setupComplete && securityDictionary.hasOwnProperty(commandId)) {
//				return securityDictionary[commandId] as Boolean;
//			} else {
//				return false;
//			}
			return true;
		}
		
		
		
	}
}