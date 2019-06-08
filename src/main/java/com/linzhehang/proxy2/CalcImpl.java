package com.linzhehang.proxy2;

import java.io.Serializable;

public class CalcImpl implements ICalc{

	@Override
	public int add(int a, int b) {
		int r = a + b;
		System.out.println("CalcImpl.add()");
		return r;
	}

	@Override
	public int sub(int a, int b) {
		int r = a - b;
		System.out.println("CalcImpl.sub()");
		return r;
	}

	@Override
	public int mul(int a, int b) {
		int r = a * b;
		System.out.println("CalcImpl.mul()");
		return r;
	}

	@Override
	public int div(int a, int b) {
		int r = a / b;
		System.out.println("CalcImpl.div()");
		return r;
	}

	@Override
	public int mod(int a, int b) {
		int r = a % b;
		System.out.println("CalcImpl.div()");
		return r;
	}

}
