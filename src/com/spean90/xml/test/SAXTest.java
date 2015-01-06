package com.spean90.xml.test;

import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

import com.spean90.xml.modal.Company;


public class SAXTest {

	public static void main(String[] args) {
		SAXParserFactory saxParserFactory = SAXParserFactory.newInstance();
		try {
			SAXParser saxParser = saxParserFactory.newSAXParser();
			MySAXHandler mySAXHandler = new MySAXHandler();
			saxParser.parse("cfg/company.xml",mySAXHandler);
			Company company = mySAXHandler.getCompany();
			System.out.println(company.getDepartments().size());
			System.out.println(company.getDepartments().get(0).getName());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
