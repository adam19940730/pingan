package com.linzhehang.proxy3;


import java.lang.reflect.Proxy;

import org.junit.Test;

public class AppTest {

	
	
	@Test
	public void test() throws Exception {
		//创建真实对象
		ICalc c = new CalcImpl();
		MyProxy mp = new MyProxy();
		ICalc proxy = (ICalc) mp.getProxy(c,new A());
		int add = proxy.add(1, 1);
		System.out.println(add);
		
	}
	
}
