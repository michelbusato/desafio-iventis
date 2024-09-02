package br.com.desafio.api.config;

import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;

@Configuration
public class ApplicationConfig {

	@Bean
	public ModelMapper novoModelMapper() {
		ModelMapper modelMapper = new ModelMapper();
		return modelMapper;
	}
	

}
