package cn.com.webxml.test;

import cn.com.webxml.ArrayOfString;
import cn.com.webxml.MobileCodeWSSoap;

public class TestMobile {

	public static void main(String[] args) {
		
		MobileCodeWSSoap factory = new MobileCodeWSSoap() {
			
			@Override
			public String getMobileCodeInfo(String mobileCode, String userID) {
				// TODO Auto-generated method stub
				return null;
			}
			
			@Override
			public ArrayOfString getDatabaseInfo() {
				// TODO Auto-generated method stub
				return null;
			}
		};
	}
}
