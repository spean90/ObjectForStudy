package cn.com.webxml.mobile.test;

import cn.com.webxml.mobile.MobileCodeWS;
import cn.com.webxml.mobile.MobileCodeWSSoap;

public class TestMobile {

	public static void main(String[] args) {
		
		MobileCodeWS factory = new MobileCodeWS();
		MobileCodeWSSoap mobileCodeWSSoap = factory.getMobileCodeWSSoap();
		String s =mobileCodeWSSoap.getMobileCodeInfo("13850857602", "");
		System.out.println(s);
	}
}
