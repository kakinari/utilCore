package com.kakinari.core.datatype;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.TimeZone;

import com.kakinari.core.datatype.interfaces.Param;

public class DateUnit extends BaseUnit<Date> {
	private static final String DEFAULT_FORMAT = "yyyy年MM月dd日 HH:mm:ss";

	public DateUnit(Date value) {
		super(value);
	}

	public DateUnit(Calendar value) {
		super(value.getTime());
	}

	public DateUnit(Timestamp value) {
		super(new Date(value.getTime()));
	}

	protected DateUnit(Date value, Param param) {
		super(value, param);
	}

	public DateUnit(Calendar value, Param param) {
		super(value.getTime(), param);
	}

	public DateUnit(Timestamp value, Param param) {
		super(new Date(value.getTime()), param);
	}

	public DateUnit(Date value, String format) {
		super(value);
		setFormat(format);
	}

	public DateUnit(Calendar value, String format) {
		super(value.getTime());
		setFormat(format);
	}

	@Override
	public Date getValue() {
		return super.getValue();
	}

	@Override
	public String toString() {
		return new SimpleDateFormat(hasFormat() ? getFormat() : DEFAULT_FORMAT).format(getValue());
	}

	public Calendar toCalendar() {
		Calendar now = Calendar.getInstance(TimeZone.getDefault());
		now.setTime(getValue());
		return now;
	}
	
}
