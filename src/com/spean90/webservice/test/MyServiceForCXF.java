package com.spean90.webservice.test;

import javax.xml.ws.Endpoint;

import org.apache.cxf.interceptor.LoggingInInterceptor;
import org.apache.cxf.interceptor.LoggingOutInterceptor;
import org.apache.cxf.jaxws.EndpointImpl;

import com.spean90.webservice.service.impl.MyService2Impl;
import com.spean90.webservice.service.impl.MyServiceImpl;

public class MyServiceForCXF {

	public static void main(String[] args) {
		String address2 = "http://localhost:8888/myws2";
		Endpoint endpoint = Endpoint.publish(address2, new MyService2Impl());
		EndpointImpl endpointImpl = (EndpointImpl) endpoint;
		//cxf 服务器入拦截器、添加日志拦截、查看接收到的数据内容
		endpointImpl.getInInterceptors().add(new LoggingInInterceptor());
		//cxf 服务器出拦截器、添加日志拦截、查看发送的数据内容
		endpointImpl.getOutInterceptors().add(new LoggingOutInterceptor());
		endpointImpl.getInInterceptors().add(new MyInterceptor());
		System.out.println("服务已启动");
	}
}
