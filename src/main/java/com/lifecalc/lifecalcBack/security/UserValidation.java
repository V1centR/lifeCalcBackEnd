package com.lifecalc.lifecalcBack.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import com.lifecalc.lifecalcBack.entity.User;
import com.lifecalc.lifecalcBack.repo.UsersRepo;

@Component
public class UserValidation implements Validator {

	@Autowired
	private UsersRepo userRepo;
	
	@Override
	public boolean supports(Class<?> clazz) {
		return User.class.equals(clazz);
	}

	@Override
	public void validate(Object target, Errors errors) {
		
//		User user = (User) target;
//		
//		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "userName", "NotEmpty");
//		if(user.getEmail().length() == 0) {
//			errors.rejectValue("userName", "Size.userForm.password");
//		}
//		
//		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "password", "NotEmpty");
//		if(user.getPassword().length() == 0) {
//			errors.rejectValue("password", "Size.userForm.password");
//		}
		
	}

}
