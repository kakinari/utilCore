package com.kakinari.core.datatype.interfaces;

public interface XMLOutput {
	public String toXMLString();
	public String toXMLString(boolean beautify);
	public String toXMLString(int indent);
	public String toXMLString(int indent, boolean beautify);
}
