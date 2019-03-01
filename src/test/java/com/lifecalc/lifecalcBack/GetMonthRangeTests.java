package com.lifecalc.lifecalcBack;

import java.io.IOException;

import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.json.JSONObject;
import org.junit.Test;

public class GetMonthRangeTests {
	
	@Test
	public void getMonths() {
		
		String startMonth = "2018-12-01";
		String finalMonth = "2019-02-28";
		String jsonStr = "";
		
		jsonStr = "{'startDate':'"+startMonth+"','finalDate':'"+finalMonth+"'}";
		
		CloseableHttpClient client = HttpClients.createDefault();
		HttpPost httpPost = new HttpPost("http://127.0.0.1:8080/api/op/month-range");
		
		StringEntity entityStr = new StringEntity(jsonStr,"utf-8");					
		
		httpPost.setEntity(entityStr);
	    httpPost.setHeader("Accept", "application/json");
	    httpPost.setHeader("Content-type", "application/json");
		
	    try {
	    	
			CloseableHttpResponse response = client.execute(httpPost);
			
			System.out.println("RESPONSE ####>" + response + "<#############");
			
		} catch (ClientProtocolException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}

}
