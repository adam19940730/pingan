package com.linzhehang.proxy3;

public interface Interceptor {

	void init();

	void destory();

	Object intercept(ActionInvocation actionInvocation) throws Exception;

}
