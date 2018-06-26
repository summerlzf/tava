package com.tuandai.tava.practise;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by liuzifeng on 2018/6/20.
 */
public class MainBox {

	private CodeService codeService = new CodeService();

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

	public boolean match(int mycode) {
		int code = codeService.getCode();
		return code > 0 && code == mycode;
	}

	public static void main(String[] args) {

		String[] a = {"1", "2", "3"};

		List<String> list1 = Arrays.asList(a);
		list1.remove("2"); // 抛出 UnsupportedOperationException 异常

		List<String> list2 = new ArrayList<>(Arrays.asList(a));
		list2.remove("2");
	}
}
