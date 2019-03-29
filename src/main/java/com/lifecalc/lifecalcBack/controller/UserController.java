package com.lifecalc.lifecalcBack.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
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
	
	@CrossOrigin
	@PostMapping(value="/login")
	public @ResponseBody String loginExec(){
		
		//usersRepo.findByEmail();
		
		return "{'status':'logged'}";
	}
	
	/*
	 	@PostMapping("/registration")
	    public String registration(@ModelAttribute("userForm") User userForm, BindingResult bindingResult) {
	        userValidator.validate(userForm, bindingResult);
	
	        if (bindingResult.hasErrors()) {
	            return "registration";
	        }
	
	        userService.save(userForm);
	
	        securityService.autoLogin(userForm.getUsername(), userForm.getPasswordConfirm());
	
	        return "redirect:/welcome";
	    }
	 * 
	 * */

}
