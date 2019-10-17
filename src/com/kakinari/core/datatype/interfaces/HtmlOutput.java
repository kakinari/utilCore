package com.kakinari.core.datatype.interfaces;

public interface HtmlOutput {
	public String toHtmlString();
	public String toHtmlString(boolean beautify);
	public String toHtmlString(int indent);
	public String toHtmlString(int indent, boolean beautify);
}
