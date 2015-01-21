package com.spean90.webservice.test;

import org.apache.cxf.jaxws.endpoint.dynamic.JaxWsDynamicClientFactory;

public class TestCXFClient {

	public static void main(String[] args) {
		JaxWsDynamicClientFactory dcf = JaxWsDynamicClientFactory.newInstance();
		org.apache.cxf.endpoint.Client client = dcf.createClient("http://www.webxml.com.cn/WebServices/IpAddressSearchWebService.asmx?wsdl");
                Object[] objects;
		try {
			objects = client.invoke("getCountryCityByIp", "219.137.167.157");
			//输出调用结果
			System.out.println(objects[0].toString());
		} catch (Exception e) {
			e.printStackTrace();
		} 
	}
}
