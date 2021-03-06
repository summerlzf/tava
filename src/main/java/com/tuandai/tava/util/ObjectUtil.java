package com.tuandai.tava.util;

public class ObjectUtil {

	public static <T> T create(Class<T> clazz) {
		try {
			return clazz == null ? null : clazz.newInstance();
		} catch (InstantiationException | IllegalAccessException e) {
		}
		return null;
	}

}
