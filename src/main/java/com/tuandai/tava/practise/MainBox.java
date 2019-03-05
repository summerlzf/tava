package com.tuandai.tava.practise;

import com.sun.nio.zipfs.ZipInfo;

import java.math.BigDecimal;
import java.time.LocalDateTime;

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

	public static void testDecimal() {
		double x = 0.1, y = 0.2;
		System.out.println(x + y); // 0.30000000000000004

		BigDecimal i = BigDecimal.valueOf(0.1), j = BigDecimal.valueOf(0.2);
		System.out.println(i.add(j)); // 0.3

		BigDecimal a = new BigDecimal(1.2);
		BigDecimal b = new BigDecimal("1.2");
		BigDecimal c = BigDecimal.valueOf(1.2);
		System.out.println(a); // 1.1999999999999999555910790149937383830547332763671875
		System.out.println(b); // 1.2
		System.out.println(c); // 1.2
	}

	public static void main(String[] args) {

		System.out.println(System.getProperty("sun.boot.class.path")); // BootstrapClassLoader
		System.out.println(System.getProperty("java.ext.dirs")); // ExtClassLoader
		System.out.println(System.getProperty("java.class.path")); // AppClassLoader

		ClassLoader cl = User.class.getClassLoader(), cl1 = ZipInfo.class.getClassLoader();
		System.out.println(cl);
		System.out.println(cl.getParent());
		System.out.println(cl1);
		System.out.println(cl1.getParent());
		System.out.println(LocalDateTime.class.getClassLoader());
	}
}
