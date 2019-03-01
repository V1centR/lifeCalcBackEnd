package com.lifecalc.lifecalcBack.repo;
import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.lifecalc.lifecalcBack.entity.Categoria;

public interface CategoriaRepo extends CrudRepository<Categoria, Integer> {
	
	@Query("select c from Categoria c")
    List<Categoria> findAll();
}
