package com.tuandai.tava.constant;

public enum Code {
	
	A(1),
	B(2),
	C(3);
	
	private int val;
	
	Code(int val) {
		this.val = val;
	}
	
	public int value() {
		return val;
	}

}
