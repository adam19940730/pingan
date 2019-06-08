package com.linzhehang.proxy3;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class ActionInvocation {

	private Method method;
	private Object obj;
	private Object[] args;
	public Method getMethod() {
		return method;
	}
	public void setMethod(Method method) {
		this.method = method;
	}
	public Object getObj() {
		return obj;
	}
	public void setObj(Object obj) {
		this.obj = obj;
	}
	public Object[] getArgs() {
		return args;
	}
	public void setArgs(Object[] args) {
		this.args = args;
	}
	public ActionInvocation(Method method, Object obj, Object[] args) {
		super();
		this.method = method;
		this.obj = obj;
		this.args = args;
	}
	public Object invoke() throws Exception {
		return method.invoke(obj, args);
	}
	
	
}
