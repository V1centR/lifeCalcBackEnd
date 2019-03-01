package com.lifecalc.lifecalcBack.controller;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.lifecalc.lifecalcBack.entity.CentroCusto;
import com.lifecalc.lifecalcBack.repo.CentroCustoRepo;

@RestController
@RequestMapping(value="/api/cost-center")
public class CentroCustoController {
	
	
	@Autowired
	CentroCustoRepo centroCustoRepo;
	
	
	@CrossOrigin
	@PostMapping(path="/insert",consumes = "application/json", produces = "application/json")
	public HttpStatus save(@RequestBody String costCenter) throws JsonProcessingException, IOException{
		
		
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		Calendar c = Calendar.getInstance();
		String novaData = sdf.format(c.getTime());
		
		JSONObject jsonItem = new JSONObject(costCenter);
		
		CentroCusto costCenterObj = new CentroCusto();
		
		costCenterObj.setName(jsonItem.get("name").toString());
		costCenterObj.setBase(Double.parseDouble(jsonItem.get("base").toString()));
		costCenterObj.setDescription(jsonItem.get("description").toString());
		costCenterObj.setBaseDate(novaData);
		
		centroCustoRepo.save(costCenterObj);
		System.out.println("CenterCost exec ok:: " + novaData);
		return HttpStatus.CREATED;
		
	}
	
	@CrossOrigin
	@RequestMapping(path="/last/{type}")
	public @ResponseBody CentroCusto getLast(@PathVariable String type){
		
		try {
			return centroCustoRepo.findLast(type);
		} catch (Exception e) {
			return null;
		}
		
	}	

}
