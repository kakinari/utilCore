package com.kakinari.core.datatype;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import com.kakinari.core.comparator.NameComparator;
import com.kakinari.core.datatype.interfaces.Param;
import com.kakinari.core.datatype.interfaces.ParamOption;

public abstract class ListUnit<T extends BaseUnit<?>> extends BaseUnit<List<T>> implements List<T> {
	private static final String DEFAULT_HTML_TAG = "tr";
	private static final String DEFAULT_HTML_CHIELD_TAG = "td";
	private static final String DEFAULT_XML_TAG = "Element";
	private static final String DEFAULT_XML_CHIELD_TAG = "Value";

	abstract protected void setListData(List<?> list);
	
	public ListUnit() {
		super(new ArrayList<T>());
		setTag(DEFAULT_HTML_TAG );
		setChildHtmlTag(DEFAULT_HTML_CHIELD_TAG);
		setXmlTag(DEFAULT_XML_TAG );
		setChildXmlTag(DEFAULT_XML_CHIELD_TAG);
	}

	public ListUnit(Collection<T> c) {
		super(new ArrayList<T>(c));
		setTag(DEFAULT_HTML_TAG );
		setChildHtmlTag(DEFAULT_HTML_CHIELD_TAG);
		setXmlTag(DEFAULT_XML_TAG );
		setChildXmlTag(DEFAULT_XML_CHIELD_TAG);
	}

	public ListUnit(int initialCapacity) {
		super(new ArrayList<T>(initialCapacity));
		setTag(DEFAULT_HTML_TAG );
		setChildHtmlTag(DEFAULT_HTML_CHIELD_TAG);
		setXmlTag(DEFAULT_XML_TAG );
		setChildXmlTag(DEFAULT_XML_CHIELD_TAG);
	}


	public ListUnit(Param param) {
		super(new ArrayList<T>(), param);
		setTag(DEFAULT_HTML_TAG );
		setChildHtmlTag(DEFAULT_HTML_CHIELD_TAG);
		setXmlTag(DEFAULT_XML_TAG );
		setChildXmlTag(DEFAULT_XML_CHIELD_TAG);
	}

	public ListUnit(ListUnit<T> list) {
		super(new ArrayList<T>(list));
		setTag(DEFAULT_HTML_TAG );
		setChildHtmlTag(DEFAULT_HTML_CHIELD_TAG);
		setXmlTag(DEFAULT_XML_TAG );
		setChildXmlTag(DEFAULT_XML_CHIELD_TAG);
	}

	public ListUnit(ListUnit<T> list, Param param) {
		super(new ArrayList<T>(list), param);
		setTag(DEFAULT_HTML_TAG );
		setChildHtmlTag(DEFAULT_HTML_CHIELD_TAG);
		setXmlTag(DEFAULT_XML_TAG );
		setChildXmlTag(DEFAULT_XML_CHIELD_TAG);
	}
	
	public ListUnit(List<?> list) {
		super(new ArrayList<T>());
		setListData(list);
		setTag(DEFAULT_HTML_TAG );
		setChildHtmlTag(DEFAULT_HTML_CHIELD_TAG);
		setXmlTag(DEFAULT_XML_TAG );
		setChildXmlTag(DEFAULT_XML_CHIELD_TAG);
	}

	public ListUnit(List<?> list, Param param) {
		super(new ArrayList<T>(), param);
		setListData(list);
		setTag(DEFAULT_HTML_TAG );
		setChildHtmlTag(DEFAULT_HTML_CHIELD_TAG);
		setXmlTag(DEFAULT_XML_TAG );
		setChildXmlTag(DEFAULT_XML_CHIELD_TAG);
	}
	
	@Override
	public List<T> getValue() {
		return super.getValue();
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
		for(T item : this) {
			if (! item.hasXmlTag())
				item.setXmlTag(getChildXmlTag());
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
		for(T item : this) {
			item.setTag(getChildHtmlTag());
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
		sb.append(getIndents()).append("[");
		boolean first = true;
		for(T item : this) {
			if (! first) sb.append(",");
			first = false;
			sb.append(getLineBreak());
			sb.append(item.toJSONString(indent+1, beautify));
		}
		sb.append(getLineBreak());
		sb.append(getIndents()).append("]");
		return sb.toString();
	}

	@Override
	public String toString() {
		StringBuffer sb = new StringBuffer();
		for(T item : this) {
			if (sb.length()> 0) sb.append(",");
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
		return getValue().isEmpty();
	}

	@Override
	public boolean contains(Object o) {
		return getValue().contains(o);
	}

	@Override
	public Iterator<T> iterator() {
		return getValue().iterator();
	}

	@Override
	public Object[] toArray() {
		return getValue().toArray();
	}

	public boolean add(T e) {
		return getValue().add(e);
	}

	@Override
	public boolean remove(Object o) {
		return getValue().remove(o);
	}

	public boolean containsAll(Collection<?> c) {
		return getValue().containsAll(c);
	}
	public boolean addAll(Collection<? extends T> c) {
		return getValue().addAll(c);
	}

	@Override
	public boolean addAll(int index, Collection<? extends T> c) {
		return getValue().addAll(index, c);
	}

	public boolean removeAll(Collection<?> c) {
		return getValue().removeAll(c);
	}

	public boolean retainAll(Collection<? > c) {
		return getValue().retainAll(c);
	}

	@Override
	public void clear() {
		getValue().clear();
	}

	public void add(int index, T element) {
		getValue().add(index, element);
	}

	@Override
	public T remove(int index) {
		return getValue().remove(index);
	}

	@Override
	public ListIterator<T> listIterator() {
		return getValue().listIterator();
	}

	@Override
	public ListIterator<T> listIterator(int index) {
		return getValue().listIterator(index);
	}

	@Override
	public List<T> subList(int fromIndex, int toIndex) {
		return getValue().subList(fromIndex, toIndex);
	}

	@Override
	public T get(int index) {
		return getValue().get(index);
	}

	@Override
	public T set(int index, T element) {
		return getValue().set(index, element);
	}

	@Override
	public <E> E[] toArray(E[] a) {
		return getValue().toArray(a);
	}

	@Override
	public int indexOf(Object o) {
		return getValue().indexOf(o);
	}

	@Override
	public int lastIndexOf(Object o) {
		return getValue().lastIndexOf(o);
	}

	public List<Object> toList() {
		List<Object> retval = new ArrayList<Object>();
		for(T unit : this) {
			if (unit instanceof TreeUnit)
				retval.add(((TreeUnit<?>)unit).toMap());
			else if (unit instanceof MapUnit)
				retval.add(((MapUnit<?>)unit).toMap());
			else if (unit instanceof ListUnit)
				retval.add(((ListUnit<?>)unit).toList());
			else
				retval.add(unit.getValue());
		}
		return retval;
	}
	
	public TreeDataUnit toMapUnit(Object[] label) {
		TreeDataUnit ret = new TreeDataUnit(new NameComparator(label));
		for (int i=0;i<label.length;i++)
			if (label[i] != null && label[i].toString().length()> 0)
				ret.put(label[i], get(i));
		return ret;
	}
}
