package com.linzhehang.myproxy;

public class C implements Interceptor {

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
		System.out.println("****************************");
		Object r = invocation.invoke();
		System.out.println("############################");
		return r;
	}

}
