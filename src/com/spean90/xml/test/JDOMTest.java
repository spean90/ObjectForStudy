package com.spean90.xml.test;


import java.util.ArrayList;
import java.util.List;

import org.jdom2.Document;
import org.jdom2.Element;
import org.jdom2.input.SAXBuilder;

import com.spean90.xml.modal.Company;
import com.spean90.xml.modal.Department;

public class JDOMTest {
	public static void main(String[] args) {
		SAXBuilder saxBuilder = new SAXBuilder();
		Document document = null;
		try {
			document = saxBuilder.build("cfg/company.xml");
			Company company = parseDocument(document);
			System.out.println(">>>>>>>>>>>>>>>");
			System.out.println(company.getDepartments().size());
			System.out.println(company.getDepartments().get(0).getManager());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public static  Company parseDocument(Document document) {
		Company company = new Company();
		List<Department> departments = new ArrayList<Department>();
		company.setDepartments(departments);
		Element root = document.getRootElement();
		List<Element> children = root.getChildren();
		System.out.println(children.size());
		for (Element element : children) {
			Department department = new Department();
			//获取节点的属性
			System.out.println(element.getAttributeValue("id"));
			department.setId(element.getAttributeValue("id"));
			//获取节点的子节点的节点名和值
			List<Element>nodes = element.getChildren();
			for (Element node : nodes) {
				System.out.println(node.getName()+" : "+node.getValue());
				if(node.getName().equals("name")) {
					department.setName(node.getValue());
				}
				if(node.getName().equals("manager")) {
					department.setManager(node.getValue());
				}
			}
			departments.add(department);
		}
		return company;
	}
	
}
