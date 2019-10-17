package com.kakinari.core.datatype;

import java.util.Calendar;
import java.util.Date;

import com.kakinari.core.datatype.interfaces.Param;

public class ObjectUnit extends BaseUnit<Object> {

	public ObjectUnit(Object value) {
		super(value);
	}

	public ObjectUnit(Object value, Param param) {
		super(value, param);
	}

	@Override
	public Object getValue() {
		return super.getValue();
	}

	public StringUnit toStringUnit() {
		if (getValue() instanceof String)
			return new StringUnit(getValue().toString(), getParam());
		return null;
	}

	public DateUnit toDateUnit() {
		if (getValue() instanceof Date)
			return new DateUnit((Date)getValue(), getParam());
		else if (getValue() instanceof Calendar)
			return new DateUnit((Calendar)getValue(), getParam());
		return null;
	}

	public NumberUnit toNumberUnit() {
		if (getValue() instanceof Number)
			return new NumberUnit((Number)getValue(), getParam());
		return null;
	}
}
