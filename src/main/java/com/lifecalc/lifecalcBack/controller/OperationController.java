package com.lifecalc.lifecalcBack.controller;

import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

import org.hibernate.query.criteria.internal.predicate.IsEmptyPredicate;
import org.joda.time.DateTime;
import org.joda.time.Months;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ArrayNode;
import com.fasterxml.jackson.databind.node.ObjectNode;
import com.lifecalc.lifecalcBack.entity.CentroCusto;
import com.lifecalc.lifecalcBack.entity.DateValueMonths;
import com.lifecalc.lifecalcBack.entity.Operation;
import com.lifecalc.lifecalcBack.entity.Produto;
import com.lifecalc.lifecalcBack.repo.CentroCustoRepo;
import com.lifecalc.lifecalcBack.repo.OperationRepo;
import com.lifecalc.lifecalcBack.repo.ProductRepo;

@RestController
@RequestMapping(value="/api/op")
public class OperationController {

	@Autowired
	private OperationRepo operationRepo;
	
	@Autowired
	private ProductRepo productRepo;
	
	@Autowired
	private CentroCustoRepo centroCustoRepo;
	
	@CrossOrigin
	@RequestMapping("/all")
	public @ResponseBody Iterable<Operation> findAll(){
		return operationRepo.findAll();
	}
	
	@CrossOrigin
	@RequestMapping("/daily")
	public @ResponseBody Iterable<Operation> findDaily(){
		return operationRepo.findDaily();
	}
	
	@CrossOrigin
	@RequestMapping(path="/month-range", method=RequestMethod.POST, consumes="application/json",produces="application/json")
	public @ResponseBody ArrayNode searchByMonthRange(@RequestBody String monthsRange){
	
		JSONObject jsonObj = new JSONObject(monthsRange);
		String startDate = jsonObj.getString("startDate");
		String finalDate = jsonObj.getString("finalDate");
		
		System.out.println("Params Received::: " + jsonObj);
		
		DateValueMonths currentQueryResult = null;
		
		DateTime dataInicio = new DateTime(startDate);
		DateTime dataInicioBkp = new DateTime(startDate);
		DateTime dataFinal = new DateTime(finalDate);
		 
		Months months = Months.monthsBetween(dataInicio, dataFinal);
		
		DateFormat inputFormat = new SimpleDateFormat("yyyy-MM-dd");
		ArrayList<String> finalMonths = new ArrayList<String>();
		finalMonths.add(inputFormat.format(dataInicio.toDate()));
		
		ObjectMapper objMapper = new ObjectMapper();
		ArrayNode arrayNode = objMapper.createArrayNode();
		
		for (int i = 0; i <= months.getMonths(); i++) {
	    	
	    	dataInicioBkp = dataInicio;
	    	finalMonths.add(inputFormat.format(dataInicio.toDate()));
	    	currentQueryResult = operationRepo.sumOperation(dataInicio.getYear(),dataInicio.getMonthOfYear());
	    	
	    	//json handle###
	    	ObjectNode objNode = objMapper.createObjectNode();
	    	
	    	if(currentQueryResult == null) {

	    		objNode.put("date", inputFormat.format(dataInicio.toDate()));
		    	objNode.put("total", 0.00);
		    	
	    	} else {
	    		//JSON Handle ###########
		    	objNode.put("date", inputFormat.format(dataInicio.toDate()));
		    	objNode.put("total", currentQueryResult.getTotal());
	    	}
	    	
	    	//Create json object
	    	arrayNode.add(objNode);
	    	
	    	dataInicio = dataInicioBkp.plusMonths(1);
	    }

		return arrayNode;
	    	
	}
	
	@CrossOrigin
	@RequestMapping(path="/byday", method=RequestMethod.POST, consumes="application/json",produces="application/json")
	public @ResponseBody Iterable<Operation> searchByday(@RequestBody String day){
		
		System.out.println(day);
		JSONObject jsonObj = new JSONObject(day);
		String startDate = jsonObj.getString("oneDay");
		
		try {
			return operationRepo.findAllDays(startDate);
		} catch (Exception e) {
			return null;
		}
	}

	@CrossOrigin
	@RequestMapping(path="/search", method=RequestMethod.POST, consumes="application/json",produces="application/json")
	public @ResponseBody Iterable<Operation> search(@RequestBody String dateRange){
		
		JSONObject jsonObj = new JSONObject(dateRange);
		
		String startDate = jsonObj.getString("startDate");
		String finalDate = jsonObj.getString("endDate");
		
		System.out.println("Date handled:: " + finalDate.substring(0, finalDate.length()-2)+"30");
		
		try {
			return operationRepo.findByDate(startDate, finalDate.substring(0, finalDate.length()-2)+"31");
		} catch (Exception e) {
			return null;
		}
	}
	
	@CrossOrigin
	@PostMapping(path="/insert",consumes = "application/json", produces = "application/json")
	public HttpStatus save(@RequestBody String operations) throws JsonProcessingException, IOException{
		
		String novaData;
		String retroTransAction;
		
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		Calendar c = Calendar.getInstance();
		
		JSONObject jsonItem = new JSONObject(operations);
		JSONObject productItem = (JSONObject) jsonItem.get("produto");
		
		try {
			retroTransAction = jsonItem.get("retro").toString() + ":01";
			SimpleDateFormat currentDay = new SimpleDateFormat("yyyy-MM-dd");
	        Date date = new Date();
	        currentDay.format(date);
	        
	        Calendar calendarRetro = Calendar.getInstance();
	        calendarRetro.setTime(sdf.parse(currentDay.format(date) + " " + retroTransAction+""));
	        novaData = sdf.format(calendarRetro.getTime());
			
		} catch (Exception e) {
			novaData = sdf.format(c.getTime());
		}
		
		//get prod Object
		Produto product = productRepo.find(Integer.parseInt(productItem.get("id").toString()));
		System.out.println(product);
		
		CentroCusto centroCusto = centroCustoRepo.find(Integer.parseInt(jsonItem.get("centroCusto").toString()));
		
		Operation operation = new Operation();
		
		operation.setDate(novaData);
		operation.setLocation("YCiaY5dasb32");
		operation.setProdutoBean(product);
		operation.setValue(Double.parseDouble(jsonItem.get("value").toString()));
		operation.setCentroCustoBean(centroCusto);
		
		operationRepo.save(operation);
		System.out.println("OperationController exec ok:: " + operation.getDate());
		
		return HttpStatus.CREATED;
	}
}
