package com.spean90.webservice.test;

import javax.xml.namespace.QName;

import org.apache.cxf.binding.soap.SoapMessage;
import org.apache.cxf.headers.Header;
import org.apache.cxf.interceptor.Fault;
import org.apache.cxf.phase.AbstractPhaseInterceptor;
import org.apache.cxf.phase.Phase;
import org.w3c.dom.Element;

public class MyInterceptor extends AbstractPhaseInterceptor<SoapMessage> {

	public MyInterceptor() {
		super(Phase.PRE_PROTOCOL);
		System.out.println("MyInterceptor().....done....");
	}

	@Override
	public void handleMessage(SoapMessage message) throws Fault {
		Header header = message.getHeader(new QName("user"));
		if (header!=null) {
			Element element = (Element) header.getObject();
			String name = element.getElementsByTagName("name").item(0).getTextContent();
			String password = element.getElementsByTagName("password").item(0).getTextContent();
			if (name.equals("spean") && password.equals("123456")) {
				System.out.println("..验证成功、通过拦截器...");
				return;
			}
		}
		System.out.println("没有通过拦截器....");
		throw new Fault(new RuntimeException("请求需要一个正确的用户名和密码...."));
	}

}
