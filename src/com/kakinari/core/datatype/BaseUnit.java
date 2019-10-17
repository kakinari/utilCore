package com.kakinari.core.datatype;

import java.util.List;
import java.util.regex.Pattern;

import com.kakinari.core.datatype.interfaces.HtmlOutput;
import com.kakinari.core.datatype.interfaces.JSONOutput;
import com.kakinari.core.datatype.interfaces.Param;
import com.kakinari.core.datatype.interfaces.ParamOption;
import com.kakinari.core.datatype.interfaces.XMLOutput;

public class BaseUnit<T> implements Cloneable, JSONOutput, HtmlOutput, XMLOutput {
	private T value = null;
	private Param param = null;
	
	public BaseUnit(T value) {
		super();
		this.value = value;
		this.param  = new Param();
	}

	protected BaseUnit(T value, Param param) {
		super();
		this.value = value;
		this.param  = new Param();
		this.param.putAll(param);
	}

	public T getValue() {
		return this.value;
	}
	
	@Override
	protected BaseUnit<T> clone() throws CloneNotSupportedException {
		return new BaseUnit<T>(value, new Param(param));
	}

	protected Param getParam() {
		return param;
	}

	protected void setParam(Param param) {
		this.param = param;
	}

	public boolean hasOptParam() {
		return param.hasOptParam();
	}

	public ParamOption getOptParam() {
		return  param.getOptParam();
	}
	
	public void setOptParam(ParamOption opts) {
		param.setOptParam(opts);;
	}

	public Object unsetOptParam() {
		return param.unsetOptParam();
	}

	public boolean hasClassName() {
		return param.hasClassName();
	}

	public String getClassName() {
		return param.getClassName();
	}
	public void setClassName(String className) {
		param.setClassName(className);
	}

	public void unsetClassName() {
		param.unsetClassName();
	}

	public boolean isBeautify() {
		return param.isBeautify();
	}

	public void setBeautify(boolean brautify) {
		param.setBeautify( brautify);
	}

	public void unsetBeautify() {
		param.unsetBeautify();
	}

	public boolean hasComment() {
		return param.hasComment();
	}

	public String getComment() {
		return param.getComment();
	}

	public void setComment(String comment) {
		param.setComment(comment);
	}

	public void unsetComment() {
		param.unsetComment();
	}

	public int getIndent() {
		return param.getIndent();
	}

	public int inclementIndent() {
		return param.inclementIndent();
	}

	public int declementIndent() {
		return param.declementIndent();
	}
	
	public void setIndent(int indents) {
		param.setIndent(indents);
	}

	public void unsetIndent() {
		param.unsetIndent();
	}

	public boolean hasIdString() {
		return param.hasIdString();
	}

	public String getIdString() {
		return param.getIdString();
	}

	public void setIdString(String idString) {
		param.setIdString(idString);
	}

	public Object unsetIdString() {
		return param.unsetIdString();
	}

	public boolean hasTag() {
		return param.hasTag();
	}

	public String getTag() {
		return param.getTag();
	}

	public void setTag(String tag) {
		param.setTag(tag);
	}

	public Object unsetTag() {
		return param.unsetTag();
	}

	public boolean hasXmlTag() {
		return param.hasXmlTag();
	}

	public String getXmlTag() {
		return param.getXmlTag();
	}

	public void setXmlTag(String tag) {
		param.setXmlTag(tag);
	}

	public Object unsetXmlTag() {
		return param.unsetXmlTag();
	}

	public boolean hasParamValue(String key) {
		return param.hasParamValue( key);
	}

	public Object getParamValue(String key) {
		return param.getParamValue( key);
	}

	public void setParamValue(String key, Object value) {
		param.setParamValue(key,  value);
	}

	public Object unsetParamValue(String key) {
		return param.unsetParamValue(key);
	}

	public boolean hasChildHtmlTag() {
		return param.hasChildHtmlTag();
	}

	public String getChildHtmlTag() {
		return param.getChildHtmlTag();
	}
	
	public void setChildHtmlTag(String tag) {
		param.setChildHtmlTag(tag);
	}

	public Object unsetChildHtmlTag() {
		return param.unsetChildHtmlTag();
	}

	public boolean hasChildXmlTag() {
		return param.hasChildXmlTag();
	}

	public String getChildXmlTag() {
		return param.getChildXmlTag();
	}
	
	public void setChildXmlTag(String tag) {
		param.setChildXmlTag(tag);
	}

	public Object unsetChildXmlTag() {
		return param.unsetChildXmlTag();
	}

	public boolean hasItemOrder() {
		return param.hasItemOrder();
	}
	
	public List<Object> getItemOrder() {
		return param.getItemOrder();
	}

