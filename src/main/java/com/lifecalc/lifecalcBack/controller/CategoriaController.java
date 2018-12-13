package com.lifecalc.lifecalcBack.controller;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.lifecalc.lifecalcBack.entity.Categoria;
import com.lifecalc.lifecalcBack.repo.CategoriaRepo;

@RestController
@RequestMapping(value="/cat")
public class CategoriaController {

	@Autowired
	private CategoriaRepo categoriaRepo;
	
	 @Autowired
	 DataSource dataSource;
	
	@RequestMapping("/test")
	public @ResponseBody String getTest() {
		
		return "Test OK";
	}
	
	@RequestMapping("/all")
	public @ResponseBody Iterable<Categoria> getCategorias(){
		System.out.println("pasosu aqui");
		return categoriaRepo.findAll();
	}
}
