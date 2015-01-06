package com.spean90.xml.test;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

import com.spean90.xml.modal.Company;
import com.spean90.xml.modal.Department;

public class DOM4JTest {

	public static void main(String[] args) {
		SAXReader saxReader = new SAXReader();
		try {
			Document document = saxReader.read("cfg/company.xml");
			Company company = parseDocument(document);
			System.out.println(company.getDepartments().size());
			System.out.println(company.getDepartments().get(0).getName());
		} catch (DocumentException e) {
			e.printStackTrace();
		}
	}
	
	public static  Company parseDocument(Document document) {
		Company company = new Company();
		List<Department> departments = new ArrayList<Department>();
		company.setDepartments(departments);
		Element root = document.getRootElement();
		Iterator<Element> it = root.elementIterator();
		while(it.hasNext()) {
			Element element = it.next();
			Department department = new Department();
			department.setId(element.attribute("id").getText());
			department.setName(element.element("name").getText());
			department.setManager(element.element("manager").getText());
			departments.add(department);
			System.out.println(element.attribute("id").getText());
			System.out.println(element.element("name").getText());
			System.out.println(element.element("manager").getText());
		}

		return company;
	}
}
