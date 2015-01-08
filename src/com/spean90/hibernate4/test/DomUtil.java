package com.spean90.hibernate4.test;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import org.dom4j.Document;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

public class DomUtil {
	public static void main(String[] args) {
		Map<String, String> m = DomUtil.getDataSourceInfoByServerCode("aiyounet_dc2_s1");
		System.out.println(m.get("username"));
	}

	
	public static Map<String, String> getDataSourceInfoByServerCode(String serverCode) {
		Map<String, String> info = new HashMap<String, String>();
		SAXReader saxReader = new SAXReader();
		try {
			Document document = saxReader.read("cfg/xml/datasource.xml");
			Element root = document.getRootElement();
			Iterator<Element> it = root.elementIterator();
			while(it.hasNext()) {
				Element bean = it.next();
				if (bean.attribute("id").getText().trim().equals(serverCode)) {
					Element propertys = bean.element("property").element("bean");
					Iterator<Element> its = propertys.elementIterator();
					while(its.hasNext()) {
						Element property = its.next();
						String name = property.attribute("name").getText().trim();
						String value = property.attribute("value").getText().trim();
						if ("driverClassName".equals(name)) {
							info.put("driverClassName",value );
						}else if("url".equals(name)) {
							info.put("url",value );
						}else if("username".equals(name)) {
							info.put("username",value );
						}else if("password".equals(name)) {
							info.put("password",value );
						}
					}
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
			info = null;
		}
		return info;
	}
}
