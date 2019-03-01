package com.lifecalc.lifecalcBack.controller;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;

@RestController
@RequestMapping(value="/api/date")
public class DateOperationsController {

	ObjectMapper mapper = new ObjectMapper();
	
	@CrossOrigin
	@RequestMapping("/current-time")
	public @ResponseBody ObjectNode getTime(){
		
		LocalDateTime localDate = LocalDateTime.now();
		
		String localDateString = localDate.format(DateTimeFormatter.ofPattern("dd-MM-yyyy"));
		String day = localDate.format(DateTimeFormatter.ofPattern("dd"));
		String month = localDate.format(DateTimeFormatter.ofPattern("MM"));
		String year = Integer.toString(localDate.getYear());

        ObjectNode objectNode = mapper.createObjectNode();
        objectNode.put("ms", System.currentTimeMillis());
        objectNode.put("day", day);
        objectNode.put("month", month);
        objectNode.put("year", year);
        objectNode.put("ddmmyy", localDateString);
		
		return objectNode;
	}
}
