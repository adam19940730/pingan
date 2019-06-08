package com.linzhehang.proxy2;

import java.lang.reflect.Proxy;

public class MyProxy {

	/*
	 * 第一版的问题就是动态代理难度过高，一般初学者难以使用，需要先进行封装后，减小使用的难度，增加通用性
	 */
	
	public Object getProxy(Object target) {
		// 创建类加载器，用于加载到时候由jvm动态地创建真实对象的字节码到系统内存中
		ClassLoader loader = MyProxy.class.getClassLoader();
		// 生成字节码数组，由jvm自动动态生成，无源代码，字节码表示的类也会同时自动实现（实例化）
		Class[] interfaces = target.getClass().getInterfaces();
		// 生成一个调用处理器，当使用代理对象调用真实方法时，会先去到调用处理器中的invoke方法，
		// 再由invoke方法决定是否执行真实方法，即动态代理的精髓就是代理对象决定了是否可以调用真实对象
		// 如经纪人决定了你是否可以见到刘德华一般
		MyHandler h = new MyHandler(target);
		Object proxy = (ICalc) Proxy.newProxyInstance(loader, interfaces, h);
		return proxy;
	}

}
