package cn.com.webxml.weather.test;

import java.util.List;

import cn.com.webxml.weather.ArrayOfString;
import cn.com.webxml.weather.WeatherWS;
import cn.com.webxml.weather.WeatherWSSoap;

public class TestWeatherClient {

	public static void main(String[] args) {
		WeatherWS weatherWS = new WeatherWS();
		WeatherWSSoap weatherWSSoap = weatherWS.getWeatherWSSoap();
		ArrayOfString arrayOfString = weatherWSSoap.getWeather("福州", null);
		List<String>list = arrayOfString.getString();
		for (String string : list) {
			System.out.println(string);
		}
		
		
	}
}
