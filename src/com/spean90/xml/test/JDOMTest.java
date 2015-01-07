package com.spean90.xml.test;


import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.jdom2.Document;
import org.jdom2.Element;
import org.jdom2.input.SAXBuilder;
import org.jdom2.output.EscapeStrategy;
import org.jdom2.output.Format;
import org.jdom2.output.XMLOutputter;

import com.spean90.xml.modal.Company;
import com.spean90.xml.modal.Department;

public class JDOMTest {
	public static void main(String[] args) {
		JDOMTest jdomTest = new JDOMTest();
		SAXBuilder saxBuilder = new SAXBuilder();
		Document document = null;
		try {
			document = saxBuilder.build("cfg/company.xml");
			Company company = jdomTest.parseXml(document);
			System.out.println(">>>>>>>>>>>>>>>");
			System.out.println(company.getDepartments().size());
			System.out.println(company.getDepartments().get(0).getManager());
			jdomTest.createXml(company);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void createXml(Company company) {
		Element companyElement = new Element("company");
		Document document = new Document(companyElement);
		List<Department> departments = company.getDepartments();
		for (Department department : departments) {
			Element departmentElement = new Element("department");
			departmentElement.setAttribute("id", department.getId());
			Element name = new Element("name");
			name.setText(department.getName());
			Element manager = new Element("manager");
			manager.setText("<描述><![CDATA[<查看是否转义保存>]]>");
			departmentElement.addContent(name);
			departmentElement.addContent(manager);
			companyElement.addContent(departmentElement);
			
		}
		
		
		//写出documnet到xml文件
		XMLOutputter xmlOutputter = new XMLOutputter();
		Format format = Format.getPrettyFormat();
		format.setEscapeStrategy(new EscapeStrategy() {
			@Override
			public boolean shouldEscape(char arg0) {
				return false;
			}
		});
		xmlOutputter.setFormat(format);
		try {
			xmlOutputter.output(document, new FileOutputStream(new File("cfg/company_jdom.xml")));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	
	public  Company parseXml(Document document) {
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
