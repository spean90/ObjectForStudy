package com.spean90.webservice.test;

import java.net.URL;

import javax.xml.namespace.QName;
import javax.xml.ws.Service;

import com.spean90.webservice.service.IMyService;

public class TestMyServiceClient {

	public static void main(String[] args) {
		try {
			//创建访问wsdl服务地址的URL
			URL url = new URL("http://localhost:8080/myws?wsdl");
			//通过QName指明服务的具体信息
            QName sName = new QName("http://impl.service.webservice.spean90.com/", "MyServiceImplService");
            //创建服务
            Service service = Service.create(url, sName);
            //实现接口
            IMyService ms = service.getPort(IMyService.class);
            System.out.println(ms.add(12, 13));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
