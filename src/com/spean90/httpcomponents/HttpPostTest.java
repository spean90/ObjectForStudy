package com.spean90.httpcomponents;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

import org.apache.http.Consts;
import org.apache.http.Header;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.StatusLine;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.impl.client.LaxRedirectStrategy;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;

public class HttpPostTest {

	public static void main(String[] args) {
		HttpPostTest httpPostTest = new HttpPostTest();
		httpPostTest.httpSimplePostTest();
	}
	
	public void httpSimplePostTest() {
		List<NameValuePair> params = new ArrayList<NameValuePair>();
		params.add(new BasicNameValuePair("mobileCode", "13850857602"));
		params.add(new BasicNameValuePair("userID", ""));
		HttpPost httpPost = new HttpPost("http://webservice.webxml.com.cn/WebServices/MobileCodeWS.asmx/getMobileCodeInfo");
		UrlEncodedFormEntity entity = new UrlEncodedFormEntity(params, Consts.UTF_8);
		entity.setContentType("application/x-www-form-urlencoded;charset=utf-8");
		httpPost.setEntity(entity);
		//HttpClient httpClient = HttpClients.createDefault();
		//设置redirect策略；
		LaxRedirectStrategy redirectStrategy = new LaxRedirectStrategy();
		CloseableHttpClient httpClient = HttpClients.custom()
		        .setRedirectStrategy(redirectStrategy)
		        .build();
		try {
			HttpResponse response = httpClient.execute(httpPost);
			printResponse(response);
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
