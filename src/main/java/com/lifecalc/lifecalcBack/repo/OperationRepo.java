package com.lifecalc.lifecalcBack.repo;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.lifecalc.lifecalcBack.entity.DateValueMonths;
import com.lifecalc.lifecalcBack.entity.Operation;

public interface OperationRepo extends CrudRepository<Operation, Integer>{

	@Query("SELECT o FROM Operation o")
    Iterable<Operation> findAll();
	
	@Query("SELECT o FROM Operation o WHERE o.date BETWEEN DATE(:start) AND DATE(:finalDate)")
    Iterable<Operation> findByDate(String start,String finalDate);

	@Query("SELECT o FROM Operation o WHERE o.date like :day% ")
	List<Operation> findAllDays(@Param("day") String day);
	
	@Query("SELECT SUM(o.value) as value FROM Operation o WHERE date(o.date) = CURDATE()")
	List<Operation> findDaily();
	//select MONTH(date) as month,SUM(value) as total from operation WHERE YEAR(date) = 2018 AND MONTH(date) = 2 GROUP BY month;
	@Query(value="SELECT MONTH(date) as month,SUM(value) as total from operation WHERE YEAR(date) = :year AND MONTH(date) = :month GROUP BY month", nativeQuery = true)
	DateValueMonths sumOperation(Integer year, Integer month);
	
}
