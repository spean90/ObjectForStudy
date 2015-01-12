package com.spean90.webservice.test;

import javax.xml.ws.Endpoint;

import com.spean90.webservice.service.impl.MyServiceImpl;

public class MyService {

	public static void main(String[] args) {
		String address = "http://localhost:8888/myws";
		Endpoint.publish(address, new MyServiceImpl());
	}
}
