package com.lifecalc.lifecalcBack.repo;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.lifecalc.lifecalcBack.entity.User;

public interface UsersRepo extends CrudRepository<User, Integer> {

	@Query("SELECT u FROM User u")
    List<User> findAll();
	
}
