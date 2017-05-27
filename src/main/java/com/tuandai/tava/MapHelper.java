package com.tuandai.tava;

import java.util.Map;
import java.util.Map.Entry;

import com.tuandai.tava.function.MapConsumer;

public class MapHelper<K, V> {
	
	private Map<K, V> map;
	
	public MapHelper(Map<K, V> map) {
		this.map = map;
	}
	
	public void each(MapConsumer<K, V> mc) {
		for(Entry<K, V> en : map.entrySet()) {
			mc.accept(en.getKey(), en.getValue());
		}
	}

}
