
import com.efi.printsmith.security.PSSecurityUtils;
private var _securityCleared:Boolean;
//	private var _securityCallback:Function;
//	private var _securityInputArgs:Array;
	
	public function preInit():void	{
		if (checkSecurityAccess())
			this.addEventListener(FlexEvent.CREATION_COMPLETE, init);		
	}



	
	public function checkSecurityAccess():Boolean	{
//		_securityCallback = securityCallback;
		if (PSSecurityUtils.getInstance().checkSecurityAccess(this))
			_securityCleared = true;
		else
			_securityCleared = false;
		return _securityCleared;		
	}
	
	public function get securityCleared():Boolean	{
		return _securityCleared;
	}
	
	
//	public function getCallbackFunction():Function	{
//		return _securityCallback;
//	}
//	
//	public function getInputArgs():Array	{
//		return _securityInputArgs;
//	}