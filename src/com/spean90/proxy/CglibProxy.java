package com.spean90.proxy;

import java.lang.reflect.Method;

import org.springframework.cglib.proxy.Enhancer;
import org.springframework.cglib.proxy.MethodInterceptor;
import org.springframework.cglib.proxy.MethodProxy;

public class CglibProxy implements MethodInterceptor {

	private Enhancer enhance = new Enhancer();
	
	public Object getProxy(Class clazz) {
		//设置创建类的子类
		enhance.setSuperclass(clazz);
		enhance.setCallback(this);
		return enhance.create();
	}
	
	@Override
	public Object intercept(Object obj, Method m, Object[] args,
			MethodProxy proxy) throws Throwable {
		System.out.println("开始调用...");
		//调用父类的方法
		proxy.invokeSuper(obj, args);
		
		System.out.println("结束调用...");
		return null;
	}

}
