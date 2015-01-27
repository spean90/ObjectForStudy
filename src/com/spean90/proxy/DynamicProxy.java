package com.spean90.proxy;

import java.lang.reflect.Proxy;

public class DynamicProxy {
	
	public static void main(String[] args) {
		Car car = new Car();
		Class clazz = car.getClass();
		ProxyHandler h = new ProxyHandler(car);
		Moveable proxy = (Moveable) Proxy.newProxyInstance(clazz.getClassLoader(), clazz.getInterfaces(), h);
		proxy.move("123");
	}
}
