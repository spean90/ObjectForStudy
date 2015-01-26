package com.spean90.webservice.service.impl;

import javax.jws.WebService;

import com.spean90.webservice.service.IMyService2;

@WebService
public class MyService2Impl implements IMyService2 {
	
	public MyService2Impl() {
		System.out.println("MyService2Impl()...done....");
	}

	@Override
	public int multiply(int a, int b) {
		return a*b;
	}

	@Override
	public int division(int a, int b) {
		return a/b;
	}

}
