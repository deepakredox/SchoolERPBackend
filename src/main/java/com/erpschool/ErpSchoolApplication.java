package com.erpschool;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@SpringBootApplication
public class ErpSchoolApplication {

	public static void main(String[] args) {
		SpringApplication.run(ErpSchoolApplication.class, args);
	}
	
	@Bean
	public WebMvcConfigurer corsConfigurer()
	{
	  return new WebMvcConfigurer() {
		  public void addCorsMappings(CorsRegistry registry) {
			  registry.addMapping("/*").allowedHeaders("*").allowedOrigins("*").allowedMethods("*")
			  .allowCredentials(true);
		  }
	  };	
	}

}
