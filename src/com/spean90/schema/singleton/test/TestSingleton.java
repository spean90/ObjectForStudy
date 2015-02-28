package com.spean90.schema.singleton.test;

import org.junit.Test;

import com.spean90.schema.singleton.Singleton;

public class TestSingleton {

	@Test
	public void testGetInstance() {
		Singleton singleton1 = Singleton.getInstance();
		Singleton singleton2 = Singleton.getInstance();
		System.out.println(singleton1 == singleton2);
	}
}
