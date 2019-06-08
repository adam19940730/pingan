package com.linzhehang.proxy1;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.util.Arrays;

public class MyHandler implements InvocationHandler {

	private Object target;
	
	public MyHandler(Object target) {
		this.target = target;
	}
	
	@Override
	public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
		System.out.println(method.getName()+"开始，参数是：" + Arrays.toString(args));
		for (Object obj : args) {
			if(obj instanceof Integer) {
				Integer i = (Integer) obj;
				if(i<1) {
					throw new RuntimeException("输入参数必须大于0");
				}
			}
		}
		
		//当调用真实方法后，会进入到该方法，判断并执行分发。类似于拦截器，不过具体如何取决于代码
		Object r = method.invoke(target, args);
		System.out.println(method.getName()+"结束，结果是：" + r);
		return r;
	}

}
