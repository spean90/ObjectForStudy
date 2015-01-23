package com.spean90.httpcomponents;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import org.apache.http.Header;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.StatusLine;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;

public class HttpGetTest {

	public static void main(String[] args) {
		HttpGetTest test = new HttpGetTest();
		test.httpSimpleGetTest();
		
	}
	/**
	 * 基本http get
	* @author Huangsp
	* @date 2015年1月23日 
	*
	 */
	public void httpSimpleGetTest() {
		HttpClient httpClient = HttpClients.createDefault();
		String url = "http://webservice.webxml.com.cn/WebServices/WeatherWS.asmx/getRegionProvince?";
		HttpGet httpGet = new HttpGet(url);
		try {
			HttpResponse httpResponse = httpClient.execute(httpGet);
			printResponse(httpResponse);
		} catch (ClientProtocolException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	
	
	public void printResponse(HttpResponse httpResponse) {
		StatusLine line = httpResponse.getStatusLine();
		System.out.println(line.toString());
		System.out.println(line.getStatusCode());
		Header[] headers = httpResponse.getAllHeaders();
		System.out.println("================header==========");
		for (Header header : headers) {
			System.out.println(header.getName()+"  :  "+header.getValue());
		}
		System.out.println("================header end==========");
		System.out.println("================body==========");
		try {
			HttpEntity entity = httpResponse.getEntity();
			long len = entity.getContentLength();
			if (len!=-1 || len<2048) {
				System.out.println("使用EntityUtils..."+len);
				System.out.println(EntityUtils.toString(entity));
			}else{
				System.out.println("entity长度过长使用inputstream...."+len);
				BufferedReader reader = new BufferedReader(new InputStreamReader(entity.getContent()));
				String s = "";
				while((s=reader.readLine())!=null) {
					System.out.println(s);
				}
			}
			
			
			
		} catch (IllegalStateException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		System.out.println("================body end==========");
	}
}
