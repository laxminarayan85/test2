package com.efi.printsmith.query;

public class RemoteRestriction extends RemoteCriterion {
	static public final String between = "BETWEEN";
	static public final String eq = "EQ";
	static public final String gt = "GT";
	static public final String ge = "GE";
	static public final String ne = "NE";
	static public final String lt = "LT";
	static public final String le = "LE";
	
	private String operator = null;
	private String propertyName = null;
	private Object value = null;
	private Object low = null;
	private Object high = null;
	
	public RemoteRestriction() {
		super();
	}
	
	public RemoteRestriction(String operator, String propertyName, Object value) {
		super();
		this.operator = operator;
		this.propertyName = propertyName;
		this.value = value;
	}
	
	public RemoteRestriction(String operator, String propertyName, Object low, Object high) {
		super();
		this.operator = operator;
		this.propertyName = propertyName;
		this.low = low;
		this.high = high;
	}
	/**
	 * @return the operator
	 */
	public String getOperator() {
		return operator;
	}
	/**
	 * @param operator the operator to set
	 */
	public void setOperator(String operator) {
		this.operator = operator;
	}
	/**
	 * @return the propertyName
	 */
	public String getPropertyName() {
		return propertyName;
	}
	/**
	 * @param propertyName the propertyName to set
	 */
	public void setPropertyName(String propertyName) {
		this.propertyName = propertyName;
	}
	/**
	 * @return the value
	 */
	public Object getValue() {
		return value;
	}
	/**
	 * @param value the value to set
	 */
	public void setValue(Object value) {
		this.value = value;
	}
	/**
	 * @return the value
	 */
	public Object getLow() {
		return low;
	}
	/**
	 * @param value the value to set
	 */
	public void setLow(Object low) {
		this.low = low;
	}
	/**
	 * @return the value
	 */
	public Object getHigh() {
		return high;
	}
	/**
	 * @param value the value to set
	 */
	public void setHigh(Object high) {
		this.high = high;
	}
	
	
	
}
