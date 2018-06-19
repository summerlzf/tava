package com.tuandai.tava;

import com.tuandai.tava.annotation.NonEmpty;
import com.tuandai.tava.constant.Code;
import com.tuandai.tava.helper.MapHelper;
import com.tuandai.tava.util.ObjectUtil;

import java.io.File;
import java.io.FileFilter;
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
	
	public static void test4() throws IOException {
		String str = "this is a test string with !~ 中文 ******";
		Encoder en = Base64.getEncoder();
		Decoder de = Base64.getDecoder();
		String msg = en.encodeToString(str.getBytes(StandardCharsets.UTF_8)), data = new String(de.decode(msg), StandardCharsets.UTF_8);
		System.out.println("msg: " + msg + "   str: " + data);
		File f = new File("");
		f.listFiles(new FileFilter() {
			@Override
			public boolean accept(File pathname) {
				return false;
			}
		});
	}

	public static void main(String[] args) {
		String s = ObjectUtil.create(String.class);
		System.out.println("s: " + s.length());
//		try {
//			test4();
//		} catch (IOException e) {
//			e.printStackTrace();
//		}
		System.out.println(Code.B.value());
	}

}
