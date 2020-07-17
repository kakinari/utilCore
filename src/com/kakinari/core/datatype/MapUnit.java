package com.kakinari.core.datatype;

import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import com.kakinari.core.datatype.interfaces.Param;
import com.kakinari.core.datatype.interfaces.ParamOption;

public abstract class MapUnit<T extends BaseUnit<?>> extends BaseUnit<Map<Object, T>> implements Map<Object, T> {
	private static final String DEFAULT_HTML_TAG = "tr";
	private static final String DEFAULT_HTML_CHIELD_TAG = "td";

	abstract protected void setMapValue(Map<?,?> mapdata);
	
	public MapUnit(Map<Object,T> table) {
		super(table);
		setTag(DEFAULT_HTML_TAG);
		setChildHtmlTag(DEFAULT_HTML_CHIELD_TAG );
	}

	public MapUnit(Map<Object, T> table, Param param) {
		super(table, param);
		setTag(DEFAULT_HTML_TAG);
		setChildHtmlTag(DEFAULT_HTML_CHIELD_TAG );
	}

	@Override
	public Map<Object, T> getValue() {
		return super.getValue();
	}
	
	public Map<Object, ?> toMapData(Map<Object,? extends Object> map) {
		return map;
	}
	
	@Override
	public String toXMLString(int indent, boolean beautify) {
		setBeautify(beautify);
		setIndent(indent);
		StringBuffer sb = new StringBuffer();
		if (hasComment())
			sb.append(getIndents()).append("<!-- ").append(getComment()).append(" -->").append(getLineBreak());
		sb.append(getIndents()).append("<").append(getXmlTag());
		if (hasOptParam()) {
			 ParamOption map = getOptParam();
			if (map != null)
				for (String key : map.keySet())
					sb.append(" ").append(key).append("=\"").append(map.get(key)).append("\"");
		}
		sb.append(">");
		List<Object> order = getItemOrder();
		for(Object key : order == null ? keySet() : order) {
			T item = get(key);
			item.setXmlTag(key.toString());
			sb.append(getLineBreak());
			sb.append(item.toXMLString(indent+1, beautify));
		}
		sb.append(getLineBreak());
		sb.append(getIndents());
		sb.append("</").append(getXmlTag()).append(">");
		return sb.toString();
	}

	@Override
	public String toHtmlString(int indent, boolean beautify) {
		setBeautify(beautify);
		setIndent(indent);
		StringBuffer sb = new StringBuffer();
		if (hasComment())
			sb.append(getIndents()).append("<!-- ").append(getComment()).append(" -->").append(getLineBreak());
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
		List<Object> order = getItemOrder();
		for(Object key : order == null ? keySet() : order) {
			T item = get(key);
			item.setIdString(key.toString());
			sb.append(getLineBreak());
			sb.append(item.toHtmlString(indent+1, beautify));
		}
		sb.append(getLineBreak());
		sb.append(getIndents());
		sb.append("</").append(getTag()).append(">");
		return sb.toString();
	}

	@Override
	public String toJSONString(int indent, boolean beautify) {
		setBeautify(beautify);
		setIndent(indent);
		StringBuffer sb = new StringBuffer();
		sb.append(getIndents()).append("{");
		boolean first = true;
		List<Object> order = getItemOrder();
		setIndent(indent+1);
		for(Object key : order == null ? keySet() : order) {
			T item = get(key);
			if (! first) sb.append(",");
			first = false;
			sb.append(getLineBreak());
			sb.append(getIndents());
			sb.append("\"").append(key).append("\" :");
			sb.append(item.toJSONString(0, false));
		}
		setIndent(indent);
		sb.append(getLineBreak());
		sb.append(getIndents()).append("}");
		return sb.toString();
	}

	@Override
	public String toString() {
		StringBuffer sb = new StringBuffer();
		List<Object> order = getItemOrder();
		for(Object key : order == null ? keySet() : order) {
			T item = get(key);
			if (sb.length()> 0) sb.append(",");
			sb.append(key).append("=");
			sb.append(item.toString());
		}
		return sb.toString();
	}

	@Override
	public int size() {
		return getValue().size();
	}

	@Override
	public boolean isEmpty() {
		return  getValue().isEmpty();
	}

	@Override
	public boolean containsKey(Object key) {
		return  getValue().containsKey(key);
	}

	@Override
	public boolean containsValue(Object value) {
		return  getValue().containsValue(value);
	}

	@Override
	public T get(Object key) {
		return  getValue().get(key);
	}

	@Override
	public T put(Object key, T value) {
		return  getValue().put(key, value);
	}

	@Override
	public T remove(Object key) {
		return  getValue().remove(key);
	}

	@Override
	public void putAll(Map<? extends Object, ? extends T> m) {
		 getValue().putAll(m);
	}

	@Override
	public void clear() {
		 getValue().clear();
	}

	@Override
	public Set<Object> keySet() {
		return  getValue().keySet();
	}

	@Override
	public Collection<T> values() {
		return  getValue().values();
	}

	@Override
	public Set<Entry<Object, T>> entrySet() {
		return  getValue().entrySet();
	}

	public Map<?,?> toMap() {
		return toMap(keySet().toArray(new String[0]));
	}
	
	public Map<?,?> toMap(String[] list) {
		HashMap<Object, Object> retval = new HashMap<Object, Object>();
		for(String key : list) {
			 T val = get(key);
			 if (val instanceof TreeUnit)
				 retval.put(key, ((TreeUnit<?>) val).toMap());
			 else if (val instanceof MapUnit)
				retval.put(key, ((MapUnit<?>) val).toMap());
			else if (val instanceof ListUnit)
				retval.put(key, ((ListUnit<?>) val).toList());
			else
				retval.put(key, val.getValue());
		}
		return retval;
	}
	
	public ListDataUnit toListUnit() {
		return toListUnit(keySet().toArray(new String[0]));
	}
	
	public ListDataUnit toListUnit(String[] list) {
		ListDataUnit ret = new ListDataUnit();
		for(String key : list)
			ret.add(get(key));
		return ret;
	}
}
