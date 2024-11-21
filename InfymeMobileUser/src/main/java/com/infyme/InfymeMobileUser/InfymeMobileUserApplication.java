package com.infyme.InfymeMobileUser;

import org.modelmapper.ModelMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class InfymeMobileUserApplication {

	public static void main(String[] args) {
		SpringApplication.run(InfymeMobileUserApplication.class, args);
	}
	@Bean
	public ModelMapper getModelMapperBean() {
		return new ModelMapper();
	}

}
