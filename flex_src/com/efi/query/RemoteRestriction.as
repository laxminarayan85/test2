package com.efi.query
{
	import com.efi.vo.*;
	
	[Bindable]
	[RemoteClass(alias="com.efi.printsmith.query.RemoteRestriction")]

	public class RemoteRestriction extends RemoteCriterion
	{
		static public const between:String = "BETWEEN";
		static public const eq:String = "EQ";
		static public const gt:String = "GT";
		static public const ge:String = "GE";
		static public const ne:String = "NE";
		static public const lt:String = "LT";
		static public const le:String = "LE";
		
		public var operator:String = null;
		public var propertyName:String = null;
		public var value:Object = null;
		public var high:Object = null;
		public var low:Object = null;
		
		public function RemoteRestriction() { 
			super();
		}

		/**
		 * @return the operator
		 */
		public function getOperator():String {
			return operator;
		}
		/**
		 * @param operator the operator to set
		 */
		public function setOperator(operator:String):void {
			this.operator = operator;
		}
		/**
		 * @return the propertyName
		 */
		public function getPropertyName():String {
			return propertyName;
		}
		/**
		 * @param propertyName the propertyName to set
		 */
		public function setPropertyName(propertyName:String):void {
			this.propertyName = propertyName;
		}
		/**
		 * @return the value
		 */
		public function getValue():Object {
			return value;
		}
		/**
		 * @param value the value to set
		 */
		public function setValue(value:Object):void {
			this.value = value;
		}		
		/**
		 * @return the low value
		 */
		public function getLow():Object {
			return low;
		}
		/**
		 * @param low the value to set
		 */
		public function setLow(low:Object):void {
			this.low = low;
		}		
		/**
		 * @return the high value
		 */
		public function getHigh():Object {
			return low;
		}
		/**
		 * @param high the value to set
		 */
		public function setHigh(high:Object):void {
			this.high = high;
		}		
	}
}
