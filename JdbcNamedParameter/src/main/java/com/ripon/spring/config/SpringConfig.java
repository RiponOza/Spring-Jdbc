package com.ripon.spring.config;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;



@Configuration
@ComponentScan(basePackages = "com.ripon.spring.*")
public class SpringConfig {
	
	
	@Bean
	public DriverManagerDataSource getDriverManagerDataSource() {
		DriverManagerDataSource ds = new DriverManagerDataSource();
		ds.setUrl("jdbc:mysql://localhost:3306/db01");
		ds.setUsername("root");
		ds.setPassword("");
		return ds;
	}
	
	@Bean
	public JdbcTemplate getJdbcTemplate() {
		JdbcTemplate template = new JdbcTemplate();
		template.setDataSource(getDriverManagerDataSource());
		return template;
	}
	

}
