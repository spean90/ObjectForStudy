package com.spean90.xml;


import java.util.List;

import org.jdom2.Document;
import org.jdom2.Element;
import org.jdom2.input.SAXBuilder;

public class JDOMTest {
	public static void main(String[] args) {
		SAXBuilder saxBuilder = new SAXBuilder();
		Document document = null;
		try {
			document = saxBuilder.build("cfg/company.xml");
			Element root = document.getRootElement();
			List<Element> children = root.getChildren();
			System.out.println(children.size());
			for (Element element : children) {
				//获取节点的属性
				System.out.println(element.getAttributeValue("id"));
				//获取节点的子节点的节点名和值
				List<Element>nodes = element.getChildren();
				for (Element node : nodes) {
					System.out.println(node.getName()+" : "+node.getValue());
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
