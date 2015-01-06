package com.spean90.xml.test;

import java.util.ArrayList;
import java.util.List;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import com.spean90.xml.modal.Company;
import com.spean90.xml.modal.Department;

public class MySAXHandler extends DefaultHandler {

	String value = "";
	private Department department;
	private List<Department> departments = new ArrayList<Department>();
	private Company company = null;
	public Company getCompany() {
		return company;
	}

	public void setCompany(Company company) {
		this.company = company;
	}

	/**
	 * 遍历xml结束标签
	 */
	@Override
	public void endElement(String uri, String localName, String qName)
			throws SAXException {
		super.endElement(uri, localName, qName);
		if(qName.equals("department")) {
			System.out.println("======结束遍历部门======");
			departments.add(department);
			department = null;
		}else if (qName.equals("name")) {
			department.setName(value);
		}else if (qName.equals("manager")) {
			department.setManager(value);
		}else if (qName.equals("company")) {
			company.setDepartments(departments);
		}
	}

	/**
	 * 用来遍历xml的开始标签
	 */
	@Override
	public void startElement(String uri, String localName, String qName,
			Attributes attributes) throws SAXException {
		super.startElement(uri, localName, qName, attributes);
		if(qName.equals("department")) {
			department = new Department();
			System.out.println("======开始遍历部门======");
			System.out.println(attributes.getValue("id"));
			department.setId(attributes.getValue("id"));
		}else if(!qName.equals("company")) {  //过来根节点；输出其他节点
			System.out.print(qName);
		}else {
			company = new Company();
		}
		
	}

	/**
	 * 解析开始
	 */
	@Override
	public void startDocument() throws SAXException {
		// TODO Auto-generated method stub
		super.startDocument();
		System.out.println("解析开始");
	}
	
	/**
	 *解析结束
	 */
	@Override
	public void endDocument() throws SAXException {
		// TODO Auto-generated method stub
		super.endDocument();
		System.out.println("解析结束");
	}
	
	/**
	 * @param ch 就是整个文档的内容；
	 * @param start 本次调用的开始；
	 * @param length 本次调用的长度；
	 */
	@Override
	public void characters(char[] ch, int start, int length)
			throws SAXException {
		super.characters(ch, start, length);
		value = new String(ch, start, length);
		//过了xml 空格和换行的节点
		if (!value.trim().equals("")) {
			System.out.println(" : "+value);
		}
		
	}
}
