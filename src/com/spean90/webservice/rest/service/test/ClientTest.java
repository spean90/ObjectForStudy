package com.spean90.webservice.rest.service.test;

import java.io.IOException;

import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.fluent.Request;
import org.apache.http.entity.StringEntity;
import org.codehaus.jettison.json.JSONException;
import org.codehaus.jettison.json.JSONObject;
import org.springframework.web.client.RestTemplate;

public class ClientTest {

	public static void main(String[] args) {
		try {
			JSONObject params = new JSONObject();
			JSONObject json = new JSONObject();
			try {
				json.put("id", "12345");
				json.put("name", "hello2");
				params.put("user", json);
			} catch (JSONException e) {
				e.printStackTrace();
			}
			System.out.println(params.toString());
			StringEntity entity = new StringEntity(params.toString());
			//UrlEncodedFormEntity entity = new UrlEncodedFormEntity(params, Consts.UTF_8);
			entity.setContentType("application/json;charset=utf-8");
			String s = Request.Post("http://localhost/ws/user/addUser").connectTimeout(1000)
			.socketTimeout(1000)
			.body(entity)
			.execute().returnContent().asString();
			System.out.println(s);
		} catch (ClientProtocolException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}
