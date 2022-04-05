package dmacc.controller;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import dmacc.beans.Animal;

@Configuration
public class BeanConfiguration {
	@Bean
	public Animal animal() {
		Animal bean = new Animal();
		return bean;
	}

}
