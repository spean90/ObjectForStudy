package com.spean90.webservice.test;

import javax.xml.ws.Endpoint;

import com.spean90.webservice.service.impl.MyService2Impl;
import com.spean90.webservice.service.impl.MyServiceImpl;

public class MyService {

	public static void main(String[] args) {
		String address = "http://localhost:8888/myws";
		String address2 = "http://localhost:8888/myws2";
		Endpoint.publish(address, new MyServiceImpl());
		Endpoint.publish(address2, new MyService2Impl());
		System.out.println("服务已启动");
	}
}
