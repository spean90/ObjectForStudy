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
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.config.RequestConfig.Builder;
import org.apache.http.client.fluent.Request;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;

public class HttpGetTest {

	public static void main(String[] args) {
		HttpGetTest test = new HttpGetTest();
		test.httpFluentGetTest();
		
	}
	public void httpFluentGetTest()	 {
		try {
			String s = Request.Get("http://webservice.webxml.com.cn/WebServices/WeatherWS.asmx/getRegionProvince?")
			.connectTimeout(1000)
			.socketTimeout(1000)
			.execute().returnContent().asString();
			System.out.println(s);
		} catch (ClientProtocolException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * 基本http get
	* @author Huangsp
	* @date 2015年1月23日 
	*
	 */
	public void httpSimpleGetTest() {
		
		String url = "http://webservice.webxml.com.cn/WebServices/WeatherWS.asmx/getRegionProvince?";
		HttpGet httpGet = new HttpGet(url);
		Builder builder = RequestConfig.custom()
			    .setSocketTimeout(1000)
			    .setConnectTimeout(3000);
		RequestConfig config = builder.build();
		//指点该httpget的cofig;也可以通过下面指点client的config来实现；
		//httpGet.setConfig(config);
		
		//根据builder创建制定的client;
		HttpClientBuilder builder2 = HttpClients.custom().setDefaultRequestConfig(config);
		HttpClient httpClient = builder2.build();
		//创建默认的httpclient;
		//HttpClient httpClient = HttpClients.createDefault();
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
