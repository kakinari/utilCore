package com.kakinari.core.datatype.interfaces;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Param extends HashMap<String, Object> {
	private static final long serialVersionUID = 816613391907402989L;
	private static final String KEY_OPTIONPARAM = "optParam";
	private static final String KEY_CLASSNAME = "className";
	private static final String KEY_BEAUTIFY = "beautify";
	private static final String KEY_COMMENT = "comment";
	private static final String  KEY_INDENT = "indent";
	private static final String KEY_IDSTRING = "idstring";
	private static final String KEY_TAGSTRING = "tagstring";
	private static final String KEY_XTAGSTRING = "xmltagstring";
	private static final String KEY_FORMAT = "dateFormat";
	private static final String KEY_CHIELD_HTML_TAG = "chieldTag";
	private static final String KEY_CHIELD_XML_TAG = "chieldXmlTag";
	private static final String KEY_ITEM_ORDER = "itemOrder";

	public Param() {
		super();
	}

	public Param(int initialCapacity, float loadFactor) {
		super(initialCapacity, loadFactor);
	}

	public Param(int initialCapacity) {
		super(initialCapacity);
	}

	public Param(Map<String,  Object> m) {
		super(m);
	}

	private String getString(String key) {
		return containsKey(key) && get(key) != null ? get(key).toString() : null;
	}

	private Integer getInteger(String key) {
		return containsKey(key) && get(key) != null && get(key) instanceof Integer ? (Integer) get(key) : null;
	}
	
	private Object getValue(String key) {
		return containsKey(key) ? get(key)  : null;
	}

	private boolean isValue(String key) {
		return containsKey(key) && get(key) != null && get(key) instanceof Boolean ? (Boolean) get(key) : false;
	}

	private boolean hasValue(String key) {
		return containsKey(key) && get(key) != null;
	}
	
	private void setValue(String key, Object value) {
		if (key != null && value != null)
			put(key, value);
	}

	private Object unsetValue(String key) {
		return key == null ? null : remove(key);
	}

	public boolean hasOptParam() {
		return hasValue(KEY_OPTIONPARAM );
	}

	public ParamOption getOptParam() {
		Object ret = getValue(KEY_OPTIONPARAM);
		return ret != null && ret instanceof ParamOption ? (ParamOption) ret : null;
	}
	
	public void setOptParam(ParamOption opts) {
		setValue(KEY_OPTIONPARAM, opts);
	}

	public Object unsetOptParam() {
		return unsetValue(KEY_OPTIONPARAM);
	}

	public boolean hasClassName() {
		return hasValue(KEY_CLASSNAME);
	}

	public String getClassName() {
		return getString(KEY_CLASSNAME);
	}
	
	public void setClassName(String className) {
		setValue(KEY_CLASSNAME, className);
	}

	public Object unsetClassName() {
		return unsetValue(KEY_CLASSNAME);
	}

	public boolean isBeautify() {
		return isValue(KEY_BEAUTIFY);
	}

	public void setBeautify(boolean brautify) {
		setValue(KEY_BEAUTIFY, Boolean.valueOf(brautify));
	}

	public Object unsetBeautify() {
		return unsetValue(KEY_BEAUTIFY);
	}

	public boolean hasComment() {
		return hasValue(KEY_COMMENT);
	}

	public String getComment() {
		return getString(KEY_COMMENT);
	}

	public void setComment(String comment) {
		setValue(KEY_COMMENT, comment);
	}

	public Object unsetComment() {
		return unsetValue(KEY_COMMENT);
	}

	public int getIndent() {
		return getInteger(KEY_INDENT) != null ? getInteger(KEY_INDENT) : 0;
	}

	public int inclementIndent() {
		int inc = getIndent();
		setIndent(++inc);
		return  getIndent();
	}

	public int declementIndent() {
		int inc = getIndent();
		inc--;
		if (inc > 0)
			setIndent(inc);
		else
			unsetIndent();
		return getIndent();
	}
	
	public void setIndent(int indents) {
		setValue(KEY_INDENT, Integer.valueOf(indents));
	}

	public Object unsetIndent() {
		return unsetValue(KEY_INDENT);
	}

	public boolean hasIdString() {
		return hasValue(KEY_IDSTRING);
	}

	public String getIdString() {
		return getString(KEY_IDSTRING);
	}

	public void setIdString(String idString) {
		setValue(KEY_IDSTRING, idString);
	}

	public Object  unsetIdString() {
		return unsetValue(KEY_IDSTRING);
	}

	public boolean hasTag() {
		return hasValue(KEY_TAGSTRING);
	}

	public String getTag() {
		return getString(KEY_TAGSTRING);
	}

	public void setTag(String tag) {
		setValue(KEY_TAGSTRING, tag);
	}

	public Object unsetTag() {
		return unsetValue(KEY_TAGSTRING);
	}

	public boolean hasXmlTag() {
		return hasValue(KEY_XTAGSTRING);
	}

	public String getXmlTag() {
		return getString(KEY_XTAGSTRING);
	}

	public void setXmlTag(String tag) {
		setValue(KEY_XTAGSTRING, tag);
	}

	public Object unsetXmlTag() {
		return unsetValue(KEY_XTAGSTRING);
	}

	public boolean hasFormat() {
		return hasValue(KEY_FORMAT);
	}
	
	public String getFormat() {
		return getString(KEY_FORMAT);
	}

	public void setFormat(String format) {
		 setValue(KEY_FORMAT, format); 
	}

	public Object unsetFormat() {
		 return unsetValue(KEY_FORMAT); 
	}

	public boolean hasItemOrder() {
		return hasValue(KEY_ITEM_ORDER);
	}
	
	public List<Object> getItemOrder() {
		Object val = getValue(KEY_ITEM_ORDER);
		if (val == null || ! (val instanceof List)) return null;
		List<Object> ret = new ArrayList<Object>();
		for (Object value : (List<?>)val)
			ret.add(value.toString());
		return ret;
	}

	public void setItemOrder(List<Object> list) {
		 setValue(KEY_ITEM_ORDER, list); 
	}

	public Object unsetItemOrder() {
		 return unsetValue(KEY_ITEM_ORDER); 
	}

	public boolean hasChildHtmlTag() {
		return hasValue(KEY_CHIELD_HTML_TAG);
	}

	public String getChildHtmlTag() {
		return getString(KEY_CHIELD_HTML_TAG);
	}
	
	public void setChildHtmlTag(String tag) {
		setValue(KEY_CHIELD_HTML_TAG, tag);
	}

	public Object unsetChildHtmlTag() {
		return unsetValue(KEY_CHIELD_HTML_TAG);
	}

	public boolean hasChildXmlTag() {
		return hasValue(KEY_CHIELD_XML_TAG);
	}

	public String getChildXmlTag() {
		return getString(KEY_CHIELD_XML_TAG);
	}
	
	public void setChildXmlTag(String tag) {
		setValue(KEY_CHIELD_XML_TAG, tag);
	}

	public Object unsetChildXmlTag() {
		return unsetValue(KEY_CHIELD_XML_TAG);
	}

	public boolean hasParamValue(String key) {
		return hasValue(key);
	}
	
	public Object getParamValue(String key) {
		return getValue(key);
	}

	public void setParamValue(String key, Object value) {
		setValue(key, value);
	}

	public Object unsetParamValue(String key) {
		return unsetValue(key);
	}

	public String getLineBreak() {
		return isBeautify() ?  "\n" : "";
	}
	
	public String getIndents() {
		if (!isBeautify()) return "";
		StringBuffer sb = new StringBuffer();
		for (int i=0;i<getIndent();i++)
			sb.append("    ");
		return sb.toString();
	}
}
