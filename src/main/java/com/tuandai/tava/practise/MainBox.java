package com.tuandai.tava.practise;

/**
 * Created by liuzifeng on 2018/6/20.
 */
public class MainBox {

	public static void main(String[] args) {
		Apple a = new Apple(), b = new Apple();
		String x = "123", y = "123";
		System.out.println(a.hashCode());
		System.out.println(b.hashCode());
		System.out.println(x.hashCode());
		System.out.println(y.hashCode());
	}
}
