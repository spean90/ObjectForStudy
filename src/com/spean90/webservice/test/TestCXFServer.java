//package com.spean90.webservice.test;
//
//import org.apache.cxf.endpoint.Server;
//import org.apache.cxf.jaxws.JaxWsServerFactoryBean;
//
//import com.spean90.webservice.service.impl.MyServiceImpl;
//
//public class TestCXFServer {
//	
//	public static void main(String[] args) {
//		JaxWsServerFactoryBean factory = new JaxWsServerFactoryBean();
//		factory.setAddress("http://localhost:8080/MyService");
//		factory.setServiceClass(MyServiceImpl.class);
//		Server server = factory.create();
//		server.start();
//	}
//
//}
