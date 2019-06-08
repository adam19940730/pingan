package com.linzhehang.myproxy;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.Reader;
import java.lang.reflect.Proxy;
import java.util.ArrayList;
import java.util.List;

public class MyProxy {

	/*
	 * 第三版的问题在于无法同时使用多个动态代理（拦截器），如struts2的拦截器默认有19个，层层拦截
	 */

	public Object getProxy(Object target, Interceptor intercept) {
		// 创建类加载器，用于加载到时候由jvm动态地创建真实对象的字节码到系统内存中
		ClassLoader loader = MyProxy.class.getClassLoader();
		// 生成字节码数组，由jvm自动动态生成，无源代码，字节码表示的类也会同时自动实现（实例化）
		Class[] interfaces = target.getClass().getInterfaces();
		// 生成一个调用处理器，当使用代理对象调用真实方法时，会先去到调用处理器中的invoke方法，
		// 再由invoke方法决定是否执行真实方法，即动态代理的精髓就是代理对象决定了是否可以调用真实对象
		// 如经纪人决定了你是否可以见到刘德华一般
		MyHandler h = new MyHandler(target, intercept);
		Object proxy = Proxy.newProxyInstance(loader, interfaces, h);
		return proxy;
	}

	public Object getProxy(Object proxy) throws Exception {
		List<Interceptor> Interceptors = new ArrayList<Interceptor>();
		Reader in = new FileReader("src/main/resources/lin.txt");
		BufferedReader br = new BufferedReader(in);
		String line = null;
		while ((line = br.readLine()) != null) {
			Interceptors.add((Interceptor) Class.forName(line).newInstance());
		}
		for (int i = Interceptors.size() - 1; i >= 0; i--) {
			proxy = getProxy(proxy, Interceptors.get(i));
		}
		return proxy;
	}

}
