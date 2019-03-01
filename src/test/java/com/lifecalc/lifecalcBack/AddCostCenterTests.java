package com.lifecalc.lifecalcBack;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Random;

import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.junit.Test;

public class AddCostCenterTests {
	
	@Test
	public void generateCenterCost() throws ClientProtocolException, IOException {
		
		String jsonStr;
		
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		Calendar c = Calendar.getInstance();
		
		String novaData = sdf.format(c.getTime());
		
		String description = "Mont salário mensal";
		
		jsonStr = "{'name': 'Dinheiro','base_date':'"+novaData+"','base':'2895.88','description':'"+description+"'}";
		
		CloseableHttpClient client = HttpClients.createDefault();
		HttpPost httpPost = new HttpPost("http://127.0.0.1:8080/api/cost-center/insert");
		
		StringEntity entityStr = new StringEntity(jsonStr,"utf-8");
		System.out.println(entityStr);
		
		httpPost.setEntity(entityStr);
	    httpPost.setHeader("Accept", "application/json");
	    httpPost.setHeader("Content-type", "application/json");
		
	    CloseableHttpResponse response = client.execute(httpPost);

		
	}
	
	private String randHour() {
		
		String[] date = new String[11];
		
		date[0] = "06:20:12";
		date[1] = "07:40:11";
		date[2] = "08:15:26";
		date[3] = "09:00:35";
		date[4] = "12:40:45";
		date[5] = "12:59:09";
		date[6] = "13:30:05";
		date[7] = "17:20:47";
		date[8] = "17:40:16";
		date[9] = "18:20:52";
		date[10] = "19:00:10";
		
		int random = new Random().nextInt(date.length);

		return date[random];
	}
	
}
