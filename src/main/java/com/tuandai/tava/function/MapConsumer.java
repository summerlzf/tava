package com.tuandai.tava.function;

@FunctionalInterface
public interface MapConsumer<K, V> {
	
	void accept(K key, V val);

}
