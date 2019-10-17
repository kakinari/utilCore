package com.kakinari.core.datatype;

import java.util.Collection;
import java.util.List;
import java.util.TreeMap;

import com.kakinari.core.datatype.interfaces.Param;

public class ListDataUnit extends ListUnit<BaseUnit<?>> {

	public ListDataUnit() {
		super();
	}

	public ListDataUnit(Collection<BaseUnit<?>> c) {
		super(c);
	}

	public ListDataUnit(int initialCapacity) {
		super(initialCapacity);
	}

	public ListDataUnit(ListUnit<BaseUnit<?>> list) {
		super(list);
	}

	public ListDataUnit(Param param) {
		super(param);
	}

	public ListDataUnit(ListUnit<BaseUnit<?>> list, Param param) {
		super(list, param);
	}

	public ListDataUnit(List<?> list) {
		super(list);
	}
	
	public ListDataUnit(List<?> list, Param param) {
		super(list, param);
	}

	@Override
	protected void setListData(List<?> list) {
		for (Object value : list) {
			if (value instanceof BaseUnit)
				add((BaseUnit<?>) value);
			else if (value instanceof TreeMap)
				add(new TreeDataUnit((TreeMap<?,?>)value));
		}
	}
	
}
