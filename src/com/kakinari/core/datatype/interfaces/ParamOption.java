package com.kakinari.core.datatype.interfaces;

import java.util.HashMap;
import java.util.Map;

public class ParamOption extends HashMap<String, String> {
	private static final long serialVersionUID = 1L;

	public ParamOption() {
		super();
	}

	public ParamOption(Map<String, String> m) {
		super(m);
	}

}
