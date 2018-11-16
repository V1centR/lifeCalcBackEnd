package com.lifecalc.lifecalcBack;

import java.util.List;

import javax.persistence.EntityManager;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.lifecalc.entity.Categoria;
import com.lifecalc.repo.CategoriaRepo;

@RestController
@RequestMapping("/home")
@SpringBootApplication
public class LifecalcBackApplication {
	
	private CategoriaRepo categoriaRepo;

	@RequestMapping("/teste")
	String home(){
		return ":: LifeCalc OK ::";
	}
	
	@RequestMapping("/cat")
	public @ResponseBody Iterable<Categoria> getCategorias(){
		
		return categoriaRepo.findAll();
	}
	
	public static void main(String[] args) {
		SpringApplication.run(LifecalcBackApplication.class, args);
	}
}
