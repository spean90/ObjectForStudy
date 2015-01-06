package com.spean90.xml.test;

import java.io.File;
import java.util.List;

import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Result;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerConfigurationException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.sax.SAXTransformerFactory;
import javax.xml.transform.sax.TransformerHandler;
import javax.xml.transform.stream.StreamResult;

import org.xml.sax.helpers.AttributesImpl;

import com.spean90.xml.modal.Company;
import com.spean90.xml.modal.Department;


public class SAXTest {

	public static void main(String[] args) {
		SAXTest saxTest = new SAXTest();
		Company company = saxTest.paserXml();
		System.out.println(company.getDepartments().size());
		saxTest.createXml(company);
	}
	
	public Company paserXml() {
		SAXParserFactory saxParserFactory = SAXParserFactory.newInstance();
		Company company = null;
		try {
			SAXParser saxParser = saxParserFactory.newSAXParser();
			MySAXHandler mySAXHandler = new MySAXHandler();
			saxParser.parse("cfg/company.xml",mySAXHandler);
			company = mySAXHandler.getCompany();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return company;
	}
	
	public void createXml(Company company) {
		//1.创建SAXtransformFactory对象
		SAXTransformerFactory tff =  (SAXTransformerFactory) SAXTransformerFactory.newInstance();
		//2.创建TransformerHandler对象
		TransformerHandler handler = null;
		try {
			handler = tff.newTransformerHandler();
			//3.通过handler对象创建transform对象
			Transformer tf = handler.getTransformer();
			//4.通过transform对象设置xml的属性；编码、换行；
			tf.setOutputProperty(OutputKeys.ENCODING, "UTF-8");
			tf.setOutputProperty(OutputKeys.INDENT, "yes");
			//5.创建result对象
			File f = new File("cfg/company_sax.xml");
			if (!f.exists()) {
				f.createNewFile();
			}
			Result result = new StreamResult(f);
			//6.关联handler与result
			handler.setResult(result);
			//7.xml文件内容编写
			handler.startDocument();
			AttributesImpl atts = new AttributesImpl();
			handler.startElement("", "localName", "company", atts);
			List<Department> departments = company.getDepartments();
			for (Department department : departments) {
				atts.clear();
				atts.addAttribute("", "", "id", "", department.getId());
				handler.startElement("", "", "department", atts);
				//添加name节点
				atts.clear();
				handler.startElement("", "", "name", atts);
				handler.characters(department.getName().toCharArray(), 0, department.getName().length());
				handler.endElement("", "", "name");
				//添加manager节点
				atts.clear();
				handler.startElement("", "", "manager", atts);
				handler.characters(department.getManager().toCharArray(), 0, department.getManager().length());
				handler.endElement("", "", "manager");
				
				handler.endElement("", "", "department");
			}
			handler.endElement("", "", "company");
			handler.endDocument();
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
