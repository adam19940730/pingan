package com.linzhehang.myproxy;


import java.io.BufferedReader;
import java.io.FileReader;
import java.io.Reader;
import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

public class AppTest {

	
	
	@Test
	public void test() throws Exception {
		//创建真实对象
		ICalc target = new CalcImpl();
		MyProxy mp = new MyProxy();
		ICalc proxy = (ICalc) mp.getProxy(target);
		int add = proxy.add(1, 1);
		System.out.println(add);
		
	}
	
}
