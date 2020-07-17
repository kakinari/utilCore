package com.kakinari.core.datatype;

import java.util.Collection;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.NavigableMap;
import java.util.NavigableSet;
import java.util.Set;
import java.util.SortedMap;
import java.util.TreeMap;

import com.kakinari.core.comparator.NameComparator;
import com.kakinari.core.datatype.interfaces.Param;
import com.kakinari.core.datatype.interfaces.ParamOption;

public abstract class TreeUnit<T extends BaseUnit<?>> extends MapUnit<T>
	implements Map<Object, T>,
	SortedMap<Object, T>, 
	NavigableMap<Object, T> {

	public TreeUnit() {
		super(new TreeMap<Object, T>());
	}

	public TreeUnit(Comparator<Object> comparator) {
		super(new TreeMap<Object, T>(comparator));
	}

	public TreeUnit(TreeUnit<T> tree) {
		super(new TreeMap<Object, T>(tree));
	}

	public TreeUnit(Param param) {
		super(new TreeMap<Object, T>(), param);
	}

	public TreeUnit(Comparator<Object> comparator, Param param) {
		super(new TreeMap<Object, T>(comparator), param);
	}

	public TreeUnit(TreeUnit<T> tree, Param param) {
		super(new TreeMap<Object, T>(tree), param);
	}

	public TreeUnit(TreeMap<?, ?> tree) {
		super(new TreeMap<Object, T>(new NameComparator(tree.keySet().toArray(new Object[0]))));
		setMapValue(tree);
	}

	public TreeUnit(TreeMap<?,?> tree, Param param) {
		super(new TreeMap<Object, T>(new NameComparator(tree.keySet().toArray(new Object[0]))), param);
		setMapValue(tree);
	}

	@Override
	public TreeMap<Object, T> getValue() {
		return (TreeMap<Object,T>)super.getValue();
	}

	public Map<Object,? extends Object> toMap() {
		TreeMap<Object, Object> retval = new TreeMap<Object, Object>(comparator());
		for(Object key : this.keySet()) {
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
				for (Object key : map.keySet())
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
				for (Object key : map.keySet())
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
	public Map.Entry<Object, T> lowerEntry(Object key) {
		return getValue().lowerEntry(key);
	}

	@Override
	public Object lowerKey(Object key) {
		return getValue().lowerKey(key);
	}

	@Override
	public Map.Entry<Object, T> floorEntry(Object key) {
		return getValue().lowerEntry(key);
	}

	@Override
	public Object floorKey(Object key) {
		return getValue().floorKey(key);
	}

	@Override
	public Map.Entry<Object, T> ceilingEntry(Object key) {
		return getValue().ceilingEntry(key);
	}

	@Override
	public Object ceilingKey(Object key) {
		return getValue().ceilingKey(key);
	}

	@Override
	public Map.Entry<Object, T> higherEntry(Object key) {
		return getValue().higherEntry(key);
	}

	@Override
	public Object higherKey(Object key) {
		return getValue().higherKey(key);
	}

	@Override
	public Map.Entry<Object, T> firstEntry() {
		return getValue().firstEntry();
	}

	@Override
	public Map.Entry<Object, T> lastEntry() {
		return getValue().lastEntry();
	}

	@Override
	public Map.Entry<Object, T> pollFirstEntry() {
		return getValue().pollFirstEntry();
	}

	@Override
	public Map.Entry<Object, T> pollLastEntry() {
		return getValue().pollLastEntry();
	}

	@Override
	public NavigableMap<Object, T> descendingMap() {
		return getValue().descendingMap();
	}

	@Override
	public NavigableSet<Object> navigableKeySet() {
		return getValue().navigableKeySet();
	}

	@Override
	public NavigableSet<Object> descendingKeySet() {
		return getValue().descendingKeySet();
	}

	@Override
	public NavigableMap<Object, T> subMap(Object fromKey, boolean fromInclusive, Object toKey,
			boolean toInclusive) {
		return getValue().subMap(fromKey, fromInclusive, toKey, toInclusive);
	}

	@Override
	public NavigableMap<Object, T> headMap(Object toKey, boolean inclusive) {
		return getValue().headMap(toKey, inclusive);
	}

	@Override
	public NavigableMap<Object, T> tailMap(Object fromKey, boolean inclusive) {
		return getValue().tailMap(fromKey, inclusive);
	}

	@Override
	public Comparator<? super Object> comparator() {
		return getValue().comparator();
	}

	@Override
	public SortedMap<Object, T> subMap(Object fromKey, Object toKey) {
		return getValue().subMap(fromKey, toKey);
	}

	@Override
	public SortedMap<Object, T> headMap(Object toKey) {
		return getValue().headMap(toKey);
	}

	@Override
	public SortedMap<Object, T> tailMap(Object fromKey) {
		return getValue().tailMap(fromKey);
	}

	@Override
	public Object firstKey() {
		return getValue().firstKey();
	}

	@Override
	public Object lastKey() {
		return getValue().lastKey();
	}

	@Override
	public int size() {
		return getValue().size();
	}

	@Override
	public boolean isEmpty() {
		return getValue().isEmpty();
	}

	@Override
	public boolean containsKey(Object key) {
		return getValue().containsKey(key);
	}

	@Override
	public boolean containsValue(Object value) {
		return getValue().containsValue(value);
	}

	@Override
	public T get(Object key) {
		return getValue().get(key);
	}

	@Override
	public T put(Object key, T value) {
		return getValue().put(key, value);
	}

	@Override
	public T remove(Object key) {
		return getValue().remove(key);
	}

	@Override
	public void putAll(Map<? extends Object, ? extends T> map) {
		getValue().putAll(map);
	}

	@Override
	public void clear() {
		getValue().clear();
	}

	@Override
	public Set<Object> keySet() {
		return getValue().keySet();
	}

	@Override
	public Collection<T> values() {
		return getValue().values();
	}

	@Override
	public Set<Map.Entry<Object, T>> entrySet() {
		return getValue().entrySet();
	}
}
