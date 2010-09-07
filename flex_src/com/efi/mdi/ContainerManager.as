package com.efi.mdi
{
	import com.efi.mdi.view.container.MDIContainer;
	import com.efi.mdi.view.window.MDIWindow;
	
	import flash.display.DisplayObject;
	import flash.geom.Rectangle;
	
	import mx.collections.ArrayCollection;
	import mx.core.Container;
	import mx.core.UIComponent;
	
	public class ContainerManager
	{
		private static var _contMgr:ContainerManager;
		
		private var _mdiContainerRef:MDIContainer;
		private var _nextId:int;
		
		private var _windows:ArrayCollection;
		
		//MS: how to make singleton???
		public function ContainerManager(contRef:MDIContainer)
		{
			this._mdiContainerRef = contRef;
			this._nextId = 0; 	
		}
				
		public static function getInstance(contRef:MDIContainer):ContainerManager	{
			if (_contMgr == null)	{
				_contMgr = new ContainerManager(contRef);
			}
			return _contMgr;
		}
		
		public function getWindowsWithChild(child:DisplayObject):MDIWindow	{
			var a:Array = _mdiContainerRef.appCanvas.getChildren(); 
			for (var i:int=0; i<a.length; i++){
				if (a[i] is MDIWindow)	{
					if ((a[i] as MDIWindow).content.name == child.name)	{
						return a[i];
					}
				}	
			}			
			return null;	
		}
		
		public function cleanupWindows():void	{
			_mdiContainerRef.removeAllChildren();
		}
		
		//MS: throw exception if _contMgr is null		
		public static function getExistingInstance():ContainerManager	{
			return _contMgr;
		}
		
		private function getActiveWindow():MDIWindow	{
			return _mdiContainerRef.appCanvas.getChildAt(getCanvasChildrenCount()-1) as MDIWindow;
		}
		public function getActiveWindowContent():Container	{
			return getActiveWindow().content as Container;
		}
		public function openNewMDIWindow(title:String, content:UIComponent, parentWin:int = -1):int	{
			
			var windowId:int = _nextId;
			_nextId++;
			
			var mdiWindow:MDIWindow = new MDIWindow(title, content, windowId, parentWin);
			
			mdiWindow.id = "MDIWindow_" + windowId;
			mdiWindow.x = 100;
			mdiWindow.y = 100;
			mdiWindow.width = 1000;
			mdiWindow.height = 500; 
			
			if (parentWin != -1)	{
				var parentWindow:MDIWindow = getWindow(parentWin);
				parentWindow.addChildWindow(windowId);
				
			}
			
//			if (parentWin == -1)	{
//				if (_windows == null)
//					_windows = new ArrayCollection();
//				_windows.addItem(new WindowItem(_nextId));	
//			}
//			else	{
//				var winItem:WindowItem = getWindowFromList(parentWin);
//				winItem.addChild(new WindowItem(_nextId));
//			}
				
			_mdiContainerRef.addMDIWindow(mdiWindow);
			return windowId;
		}
		
		public function getWindow(id:int):MDIWindow	{
			var a:Array = _mdiContainerRef.appCanvas.getChildren(); 
			for (var i:int=0; i<a.length; i++){
				if (a[i]["id"] == "MDIWindow_" + id)	{
					return a[i] as MDIWindow;
				} 		
			}
			return null;
		}
		
//		private function getWindowFromList(id:int):WindowItem	{
//			for (var i:int=0; i<_windows.length; i++){
//				var win:WindowItem = _windows.getItemAt(i) as WindowItem;
//				if (win.id == id)
//					return win;
//				else	{
//					if (win.children != null)
//						getWindowRec(win);
//					else
//						continue;
//				}
//			}	
//			return null;
//		}
//		
//		private function getWindowRec(win:WindowItem, id:int):WindowItem	{
//			for (var i:int=0; i<win.children.length; i++){
//				var w:WindowItem = win.children.getItemAt(i) as WindowItem;
//				
//				if (w.id == id)
//					return w;
//				else	{
//					if (w.children != null)
//						getWindowRec(w);
//					else
//						continue;
//				}
//			}
//		}
		// utility methods
		public function getCanvasRectangle():Rectangle	{
			return new Rectangle(0,0,_mdiContainerRef.appCanvas.width,_mdiContainerRef.appCanvas.height) ;	
		}	
		
		public function getContainer():MDIContainer	{
			return _mdiContainerRef;
		}
		public function getCanvasChildrenCount():int{
			return this._mdiContainerRef.appCanvas.numChildren;
		}
		
		
	}
}