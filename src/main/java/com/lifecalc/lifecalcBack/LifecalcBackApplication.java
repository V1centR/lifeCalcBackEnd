package com.lifecalc.lifecalcBack;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.sql.DataSource;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

@SpringBootApplication
public class LifecalcBackApplication {
	
	@PersistenceContext
    private EntityManager entityManager;

	public static void main(String[] args) {
		SpringApplication.run(LifecalcBackApplication.class, args);
	}	
//	 @Bean
//	    public DataSource dataSource(){
//	        DriverManagerDataSource dataSource = new DriverManagerDataSource();
//	        dataSource.setDriverClassName("com.mysql.cj.jdbc.Driver");
//	        dataSource.setUrl("jdbc:mysql://localhost:3306/lifeCalcDatabase?useTimezone=true&serverTimezone=UTC");
//	        dataSource.setUsername("root");
//	        dataSource.setPassword("device");
//	        return dataSource;
//	    }
}
