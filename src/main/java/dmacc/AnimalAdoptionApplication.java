package dmacc;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import dmacc.beans.Animal;
import dmacc.beans.User;
import dmacc.controller.BeanConfiguration;

@SpringBootApplication
public class AnimalAdoptionApplication {

	public static void main(String[] args) {
		SpringApplication.run(AnimalAdoptionApplication.class, args);
		
		ApplicationContext appContext = new AnnotationConfigApplicationContext(BeanConfiguration.class);
		
		Animal a = appContext.getBean("cat", Animal.class);
		Animal d = appContext.getBean("dog", Animal.class);
		User u = appContext.getBean("user", User.class);
		
		System.out.println(a.toString());
		System.out.println(d.toString());
		System.out.println(u.toString());
		
	}

}
