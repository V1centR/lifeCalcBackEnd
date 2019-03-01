package com.lifecalc.lifecalcBack;

import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Random;

import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.json.JSONObject;
import org.junit.Test;

public class AddOperationsTests {
	
//	public void addOperations() {
//		
//		//makeStr();
//		System.out.println("addOperations exec ");
//	}

	
	@Test
	public void makeStr() throws Exception {
		
		//One day: 86400000
		Integer timeForDay = 8;
		String sql  = "";
		Integer numOfDays = 28;
		Integer currentDay = 1;
		String jsonStr = "";
		//2019-11-05 14:29:36'

		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		Calendar c = Calendar.getInstance();
		String randHour = randHour();
		c.setTime(sdf.parse("2018-12-01 "+randHour+""));
		
		
		//OperationController operation = new OperationController();
		//Number of days
		for(Integer i = 1; i<= numOfDays; i++) {
			
			currentDay = i;
			
			c.add(Calendar.DAY_OF_MONTH,1);
			
			
			if(currentDay == i) {
				//Dispends for day
				for(Integer x = 0; x< timeForDay; x++) {
					
					Integer randMinute = new Random().nextInt(15 + 1);
					
					c.add(Calendar.HOUR_OF_DAY,1);
					c.add(Calendar.MINUTE,randMinute);
					String novaData = sdf.format(c.getTime());
					
					//set price
					Double values = makePrice();
					Integer prodId = randProd();
				//	Integer costCenter = costCenter();
					DecimalFormat decimalF = new DecimalFormat("0.00");
			
					jsonStr = "{'date':'"+novaData+"','location':'YCiaY5dasb32','produto':'"+prodId+"','value':'"+decimalF.format(values)+"','centro_custo':'27'}";
				
					CloseableHttpClient client = HttpClients.createDefault();
					HttpPost httpPost = new HttpPost("http://127.0.0.1:8080/api/op/insert");
					
					StringEntity entityStr = new StringEntity(jsonStr,"utf-8");					
					
					httpPost.setEntity(entityStr);
				    httpPost.setHeader("Accept", "application/json");
				    httpPost.setHeader("Content-type", "application/json");
					
				    CloseableHttpResponse response = client.execute(httpPost);
					
				}
				
			}
		}
		
	}
	
	private Double makePrice() {
		double x = (Math.random()*((69.99-1.99)+1));
		return x;
	}
	
	private Integer randProd() {
		Random randNum = new Random();
		Integer num = randNum.nextInt(36)+1;
		return num;
	}
	
	private Integer costCenter() {
		Random randNum = new Random();
		Integer num = randNum.nextInt(2)+1;
		return num;
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
