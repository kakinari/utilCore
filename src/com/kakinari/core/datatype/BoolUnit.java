package com.kakinari.core.datatype;

import com.kakinari.core.datatype.interfaces.Param;

public class BoolUnit extends BaseUnit<Boolean> {

	public BoolUnit() {
		super(Boolean.FALSE);
	}

	public BoolUnit(Boolean flag) {
		super(flag);
	}

	public BoolUnit(Boolean value, Param param) {
		super(value, param);
	}

	@Override
	public String toString() {
		return getValue() ? "true" : "false";
	}

	@Override
	public Boolean getValue() {
		return super.getValue();
	}
}
