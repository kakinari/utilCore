package com.kakinari.core.comparator;

import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Set;

public class NameComparator implements Comparator<Object> {
	private String[] list;

	public NameComparator(Object[] namelist) {
		ArrayList<String> al = new ArrayList<String>();
		if (namelist != null)
			for(Object name : namelist)
				al.add(name.toString());
		this.list = al.toArray(new String[0]);
	}

	public NameComparator(Set<Object> nameset) {
		ArrayList<String> al = new ArrayList<String>();
		if (nameset != null)
			for(Object name : nameset)
				al.add(name.toString());
		this.list = al.toArray(new String[0]);
	}

	public NameComparator(ResultSet result) {
		ArrayList<String> al = new ArrayList<String>();
		try {
			ResultSetMetaData metadata = result.getMetaData();
			for (int pos=1;pos <= metadata.getColumnCount(); pos++)
				al.add(metadata.getColumnLabel(pos));
		} catch (SQLException e) {}
		this.list = al.toArray(new String[0]);
	}

	@Override
	public int compare(Object arg0, Object arg1) {
		if (arg0.equals(arg1))
			return 0;
		for (String name : list) {
			if (name.equals(arg0.toString())) return -1;
			if (name.equals(arg1.toString())) return 1;
		}
		return arg0.toString().compareTo(arg1.toString());
	}
}
