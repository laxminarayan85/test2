package com.efi.mdi
{
	import com.efi.mdi.util.MDIConstants;
	import com.efi.mdi.view.container.MDIContainer;
	import com.efi.mdi.view.taskbar.MinimizedWindow;
	import com.efi.mdi.view.window.MDIWindow;
	import com.efi.mdi.vo.window.WindowItem;
	
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
		
		//private var _windows:ArrayCollection;
		private var _baseWindowItem:WindowItem;
		
		//MS: how to make singleton???
		public function ContainerManager(contRef:MDIContainer)
		{
			this._mdiContainerRef = contRef;
			this._nextId = 0; 
			this._baseWindowItem = new WindowItem(-1);
		}
				
		public static function getInstance(contRef:MDIContainer):ContainerManager	{
			if (_contMgr == null)	{
				_contMgr = new ContainerManager(contRef);
			}
			return _contMgr;
		}
		
		public function recalculateWindowStyles():void	{
			var wins:ArrayCollection = getAllWindows();
			var foundTopWindow:Boolean = false;  
			
			for (var i:int=wins.length-1; i>=0; i--)	{
				var w:MDIWindow = wins.getItemAt(i) as MDIWindow;
				if (w.visible)	{
					if (!foundTopWindow)	{
						foundTopWindow = true;
						w.setWindowStyle(true);
					}
					else	{
						w.setWindowStyle(false);
					}
				} 
			}
		}
		
		public function getWindowWithChild(child:DisplayObject, compareByRef:Boolean = false):MDIWindow	{
			var a:Array = _mdiContainerRef.appCanvas.getChildren(); 
			for (var i:int=0; i<a.length; i++){
				if (a[i] is MDIWindow)	{
					if (!compareByRef)	{
						if ((a[i] as MDIWindow).content.name == child.name)	{
							return a[i];
						}
					}
					else	{
						if ((a[i] as MDIWindow).content == child)	{
							return a[i];
						}
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
		public function getMinimized(win:MDIWindow):MinimizedWindow	{
			var children:Array = _mdiContainerRef.taskbar.getChildren();
			for (var i:int=0; i<children.length; i++)	{
				var min:MinimizedWindow = children.pop() as MinimizedWindow;
				if (min.windowRef == win)	{
					return min;
				}
			}
			return null;
		}
		public function openNewMDIWindow(title:String, content:UIComponent, x:Number = -1, y:Number = -1, height:Number = -1, width:Number = -1, parentWin:int = -1, closeChildren:Boolean=true):int	{
			
			var windowId:int = _nextId;
			_nextId++;
			
			var mdiWindow:MDIWindow = new MDIWindow(title, content, windowId, parentWin,closeChildren);
			
			mdiWindow.id = "MDIWindow_" + windowId;
			
			if (x == -1)
				mdiWindow.x = MDIConstants.DEFAULT_WINDOW_X;
			else	
				mdiWindow.x = x;
			
			if (y == -1)		
				mdiWindow.y = MDIConstants.DEFAULT_WINDOW_Y;
			else	
				mdiWindow.y = y;
				
//			if (parentWin != -1)	{
//				var parentWindow:MDIWindow = getWindow(parentWin);
//				parentWindow.addChildWindow(windowId);
//				
//			}

			
			if (parentWin == -1)	{
				_baseWindowItem.addChildWindow(new WindowItem(mdiWindow.windowID));	
			}
			else	{
				var winItem:WindowItem = getWindowFromTree(parentWin, _baseWindowItem);
				
				if (winItem == null)
					_baseWindowItem.addChildWindow(new WindowItem(mdiWindow.windowID));
				else
					winItem.addChildWindow(new WindowItem(mdiWindow.windowID,winItem.id));
			}
				
			_mdiContainerRef.addMDIWindow(mdiWindow);
			if (height == -1)	
				mdiWindow.height = _mdiContainerRef.appCanvas.height - MDIConstants.DEFAULT_WINDOW_HEIGHT_FACTOR;
			else if (height > _mdiContainerRef.appCanvas.height)
				mdiWindow.height = 	_mdiContainerRef.appCanvas.height;
			else 
				mdiWindow.height = 	height;
			
			if (width == -1)		
				mdiWindow.width = _mdiContainerRef.appCanvas.width - MDIConstants.DEFAULT_WINDOW_WIDTH_FACTOR;
			else if (width > _mdiContainerRef.appCanvas.width)
				mdiWindow.width = _mdiContainerRef.appCanvas.width;
			else
				mdiWindow.width = width;  
			 
			return windowId;
		}
		
		public function getAllWindows():ArrayCollection	{
			var a:Array = _mdiContainerRef.appCanvas.getChildren();
			var b:ArrayCollection = new ArrayCollection(); 
			for (var i:int=0; i<a.length; i++){
				if (a[i] is MDIWindow)	{
					b.addItem(a[i] as MDIWindow);
				} 		
			}
			return b;
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
		
		public function getChildrenOfWindow(id:int):ArrayCollection	{
			var win:WindowItem = getWindowFromTree(id, _baseWindowItem);
			var ac:ArrayCollection = new ArrayCollection();
			
			if (win.children != null)	{
				for (var i:int = 0; i < win.children.length; i++)	{
					var w:WindowItem = win.children.getItemAt(i) as WindowItem;
					ac.addItem(getWindow(w.id));
				}
				return ac;
			}
			return null;
		}
		
		public function removeChildFromTree(win:MDIWindow):void	{
			var winItem:WindowItem = getWindowFromTree(win.windowID, _baseWindowItem);
			if (winItem.parentId == -1)	{
				for (var i:int=0; i<_baseWindowItem.children.length; i++)	{
					if ((_baseWindowItem.children.getItemAt(i) as WindowItem).id == win.windowID)	
						_baseWindowItem.children.removeItemAt(i);
						return;
				}
			}
			
			var parentWinItem:WindowItem = getWindowFromTree(winItem.parentId, _baseWindowItem);
			
			if ((parentWinItem != null) && (parentWinItem.children != null))	{
				if (parentWinItem.children.length == 1)
					parentWinItem.children = null;
				else	{
					for (var i:int=0; i<parentWinItem.children.length; i++)	{
						var wi:WindowItem = parentWinItem.children.getItemAt(i) as WindowItem;
						if (wi.id == win.windowID)	{
							parentWinItem.children.removeItemAt(i);
							break;
						}
					}
				}
			}
		}

		
		private function getWindowFromTree(id:int, rootNode:WindowItem):WindowItem	{
			if (rootNode.id == id)
				return rootNode;
			
			if (rootNode.children != null)	{
				for (var i:int = 0; i < rootNode.children.length; i++)	{
					var win:WindowItem = getWindowFromTree(id, (rootNode.children.getItemAt(i) as WindowItem)) ;
					if (win == null)
						continue;
					else
						return win;
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
//					if (win.children != null) {
//						var windowItemObj:WindowItem = getWindowRec(win,id);
//						if(windowItemObj==null)
//							continue;
//						return windowItemObj;
//					}
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
//						getWindowRec(w,id);
//					else
//						continue;
//				}
//			}
//			return null;
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