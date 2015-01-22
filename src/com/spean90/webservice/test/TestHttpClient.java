package com.spean90.webservice.test;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import org.apache.http.Consts;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.ContentType;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;

public class TestHttpClient {

	public static void main(String[] args) throws Exception {
		//根据ip获取地区信息
	String soapRequestData = "<?xml version=\"1.0\" encoding=\"utf-8\"?>" +
    "<soap12:Envelope xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\" xmlns:xsd=\"http://www.w3.org/2001/XMLSchema\" xmlns:soap12=\"http://www.w3.org/2003/05/soap-envelope\">" +
      "<soap12:Body>" +
       " <getCountryCityByIp xmlns=\"http://WebXml.com.cn/\">" +
      "    <theIpAddress>219.137.167.157</theIpAddress>" +
     "   </getCountryCityByIp>" +
    "  </soap12:Body>" +
    "</soap12:Envelope>";
	//获取ip信息
	String soapRequestData2 = "<?xml version=\"1.0\" encoding=\"utf-8\"?>" +
				    "<soap12:Envelope xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\" xmlns:xsd=\"http://www.w3.org/2001/XMLSchema\" xmlns:soap12=\"http://www.w3.org/2003/05/soap-envelope\">" +
				      "<soap12:Body>" +
				       " <getGeoIPContext xmlns=\"http://WebXml.com.cn/\"/>" +
				    "  </soap12:Body>" +
				    "</soap12:Envelope>";
	
	HttpPost postMethod = new HttpPost("http://www.webxml.com.cn/WebServices/IpAddressSearchWebService.asmx");
	StringEntity entity = new StringEntity(soapRequestData,ContentType.create("application/soap+xml", Consts.UTF_8));
	postMethod.setEntity(entity);
	CloseableHttpClient httpclient = HttpClients.createDefault();
	HttpResponse httpResponse = httpclient.execute(postMethod);
	HttpEntity httpEntity = httpResponse.getEntity();
	BufferedReader reader = new BufferedReader(new InputStreamReader(httpEntity.getContent()));
	String s = "";
	while((s=reader.readLine())!=null) {
		System.out.println(s);
	}
	}
}
	