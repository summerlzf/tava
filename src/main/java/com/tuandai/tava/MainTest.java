package com.tuandai.tava;

import com.tuandai.tava.annotation.NonEmpty;
import sun.misc.BASE64Decoder;
import sun.misc.BASE64Encoder;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.*;
import java.util.Base64.Decoder;
import java.util.Base64.Encoder;
import java.util.function.Consumer;

public class MainTest {
	
	public static void test1() {
		Arrays.asList("1", "2", "3").forEach((e) -> System.out.println(e));
		Arrays.asList("1", "2", "3").forEach(new Consumer<String>() {

			@Override
			public void accept(String t) {
				System.out.println(t);
			}
		});
		Arrays.asList("1", "2", "3").sort((e1, e2) -> e1.compareTo(e2));
	}
	
	public static void test2() {
		@NonEmpty
		String s = null;
		System.out.println(s);
		Optional<String> str = Optional.ofNullable("123");
		System.out.println(str.get());
	}
	
	public static void test3() {
		Map<String, String> map = new HashMap<>();
		map.put("a", "x");
		map.put("b", "y");
		map.put("c", "z");
//		System.out.println(map);
		MapHelper<String, String> m = new MapHelper<>(map);
		m.each((k, v) -> System.out.println(k + ": " + v));
		System.out.println(map);
	}
	
	@SuppressWarnings("restriction")
	public static void test4() throws IOException {
		String str = "this is a test string with !~ 中文 ******";
		BASE64Encoder encoder = new BASE64Encoder();
		BASE64Decoder decoder = new BASE64Decoder();
		Encoder en = Base64.getEncoder();
		Decoder de = Base64.getDecoder();
		String msg1 = encoder.encode(str.getBytes(StandardCharsets.UTF_8)), s1 = new String(decoder.decodeBuffer(msg1), StandardCharsets.UTF_8);
		String msg2 = en.encodeToString(str.getBytes(StandardCharsets.UTF_8)), s2 = new String(de.decode(msg2), StandardCharsets.UTF_8);
		System.out.println("msg1: " + msg1 + "   s1: " + s1);
		System.out.println("msg2: " + msg2 + "   s1: " + s2);
	}

	public static void main(String[] args) {
		try {
			test4();
		} catch (IOException e) {
			e.printStackTrace();
		}
		System.out.println(Code.B.value());
	}

}
