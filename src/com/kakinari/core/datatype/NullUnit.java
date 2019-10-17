package com.kakinari.core.datatype;

public class NullUnit extends BaseUnit<Object> {

	public NullUnit() {
		super(null);
	}

	@Override
	public String toString() {
		return null;
	}

	@Override
	public Object getValue() {
		return null;
	}
}
