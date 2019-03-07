package com.lifecalc.lifecalcBack.controller;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.lifecalc.lifecalcBack.entity.Categoria;
import com.lifecalc.lifecalcBack.repo.CategoriaRepo;


@RestController
@RequestMapping(value="/api/cat")
public class CategoriaController {

	@Autowired
	private CategoriaRepo categoriaRepo;

	@CrossOrigin
	@RequestMapping("/all")
	public @ResponseBody List<Categoria> findAll(){
		
		Date date = new Date();
		//DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
		
		System.out.println("exec ok::" + date.getTime());
		return categoriaRepo.findAll();
	}
	
	@CrossOrigin
    @PostMapping("/insert")
    public HttpStatus insert(@RequestBody Categoria model) {
		 
		 try {
			 Categoria categoria = categoriaRepo.save(model);
			 return HttpStatus.CREATED;
		} catch (Exception e) {
			return HttpStatus.INTERNAL_SERVER_ERROR;
		}
		
	 }
}
