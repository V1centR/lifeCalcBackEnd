package com.lifecalc.lifecalcBack.repo;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.lifecalc.lifecalcBack.entity.Produto;

public interface ProductRepo extends CrudRepository<Produto, Integer> {

	@Query("select p from Produto p")
    List<Produto> findAll();
	
	@Query("select p from Produto p WHERE p.id = :id")
    Produto find(Integer id);
}
