package com.kakinari.core.datatype;

import java.util.Comparator;
import java.util.Map;
import java.util.TreeMap;

import com.kakinari.core.datatype.interfaces.Param;

public class TreeDataUnit extends TreeUnit<BaseUnit<?>> {

	public TreeDataUnit() {
		super();
	}

	public TreeDataUnit(Comparator<Object> comparator, Param param) {
		super(comparator, param);
	}

	public TreeDataUnit(Param param) {
		super(param);
	}

	public TreeDataUnit(TreeMap<?, ?> tree, Param param) {
		super(tree, param);
	}

	public TreeDataUnit(TreeUnit<BaseUnit<?>> tree, Param param) {
		super(tree, param);
	}

	public TreeDataUnit(Comparator<Object> comparator) {
		super(comparator);
	}

	public TreeDataUnit(TreeUnit<BaseUnit<?>> tree) {
		super(tree);
	}

	public TreeDataUnit(TreeMap<?, ?> table) {
		super(table);
	}

	@Override
	protected void setMapValue(Map<?, ?> mapdata) {
	}
}
