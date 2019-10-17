package com.kakinari.core.datatype;

import com.kakinari.core.datatype.interfaces.Param;

public class NumberUnit extends BaseUnit<Number> {

	public NumberUnit(Number value) {
		super(value);
	}

	protected NumberUnit(Number value, Param param) {
		super(value, param);
	}

	public NumberUnit(Number value, String format) {
		super(value);
		setFormat(format);
	}

	@Override
	public Number getValue() {
		return super.getValue();
	}

	public byte toByte() {
		return getValue().byteValue();
	}
	
	public double toDouble() {
		return getValue().doubleValue();
	}
	
	public float toFloat() {
		return getValue().floatValue();
	}
	
	public short toShort() {
		return getValue().shortValue();
	}
	
	public int toInteger() {
		return getValue().intValue();
	}
	
	public long toLong() {
		return getValue().longValue();
	}
	
	@Override
	public String toString() {
		if (hasFormat())
			return String.format(getFormat(), getValue());
		return getValue().toString();
	}

	@Override
	public String toJSONString(int indent, boolean beautify) {
		setBeautify(beautify);
		setIndent(indent);
		return getIndents() + toString();
	}
}
