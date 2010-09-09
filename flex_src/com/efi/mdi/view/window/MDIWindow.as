package com.efi.mdi.view.window
{
	import com.efi.mdi.ContainerManager;
	import com.efi.mdi.event.window.WindowCloseEvent;
	import com.efi.mdi.event.window.WindowMaximizeEvent;
	import com.efi.mdi.event.window.WindowMinimizeEvent;
	import com.efi.mdi.event.window.WindowResizeStartEvent;
	
	import flash.events.MouseEvent;
	import flash.geom.Point;
	import flash.geom.Rectangle;
	
	import mx.collections.ArrayCollection;
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
		
		private var _windowID:int;
		private var _state:int;
				
		private var _btnMinimize:Button;
		private var _btnClose:Button;
		private var _btnMaximize:Button;
		
		private var _oldX:int = -1;
		private var _oldY:int = -1;
		private var _oldWidth:int = -1;
		private var _oldHeight:int = -1;
		
		
		private var _childWindows:ArrayCollection;
		private var _parentWindowId:int;
		
		private var _childWindowSpawned:Boolean;
		
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
        [Embed(source="assets/mdi/cursorresize.png")]
        private var resizeCursor:Class;
		 
		private var _resizeCursorEnabled:Boolean = false;
		 
		public function MDIWindow(winTitle:String, content:UIComponent, id:int, parentWin:int = -1)
		{
			super();
			this.winTitle = winTitle;
			this.content = content;			
			this.windowID = id;
			this.state = OPEN;
			this.parentWindowId = parentWin;
			this.styleName = "mdiWindowStyle";
		}
		
		//MS: should be a private function	
		public function set windowID(val:int):void	{
			_windowID = val;
		}
		public function set parentWindowId(val:int):void	{
			_parentWindowId = val;
		}
		public function set state(val:int):void	{
			_state = val;
		}
		
		public function get state():int	{
			return _state;
		}
		
		public function get windowID():int	{
			return _windowID;
		}
		public function get parentWindowId():int	{
			return _parentWindowId;
		}
		public function set winTitle(val:String):void	{
			_winTitle = val;
			this.title = _winTitle;
		}
		
		public function get winTitle():String{
			return _winTitle;
		}
		
		public function set content(val:UIComponent):void	{
			if (_content != null)	
				removeChild(_content);
			_content = val;
			addChild(_content);
		}
		
		public function get content():UIComponent	{
			return _content;	
		}
		
		private function onClose(event:MouseEvent):void	{
			dispatchEvent(new WindowCloseEvent(WindowCloseEvent.WINDOW_CLOSE, this));
		}
		
		public function addChildWindow(id:int):void	{
			if (_childWindows == null)
				_childWindows = new ArrayCollection();
			_childWindows.addItem(id); 
		}		
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
  
		private function onMaximizeWindow(event:WindowMaximizeEvent):void	{
			if (_oldX == -1 && _oldY == -1 && _oldWidth == -1 && _oldHeight ==-1)	{
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
			if (state == OPEN)	{
				this.parent.setChildIndex(this, ContainerManager.getExistingInstance().getCanvasChildrenCount()-1);
			}
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
			
			graphics.clear();
			graphics.lineStyle(1, 0x000000);
			graphics.moveTo(unscaledWidth - 15, unscaledHeight);
			graphics.lineTo(unscaledWidth, unscaledHeight-15);
			graphics.moveTo(unscaledWidth - 10, unscaledHeight);
			graphics.lineTo(unscaledWidth, unscaledHeight-10);
			graphics.moveTo(unscaledWidth - 5, unscaledHeight);
			graphics.lineTo(unscaledWidth, unscaledHeight-5);
		}
	}
}