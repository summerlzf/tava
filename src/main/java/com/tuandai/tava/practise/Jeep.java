package com.tuandai.tava.practise;

public class Jeep {

	private float oil;
	private float cost;

	/** 运行（产生油耗） */
	public void run(float miles) {
		oil -= miles * 0.1;
	}

	/** 加油 */
	public void addOil(float oil) {
		this.oil += oil;
		cost += oil * 8;
	}

	/** 还能走多远 */
	public float canRun() {
		return oil * 10;
	}

	/** 花了多少钱 */
	public float spent() {
		return cost;
	}
}
