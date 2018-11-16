package com.lifecalc.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.lifecalc.entity.Categoria;
import com.lifecalc.repo.CategoriaRepo;

@Controller
@RequestMapping("/category")
public class CategoriaController {

	@Autowired
	private CategoriaRepo categoriaRepo;
	
	@RequestMapping("/all")
	public @ResponseBody Iterable<Categoria> getCategorias(){
		
		return categoriaRepo.findAll();
	}
}
