package com.linzhehang.myproxy;

public class A implements Interceptor {

	@Override
	public void init() {
		// TODO Auto-generated method stub

	}

	@Override
	public void destory() {
		// TODO Auto-generated method stub

	}

	@Override
	public Object intercept(ActionInvocation invocation) throws Exception {
		System.out.println("111111111111111111111111111a");
		Object r = invocation.invoke();
		System.out.println("222222222222222222222222222b");
		return r;
	}

}
