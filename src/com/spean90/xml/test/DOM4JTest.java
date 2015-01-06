package com.spean90.xml.test;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.DocumentHelper;
import org.dom4j.Element;
import org.dom4j.io.OutputFormat;
import org.dom4j.io.SAXReader;
import org.dom4j.io.XMLWriter;

import com.spean90.xml.modal.Company;
import com.spean90.xml.modal.Department;

public class DOM4JTest {

	public static void main(String[] args) {
		DOM4JTest dom4jTest = new DOM4JTest();
		SAXReader saxReader = new SAXReader();
		try {
			Document document = saxReader.read("cfg/company.xml");
			Company company = dom4jTest.parseDocument(document);
			System.out.println(company.getDepartments().size());
			System.out.println(company.getDepartments().get(0).getName());
			dom4jTest.createXml(company);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void createXml(Company company) {
		Document document = DocumentHelper.createDocument();
		Element element = document.addElement("company");
		List<Department> departments = company.getDepartments();
		for (Department department : departments) {
			Element element_department = element.addElement("department");
			//添加节点属性
			element_department.addAttribute("id", department.getId());
			//添加子节点、并设置文本内容
			element_department.addElement("name").setText(department.getName());
			element_department.addElement("manager").setText(department.getManager());
		}
		
		
		
		
		//生成文件
		//设置格式
		OutputFormat format = OutputFormat.createPrettyPrint();
		//设置xml的encoding属性；
		//format.setEncoding("GBK");
		File f = new File("cfg/company_dom4j.xml");
		FileOutputStream fout = null;
		XMLWriter writer = null;
		try {
			fout = new FileOutputStream(f);
			writer = new XMLWriter(fout,format);
			//设置不转义；默认转义
			writer.setEscapeText(false);
			writer.write(document);
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			try {
				fout.close();
				writer.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
	
	
	public Company parseDocument(Document document) {
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
