package com.spean90.webservice.service.impl;

import javax.jws.WebService;

import com.spean90.webservice.service.IMyService;

@WebService(endpointInterface="com.spean90.webservice.service.IMyService")
public class MyServiceImpl implements IMyService {

	@Override
	public int add(int a, int b) {
		return a+b;
	}

	@Override
	public int minus(int a, int b) {
		return a-b;
	}

}
