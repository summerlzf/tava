package com.tuandai.tava.practise;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by liuzifeng on 2018/6/20.
 */
public class MainBox {

	/** 直接使用String的+号进行字符串拼接（效率低） */
	private static void stringConcat1(int n) {
		String s = "";
		long l = System.currentTimeMillis();
		for(int i = 0; i < n; i++) {
			s += "hello world";
		}
		System.out.println("stringConcat1: " + (System.currentTimeMillis() - l));
	}

	/** 使用StringBuilder.append()方法进行拼接（效率高） */
	private static void stringConcat2(int n) {
		StringBuilder sb = new StringBuilder();
		long l = System.currentTimeMillis();
		for(int i = 0; i < n; i++) {
			sb.append("hello world");
		}
		System.out.println("stringConcat2: " + (System.currentTimeMillis() - l));
	}

	public static void main(String[] args) {
		List<String> list = new ArrayList<>();
		list.add("1");
		list.add("2");
		list.add("3");

		list.removeIf(e -> "1".equals(e) || "2".equals(e));

		System.out.println(list);
	}
}
