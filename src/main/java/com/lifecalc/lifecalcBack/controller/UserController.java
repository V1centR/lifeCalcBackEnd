package com.lifecalc.lifecalcBack.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.lifecalc.lifecalcBack.entity.User;
import com.lifecalc.lifecalcBack.repo.UsersRepo;

@RestController
@RequestMapping(value="/api/user")
public class UserController {
	
	@Autowired
	private UsersRepo usersRepo;
	
	@CrossOrigin
	@RequestMapping("/all")
	public @ResponseBody Iterable<User> findAll(){
		return usersRepo.findAll();
	}

}
