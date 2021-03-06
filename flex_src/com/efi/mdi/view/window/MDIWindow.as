package com.efi.mdi.view.window
{
	import com.efi.mdi.ContainerManager;
	import com.efi.mdi.event.compare.MDICompareObjectEvent;
	import com.efi.mdi.event.window.WindowCloseEvent;
	import com.efi.mdi.event.window.WindowMaximizeEvent;
	import com.efi.mdi.event.window.WindowMinimizeEvent;
	import com.efi.mdi.event.window.WindowResizeStartEvent;
	import com.efi.mdi.event.window.WindowTitleChangedEvent;
	import com.efi.mdi.view.taskbar.MinimizedWindow;
	
	import flash.display.Shape;
	import flash.events.MouseEvent;
	import flash.geom.Point;
	import flash.geom.Rectangle;
	
	import mx.containers.TitleWindow;
	import mx.controls.Button;
	import mx.core.UIComponent;
	
			
	public class MDIWindow extends TitleWindow
	{
		[Bindable] private var _winTitle:String;
		[Bindable] private var _content:UIComponent;
		
		public static const OPEN:int = 0;
		public static const MINIMIZED:int = 2;
		public static const CLOSED:int = -1;
		
		private var _closeChildren:Boolean = true;
		private var _windowID:int;
		private var _state:int;
				
		private var _btnMinimize:Button;
		private var _btnClose:Button;
		private var _btnMaximize:Button;
		private var shape:Shape;
		
		private var _oldX:int = -1;
		private var _oldY:int = -1;
		private var _oldWidth:int = -1;
		private var _oldHeight:int = -1;
		
		private var _isMaximized:Boolean = false;
//		private var _childWindows:ArrayCollection;
//		private var _parentWindowId:int;
//		
//		private var _childWindowSpawned:Boolean;
		
//		[Bindable]
//        [Embed(source="assets/min.png")]
//        private var minIcon:Class;
//		
//		[Bindable]
//        [Embed(source="assets/max.png")]
//        private var maxIcon:Class;
//        
//        [Bindable]
//        [Embed(source="assets/restore.png")]
//        private var restoreIcon:Class;
//		
//		[Bindable]
//        [Embed(source="assets/close.png")]
//        private var closeIcon:Class;
		
		[Bindable]
        [Embed("/assets/mdi/resize_arrow_orange.png")]
        private var resizeCursor:Class;
		 
		private var _resizeCursorEnabled:Boolean = false;
		
		public function get isMaximized():Boolean	{
			return _isMaximized;
		} 
		public function MDIWindow(winTitle:String, content:UIComponent, id:int, parentWin:int = -1, closeChildren:Boolean=true)
		{
			super();
			this.winTitle = winTitle;
			this.content = content;			
			this.windowID = id;
			this.state = OPEN;
			this._closeChildren = closeChildren;
			//this.parentWindowId = parentWin;
			this.styleName = "mdiWindowStyle";
			
		}
		
		public function set closeChildren(val:Boolean):void	{
			_closeChildren = val;
		}
		
		public function get closeChildren():Boolean	{
			return _closeChildren;
		}
		//MS: should be a private function	
		public function set windowID(val:int):void	{
			_windowID = val;
		}
//		public function set parentWindowId(val:int):void	{
//			_parentWindowId = val;
//		}
		public function set state(val:int):void	{
			_state = val;
		}
		
		public function get state():int	{
			return _state;
		}
		
		public function get windowID():int	{
			return _windowID;
		}
//		public function get parentWindowId():int	{
//			return _parentWindowId;
//		}
		public function set winTitle(val:String):void	{
			_winTitle = val;
			this.title = _winTitle;			
		}
		
		override public function set title(value:String):void	{
			super.title = value;
			dispatchEvent(new WindowTitleChangedEvent(WindowTitleChangedEvent.WINDOW_TITLE_CHANGED, this));
		}		
		public function get winTitle():String{
			return _winTitle;
		}
		
		public function set content(val:UIComponent):void	{
			if (_content != null)	
				removeChild(_content);
			_content = val;
			_content.addEventListener(MDICompareObjectEvent.MDI_COMPAREOBJECT,onCompareObject,false,0,true);
			addChild(_content);
		}
		
		public function get content():UIComponent	{
			return _content;	
		}
		
		public function setWindowStyle(active:Boolean):void	{
			if (active)	{
				this.styleName =  "mdiWindowStyle";
			}
			else	{
				this.styleName = "mdiWindowStyleInactive";
			}
		}
		
		public function closeWindow():void	{
			dispatchEvent(new WindowCloseEvent(WindowCloseEvent.WINDOW_CLOSE, this, ContainerManager.getExistingInstance().getDescendentsOfWindow(this.windowID)));
		}
		private function onClose(event:MouseEvent):void	{
			dispatchEvent(new WindowCloseEvent(WindowCloseEvent.WINDOW_CLOSE, this, ContainerManager.getExistingInstance().getDescendentsOfWindow(this.windowID)));
		}
		
		
//		public function addChildWindow(id:int):void	{
//			if (_childWindows == null)
//				_childWindows = new ArrayCollection();
//			_childWindows.addItem(id); 
//		}		
		private function onMinClick(event:MouseEvent):void	{
			dispatchEvent(new WindowMinimizeEvent(WindowMinimizeEvent.WINDOW_MINIMIZE, this));
		}
		
		private function onMaxClick(event:MouseEvent):void	{
			dispatchEvent(new WindowMaximizeEvent(WindowMaximizeEvent.WINDOW_MAXIMIZE, this));
		}
		private function onHeaderDoubleClick(event:MouseEvent):void	{
			dispatchEvent(new WindowMaximizeEvent(WindowMaximizeEvent.WINDOW_MAXIMIZE, this));
		}
		protected override function createChildren():void{
			super.createChildren();
			this.showCloseButton = false;
			this.layout = "vertical";
			this.width = 400;
			this.height = 300;
			
			_btnMinimize = new Button();
			_btnMinimize.styleName = "winMinButton"; //.setStyle("icon", minIcon);
			_btnMinimize.toolTip = "Minimize";
			_btnMinimize.addEventListener(MouseEvent.CLICK, onMinClick);
			this.rawChildren.addChild(_btnMinimize);
			
			_btnMaximize = new Button();
			_btnMaximize.styleName = "winDoMaxButton"; //.setStyle("icon", maxIcon);
			_btnMaximize.toolTip = "Maximize";
			_btnMaximize.addEventListener(MouseEvent.CLICK, onMaxClick);
			this.rawChildren.addChild(_btnMaximize);
			
			_btnClose = new Button();
			_btnClose.styleName = "winCloseButton"; //.setStyle("icon", closeIcon);
			_btnClose.toolTip = "Close";
			_btnClose.addEventListener(MouseEvent.CLICK, onClose);
			
			this.rawChildren.addChild(_btnClose);
			
			addSizingHandle();
			
			this.titleBar.doubleClickEnabled = true;
			this.titleBar.addEventListener(MouseEvent.DOUBLE_CLICK, onHeaderDoubleClick);
			this.titleBar.addEventListener(MouseEvent.MOUSE_DOWN, onDrag);
			this.titleBar.addEventListener(MouseEvent.MOUSE_UP, onDrag);
			this.titleBar.addEventListener(MouseEvent.CLICK, onClick);
			
			
			this.addEventListener(MouseEvent.MOUSE_MOVE, onMouseMove);
			this.addEventListener(MouseEvent.MOUSE_OUT, onMouseOut);
			this.addEventListener(MouseEvent.MOUSE_DOWN, onMouseDown);
			this.addEventListener(WindowMaximizeEvent.WINDOW_MAXIMIZE, onMaximizeWindow);
			
		}
  
  		private function addSizingHandle():void
  		{
  			shape = new Shape();			
			shape.graphics.clear();
		
			var ptH:Number = 1;
			
			// Light B1C9E8
			var pt11:Point = new Point(9,1);
			var pt12:Point = new Point(9,5);
			var pt13:Point = new Point(9,9);
			var pt22:Point = new Point(5,5);
			var pt23:Point = new Point(5,9);
			var pt33:Point = new Point(1,9);
			
			shape.graphics.lineStyle(2, 0xB1C9E8);
			shape.graphics.moveTo(pt11.x,pt11.y);
			shape.graphics.lineTo(pt11.x,pt11.y+ptH);
			
			shape.graphics.moveTo(pt12.x,pt12.y);
			shape.graphics.lineTo(pt12.x,pt12.y+ptH);
			
			shape.graphics.moveTo(pt13.x,pt13.y);
			shape.graphics.lineTo(pt13.x,pt13.y+ptH);
			
			shape.graphics.moveTo(pt22.x,pt22.y);
			shape.graphics.lineTo(pt22.x,pt22.y+ptH);
			
			shape.graphics.moveTo(pt23.x,pt23.y);
			shape.graphics.lineTo(pt23.x,pt23.y+ptH);
			
			shape.graphics.moveTo(pt33.x,pt33.y);
			shape.graphics.lineTo(pt33.x,pt33.y+ptH);
			
			// Dark
			var pt11d:Point = new Point(8,0);
			var pt12d:Point = new Point(8,4);
			var pt13d:Point = new Point(8,8);
			var pt22d:Point = new Point(4,4);
			var pt23d:Point = new Point(4,8);
			var pt33d:Point = new Point(0,8);
			
			shape.graphics.lineStyle(2, 0x455D80);
			shape.graphics.moveTo(pt11d.x,pt11d.y);
			shape.graphics.lineTo(pt11d.x,pt11d.y+ptH);
			
			shape.graphics.moveTo(pt12d.x,pt12d.y);
			shape.graphics.lineTo(pt12d.x,pt12d.y+ptH);
			
			shape.graphics.moveTo(pt13d.x,pt13d.y);
			shape.graphics.lineTo(pt13d.x,pt13d.y+ptH);
			
			shape.graphics.moveTo(pt22d.x,pt22d.y);
			shape.graphics.lineTo(pt22d.x,pt22d.y+ptH);
			
			shape.graphics.moveTo(pt23d.x,pt23d.y);
			shape.graphics.lineTo(pt23d.x,pt23d.y+ptH);
			
			shape.graphics.moveTo(pt33d.x,pt33d.y);
			shape.graphics.lineTo(pt33d.x,pt33d.y+ptH);
			
			this.rawChildren.addChild(shape);
  		}
  		
  		public function maximize():void	{
 			if (_oldX == -1 && _oldY == -1 && _oldWidth == -1 && _oldHeight ==-1)	{
				
				_isMaximized = true;
				
				_btnMaximize.styleName = "winDoRestoreButton";//.setStyle("icon", restoreIcon);
				_btnMaximize.toolTip = "Restore";
				
				_oldX = this.x;
				_oldY = this.y;
				_oldWidth = this.width;
				_oldHeight = this.height;
				
				this.x = 0;
				this.y = 0;
				var r:Rectangle = ContainerManager.getExistingInstance().getCanvasRectangle();
				this.width = r.width;
				this.height = r.height;
				
			}
			else	{
				_isMaximized = false;
				
				_btnMaximize.styleName = "winDoMaxButton"; //.setStyle("icon", maxIcon);
				_btnMaximize.toolTip = "Maximize";
				
				this.x = _oldX;
				this.y = _oldY;
				this.width = _oldWidth;
				this.height = _oldHeight;
				
				_oldX = -1;
				_oldY = -1;
				_oldWidth = -1;
				_oldHeight = -1;
				
			} 			
  		}
		private function onMaximizeWindow(event:WindowMaximizeEvent):void	{
			maximize();
		}
	
		
		private function onMouseOut(event:MouseEvent):void	{
			cursorManager.removeAllCursors(); 
			_resizeCursorEnabled = false;
		}
		private function onMouseMove(event:MouseEvent):void	{
			var lowX:int = this.width - 15;
			var lowY:int = this.height - 15;
			var highX:int = this.width - 5;
			var highY:int = this.height - 5;
			
			if ((event.localX > lowX)
				&& (event.localX < highX)
				&& (event.localY > lowY)
				&& (event.localY < highY))	{
					cursorManager.setCursor(resizeCursor); //cursor.setBusyCursor();	
					_resizeCursorEnabled = true;
				}
			else	{
				cursorManager.removeAllCursors(); 
				_resizeCursorEnabled = false;
			}	
		}
		
		
		
		public function bringWindowToFront():void	{
			if (state == MINIMIZED)	{
				var minWin:MinimizedWindow = ContainerManager.getExistingInstance().getMinimized(this);
				minWin.restoreWindow();
			}
			else if (state == OPEN)	{
				this.parent.setChildIndex(this, ContainerManager.getExistingInstance().getCanvasChildrenCount()-1);
				ContainerManager.getExistingInstance().recalculateWindowStyles();
			}
			
			//MS:TODO if (state == MINIMIZED)
		}
		private function onClick(event:MouseEvent):void	{
			bringWindowToFront();			
		} 
		
	
		
		private function onMouseDown(event:MouseEvent):void	{
			if (_resizeCursorEnabled)	{
				dispatchEvent(new WindowResizeStartEvent(WindowResizeStartEvent.WINDOW_RESIZE_START, this));
			}
		
		}
		private function onDrag(event:MouseEvent):void{
			if (event.type == "mouseDown")	{
				bringWindowToFront();	
				var r:Rectangle = ContainerManager.getExistingInstance().getCanvasRectangle();
				this.startDrag(false, new Rectangle(r.x,r.y,r.width-this.width, r.height-this.height));
			}
			else	{
				this.stopDrag();
			}
			
		}
		protected override function updateDisplayList(unscaledWidth:Number, unscaledHeight:Number):void{
			super.updateDisplayList(unscaledWidth, unscaledHeight);

			//set the button size + margin
			_btnMinimize.setActualSize(20, 20);
			_btnClose.setActualSize(20, 20);
			_btnMaximize.setActualSize(20,20);
			
			//define padding
			var pixelsRight:int = 3; 
			var pixelsTop:int = 3;
			var pixelsBetn:int = 3;
			
			//position the button in the panel
			_btnClose.move(unscaledWidth - _btnClose.width - pixelsRight, pixelsTop);
			_btnMaximize.move(unscaledWidth - _btnMinimize.width - _btnClose.width - pixelsRight - pixelsBetn, pixelsTop);
			_btnMinimize.move(unscaledWidth - _btnMaximize.width - _btnMinimize.width - _btnClose.width - pixelsRight - (pixelsBetn*2), pixelsTop);
			
			shape.x = unscaledWidth-15;
			shape.y = unscaledHeight-14;
			
		}
		
		private function onCompareObject(event:MDICompareObjectEvent):void {
			dispatchEvent(event);
		}
	}
}