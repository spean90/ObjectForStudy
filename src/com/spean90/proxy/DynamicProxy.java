package com.spean90.proxy;

import java.lang.reflect.Proxy;

public class DynamicProxy {
	
	public static void main(String[] args) {
		/**
		 * jdk动态代理、被代理类必须实现了某些接口；没有实现接口的类是不能被代理的、
		 */
		Car car = new Car();
		Class clazz = car.getClass();
		ProxyHandler h = new ProxyHandler(car);
		Moveable proxy = (Moveable) Proxy.newProxyInstance(clazz.getClassLoader(), clazz.getInterfaces(), h);
		proxy.move("123");
	}
}
