package com.linzhehang.myproxy;

public interface Interceptor {

	void init();

	void destory();

	Object intercept(ActionInvocation actionInvocation) throws Exception;

}
