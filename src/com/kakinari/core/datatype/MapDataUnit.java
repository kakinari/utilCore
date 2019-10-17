package com.kakinari.core.datatype;

import java.util.HashMap;
import java.util.Map;
import com.kakinari.core.datatype.interfaces.Param;

public class MapDataUnit extends MapUnit<BaseUnit<?>> {

	public MapDataUnit() {
		super(new HashMap<Object, BaseUnit<?>>());
	}

	public MapDataUnit(MapDataUnit  map) {
		super(map, map.getParam());
	}

	public MapDataUnit(Map<Object, ? extends Object> map) {
		super(new HashMap<Object, BaseUnit<?>>());
		setMapValue(map);
	}

	public MapDataUnit(Map<Object, ? extends Object> map, Param param) {
		super(new HashMap<Object, BaseUnit<?>>(), param);
		setMapValue(map);
	}

	public Map<Object, ?> toMapData() {
		return super.toMapData(new HashMap<Object, Object>());
	}

	@Override
	protected void setMapValue(Map<?, ?> mapdata) {
	}
}
