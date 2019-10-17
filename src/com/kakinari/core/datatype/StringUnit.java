package com.kakinari.core.datatype;

import com.kakinari.core.datatype.interfaces.Param;

public class StringUnit extends BaseUnit<String> {

	public StringUnit(String value) {
		super(value);
	}

	protected StringUnit(String value, Param param) {
		super(value, param);
	}

	
	@Override
	public String getValue() {
		return super.getValue();
	}

	@Override
	public String toString() {
		return getValue();
	}
}
