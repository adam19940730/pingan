package com.linzhehang.proxy3;

import java.lang.reflect.Proxy;

public class MyProxy {
	
	/*
	 * 第二版的问题是在调用处理器的invoke方法中作者写死了功能，而作者并不知道用户以后会写什么功能，
	 * 因此invoke中的代码不可以写死，必须留给后来的用户修改的余地，这里留下一个开放的接口，
	 * 后续用户只要实现这个接口，就可以重写其中的方法，实现用户本身的业务逻辑。
	 */
	
	public Object getProxy(Object target,Interceptor intercept) {
		// 创建类加载器，用于加载到时候由jvm动态地创建真实对象的字节码到系统内存中
		ClassLoader loader = MyProxy.class.getClassLoader();
		// 生成字节码数组，由jvm自动动态生成，无源代码，字节码表示的类也会同时自动实现（实例化）
		Class[] interfaces = target.getClass().getInterfaces();
		// 生成一个调用处理器，当使用代理对象调用真实方法时，会先去到调用处理器中的invoke方法，
		// 再由invoke方法决定是否执行真实方法，即动态代理的精髓就是代理对象决定了是否可以调用真实对象
		// 如经纪人决定了你是否可以见到刘德华一般
		MyHandler h = new MyHandler(target,intercept);
		Object proxy = (ICalc) Proxy.newProxyInstance(loader, interfaces, h);
		return proxy;
	}

}
