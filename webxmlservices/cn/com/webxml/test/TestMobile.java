package cn.com.webxml.test;

import cn.com.webxml.MobileCodeWS;
import cn.com.webxml.MobileCodeWSSoap;

public class TestMobile {

	public static void main(String[] args) {
		
		MobileCodeWS factory = new MobileCodeWS();
		MobileCodeWSSoap mobileCodeWSSoap = factory.getMobileCodeWSSoap();
		String s =mobileCodeWSSoap.getMobileCodeInfo("13850857602", "");
		System.out.println(s);
	}
}
