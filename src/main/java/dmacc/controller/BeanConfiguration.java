package dmacc.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import dmacc.beans.Animal;
import dmacc.beans.User;
import dmacc.repository.AnimalRepository;
import dmacc.repository.UserRepository;

@Configuration
public class BeanConfiguration {
	//@Autowired
	//AnimalRepository repo;
	
	//@Autowired
	//UserRepository uRepo;
	
	
	@Bean
	public Animal cat() {
		Animal bean = new Animal();
		bean.setSpecies("Cat");
		bean.setName("Moe");
		bean.setBreed("Tabby");
		bean.setSize("Fat");
		//repo.save(bean);
		return bean;
	}
	
	@Bean
	public Animal dog() {
		Animal bean = new Animal();
		bean.setSpecies("Dog");
		bean.setName("Shiloh");
		bean.setBreed("Lab");
		bean.setSize("Medium");
		//repo.save(bean);
		return bean;
	}
	
	
	
	@Bean
	public User user(@Qualifier("cat") Animal cat) {
		
		User bean = new User();
		bean.setUserName("Dave");
		bean.setPassword("password123");
		List <Animal> favorites = new ArrayList<Animal>();
		favorites.add(cat);
		bean.setFavorites(favorites);
		//uRepo.save(bean);
		return bean;
	}
	
	
}
