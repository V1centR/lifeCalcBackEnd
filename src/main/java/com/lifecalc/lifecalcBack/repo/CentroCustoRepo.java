package com.lifecalc.lifecalcBack.repo;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.lifecalc.lifecalcBack.entity.CentroCusto;

public interface CentroCustoRepo extends CrudRepository<CentroCusto, Integer> {

	@Query("select c from CentroCusto c")
    List<CentroCusto> findAll();
	
	@Query(value="SELECT * FROM centro_custo WHERE name = :typeCost ORDER BY id DESC LIMIT 1", nativeQuery=true)
	CentroCusto findLast(String typeCost);
	
	@Query("SELECT c FROM CentroCusto c WHERE c.id = :id")
    CentroCusto find(Integer id);
	
}
