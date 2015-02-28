package com.spean90.schema.singleton;

public class Singleton {
	
	//私有化构造函数
	private Singleton() {
	}

	/**
	 * 懒汉模式，在使用时在创建实例，不是线程安全的，多线程时有可能创建多个实例；
	 */
//	private static Singleton singleton;
//	public static Singleton getInstance() {
//		if (singleton == null) {
//			singleton = new Singleton();
//		}
//		return singleton;
//	}
	
	/**
	 * 饿汉模式，在类加载时就创建实例，线程安全的；类加载比较慢；
	 */
	private static Singleton singleton = new Singleton();
	public static Singleton getInstance() {
		return singleton;
	}
}
