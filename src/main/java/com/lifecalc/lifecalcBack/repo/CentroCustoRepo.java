package com.lifecalc.lifecalcBack.repo;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.lifecalc.lifecalcBack.entity.CentroCusto;

public interface CentroCustoRepo extends CrudRepository<CentroCusto, Integer> {

	@Query("select c from CentroCusto c")
    List<CentroCusto> findAll();
	
	@Query("SELECT c FROM CentroCusto c WHERE c.name = :typeCost ORDER by c.id DESC")
	CentroCusto findLast(String typeCost);
	
	@Query("SELECT c FROM CentroCusto c WHERE c.id = :id")
    CentroCusto find(Integer id);
	
}
