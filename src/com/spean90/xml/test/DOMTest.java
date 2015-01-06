package com.spean90.xml.test;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import com.spean90.xml.modal.Company;
import com.spean90.xml.modal.Department;

public class DOMTest {

	public static void main(String[] args) {
		DOMTest domTest = new DOMTest();
		
		Company company = new Company();
		List<Department> departments = new  ArrayList<Department>();
		Department department = new Department();
		department.setId("1");
		department.setName("运营部");
		department.setManager("运营经理");
		departments.add(department);
		department = new Department();
		department.setId("2");
		department.setName("测试部");
		department.setManager("测试经理");
		departments.add(department);
		company.setDepartments(departments);
		domTest.createXML(company);
		
	}
	
	public void createXML(Company company) {
		DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
		DocumentBuilder db = null;
		Document document = null;
		try {
			db = dbf.newDocumentBuilder();
			document = db.newDocument();
			document.setXmlStandalone(true);
			Element root = document.createElement("company");
			document.appendChild(root);
			List<Department> departments = company.getDepartments();
			for (Department department : departments) {
				Element element = document.createElement("department");
				element.setAttribute("id", department.getId());
				Element name = document.createElement("name");
				name.setTextContent(department.getName());
				Element manager = document.createElement("manager");
				manager.setTextContent(department.getManager());
				element.appendChild(name);
				element.appendChild(manager);
				root.appendChild(element);
			}
			
			
			
			
			//写出
			TransformerFactory tff = TransformerFactory.newInstance();
			Transformer tf = tff.newTransformer();
			//设置输出格式换行
			tf.setOutputProperty(OutputKeys.INDENT, "yes");
			tf.transform(new DOMSource(document), new StreamResult(new File("cfg/company_dom.xml")));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public  Company DocumentToCompany (Document document) {
		Company company = new Company();
		
		NodeList nodeList = document.getElementsByTagName("department");
		List<Department> departments = new ArrayList<Department>();
		company.setDepartments(departments);
		for (int i = 0; i < nodeList.getLength(); i++) {
			Department department = new Department();
			Element element = (Element) nodeList.item(i);
			departments.add(department);
			department.setId(element.getAttribute("id"));
			NodeList children = element.getChildNodes();
			for (int j = 0; j < children.getLength(); j++) {
				String nodeName = children.item(j).getNodeName();
				if (nodeName.equals("name")) {
					department.setName(children.item(j).getTextContent());
				}else if (nodeName.equals("manager")) {
					department.setManager(children.item(j).getTextContent());
				}
			}
		}
		return company;
	}
	
	
	
	public void xmlParse() {
		DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
		DocumentBuilder db = null;
		Document doc = null;
		try {
			db = dbf.newDocumentBuilder();
			doc = db.parse("cfg/company.xml");
			NodeList nodeList = doc.getElementsByTagName("department");
			System.out.println("一共有 "+nodeList.getLength()+" 个部门");
			for (int i = 0; i < nodeList.getLength(); i++) {
				//nodeList索引从0开始
				System.out.println("===========开始遍历第"+(i+1)+"个部门=========");
				//获取具体的属性值
				Element element = (Element) nodeList.item(i);
				System.out.println("id属性值为："+element.getAttribute("id"));
				//遍历所有的属性值
				Node node = nodeList.item(i);
				NamedNodeMap map = node.getAttributes();
				System.out.println("第"+(i+1) +"个部门共有"+map.getLength()+"个属性");
				for (int j = 0; j < map.getLength(); j++) {
					System.out.println(map.item(j).getNodeName()+" : "+map.item(j).getNodeValue());
				}
				//遍历子节点
				NodeList childList = node.getChildNodes();
				System.out.println("第"+(i+1) +"个部门共有"+childList.getLength()+"个子节点");
				for (int j = 0; j < childList.getLength(); j++) {
					//只取element类型节点；
					//Node.ELEMENT_NOD --<>类型
					//Node.TEXT_NODE -- 文本节点
					//Node.ATTRIBUTE_NODE --属性节点
					if (childList.item(j).getNodeType() == Node.ELEMENT_NODE) {
						//System.out.println(childList.item(j).getNodeName()+" : "+childList.item(j).getFirstChild().getNodeValue());
						//或者  //getTextContent还会获取子节点里的内容；
						System.out.println(childList.item(j).getNodeName()+" : "+childList.item(j).getTextContent());
					}
				}
				System.out.println("===========结束遍历第"+(i+1)+"个部门=========");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