	public void setItemOrder(List<Object> order) {
		param.setItemOrder(order);
	}

	public Object unseItemOrder() {
		return param.unsetItemOrder();
	}

	public boolean hasFormat() {
		return param.hasFormat();
	}
	
	public String getFormat() {
		return param.getFormat(); 
	}

	public void setFormat(String format) {
		 param.setFormat(format); 
	}

	public Object unsetFormat() {
		 return param.unsetFormat(); 
	}


	public String getLineBreak() {
		return param.getLineBreak();
	}
	
	public String getIndents() {
		return param.getIndents();
	}

	@Override
	public String toXMLString() {
		return toXMLString(getIndent(), isBeautify());
	}

	@Override
	public String toXMLString(boolean beautify) {
		return toXMLString(getIndent(), beautify);
	}

	@Override
	public String toXMLString(int indent) {
		return toXMLString(indent, isBeautify());
	}

	@Override
	public String toXMLString(int indent, boolean beautify) {
		setBeautify(beautify);
		setIndent(indent);
		if (value instanceof XMLOutput)
			return ((XMLOutput)value).toXMLString(indent, beautify);
		StringBuffer sb = new StringBuffer();
		if (hasComment())
			sb.append(getIndents()).append("<!-- ").append(getComment()).append(" -->").append(getLineBreak());
		if (hasXmlTag()) {
			sb.append(getIndents()).append("<").append(getXmlTag());
			if (hasOptParam()) {
				 ParamOption map = getOptParam();
				if (map != null)
					for (String key : map.keySet())
						sb.append(" ").append(key).append("=\"").append(map.get(key)).append("\"");
			}
			sb.append(">");
		}
		sb.append(toString()
				.replace(Pattern.quote("<"), "&lt;")
				.replace(Pattern.quote(">"), "&gt;")
				.replace(Pattern.quote("&"), "&amp;")
				.replace("'", "&apos;")
				.replace("\"", "&quot;"));
		if (hasXmlTag())
			sb.append("</").append(getXmlTag()).append(">");
		return sb.toString();
	}

	@Override
	public String toHtmlString() {
		return toHtmlString(getIndent(), isBeautify());
	}

	@Override
	public String toHtmlString(boolean beautify) {
		return toHtmlString(getIndent(), beautify);
	}

	@Override
	public String toHtmlString(int indent) {
		return toHtmlString(indent, isBeautify());
	}

	@Override
	public String toHtmlString(int indent, boolean beautify) {
		setBeautify(beautify);
		setIndent(indent);
		if (value instanceof HtmlOutput)
			return ((HtmlOutput)value).toHtmlString(indent, beautify);
		StringBuffer sb = new StringBuffer();
		if (hasComment())
			sb.append(getIndents()).append("<!-- ").append(getComment()).append(" -->").append(getLineBreak());
		if (hasTag()) {
			sb.append(getIndents()).append("<").append(getTag());
			if (hasClassName())
				sb.append(" class=\"").append(getClassName()).append("\"");
			if (hasIdString())
				sb.append(" id=\"").append(getIdString()).append("\"");
			if (hasOptParam()) {
				 ParamOption map = getOptParam();
				if (map != null)
					for (String key : map.keySet())
						sb.append(" ").append(key).append("=\"").append(map.get(key)).append("\"");
			}
			sb.append(">");
		}
		sb.append(toString()
				.replace(Pattern.quote("<"), "&lt;")
				.replace(Pattern.quote(">"), "&gt;")
				.replace(Pattern.quote("&"), "&amp;")
				.replace("'", "&apos;")
				.replace("\"", "&quot;"));
		if (hasTag())
			sb.append("</").append(getTag()).append(">");
		return sb.toString();
	}

	@Override
	public String toJSONString() {
		return toJSONString(getIndent(), isBeautify());
	}

	@Override
	public String toJSONString(boolean beautify) {
		return toJSONString(getIndent(), beautify);
	}

	@Override
	public String toJSONString(int indent) {
		return toJSONString(indent, isBeautify());
	}

	@Override
	public String toJSONString(int indent, boolean beautify) {
		setBeautify(beautify);
		setIndent(indent);
		if (value instanceof JSONOutput)
			return ((JSONOutput)value).toJSONString(indent, beautify);
		String val = toString();
		if (val != null) {
			val = val.replace("\r\n", "\\n");
			val = val.replace("\n", "\\n");
			val = val.replace("\t", "\\t");
			val = val.replace("\r", "");
			val = val.replace("\"", "\\\"");
			val = val.replace("/", "\\/");
			return getIndents() + "\"" + val + "\"";
		} else
			return getIndents() + "null";
	}

	@Override
	public String toString() {
		return value == null ? null : value.toString();
	}
}
