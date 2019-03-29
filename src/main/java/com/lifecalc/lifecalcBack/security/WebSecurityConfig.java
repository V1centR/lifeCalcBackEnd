package com.lifecalc.lifecalcBack.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

	@Override
	protected void configure (AuthenticationManagerBuilder http) throws Exception {
		
		http.inMemoryAuthentication()
		.withUser("root")
		.password("123")
		.roles("USER");
		
		/*.antMatchers("/","/api").permitAll().anyRequest().authenticated()
		.and().formLogin().loginPage("/login").permitAll()
		.and().logout().permitAll();*/
	}
	

//	public UserDetailsService userDeatailsService() {
//		
//		@SuppressWarnings("deprecation")
//		UserDetails user = org.springframework.security.core.userdetails.User.withDefaultPasswordEncoder()
//				.username("test")
//				.password("dev")
//				.roles("user")
//				.build();
//		
//		//return new InMemoryUserDetailsManager(user);
//	}
	
	
}
