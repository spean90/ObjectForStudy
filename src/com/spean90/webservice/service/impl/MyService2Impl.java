package com.spean90.webservice.service.impl;

import javax.jws.WebService;

import com.spean90.webservice.service.IMyService2;

@WebService(endpointInterface="com.spean90.webservice.service.IMyService2")
public class MyService2Impl implements IMyService2 {

	@Override
	public int multiply(int a, int b) {
		return a*b;
	}

	@Override
	public int division(int a, int b) {
		return a/b;
	}

}
