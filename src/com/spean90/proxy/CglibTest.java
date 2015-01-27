package com.spean90.proxy;

public class CglibTest {

	public static void main(String[] args) {
		CglibProxy proxy = new CglibProxy();
		Train t = (Train) proxy.getProxy(Train.class);
		t.move("222");
	}
}
