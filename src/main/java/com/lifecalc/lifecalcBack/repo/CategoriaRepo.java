package com.lifecalc.lifecalcBack.repo;
import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.lifecalc.lifecalcBack.entity.Categoria;
import com.lifecalc.lifecalcBack.entity.Produto;

public interface CategoriaRepo extends CrudRepository<Categoria, Integer> {
	
	@Query("select c from Categoria c")
    List<Categoria> findAll();
	
	@Query("select c from Categoria c WHERE c.id = :id")
    Categoria find(Integer id);
}
