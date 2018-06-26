package com.tuandai.tava.practise;

/**
 * Created by liuzifeng on 2018/6/26.
 */
public class CodeService {

	public int handle(String id, String name, int type) {
		if (id != null) {
			if (name != null && name.equals("tuandai")) {
				if (type == 1) {
					// code here ...
					System.out.println("magic comes");
					return 0;
				} else {
					return 3;
				}
			} else {
				return 2;
			}
		} else {
			return 1;
		}
	}

	public int handle0(String id, String name, int type) {
		if (id == null) {
			return 1;
		}
		if (!"tuandai".equals(name)) {
			return 2;
		}
		if (type != 1) {
			return 3;
		}
		// code here ...
		System.out.println("magic comes");
		return 0;
	}

	public int getCode() {
		return 0;
	}
}
