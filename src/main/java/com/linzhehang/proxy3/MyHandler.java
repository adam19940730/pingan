package com.linzhehang.proxy3;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.util.Arrays;

public class MyHandler implements InvocationHandler {

	private Object target;
	private Interceptor intercept;
	
	public MyHandler(Object target,Interceptor intercept) {
		this.target = target;
		this.intercept = intercept;
	}
	
	@Override
	public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
		Object r = intercept.intercept(new ActionInvocation(method, target, args));
		//当调用真实方法后，会进入到该方法，判断并执行分发。类似于拦截器，不过具体如何取决于代码
		return r;
	}

}
