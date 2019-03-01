package com.lifecalc.lifecalcBack.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.lifecalc.lifecalcBack.entity.Produto;
import com.lifecalc.lifecalcBack.repo.ProductRepo;

@RestController
@RequestMapping(value="/api/product")
public class ProductController {
	
	@Autowired
	private ProductRepo productRepo;
	
	@CrossOrigin
	@RequestMapping("/all")
	public @ResponseBody List<Produto> findAll(){
		return productRepo.findAll();
	}
}
