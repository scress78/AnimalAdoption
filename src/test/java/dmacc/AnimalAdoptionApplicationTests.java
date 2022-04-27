package dmacc;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import dmacc.beans.Animal;
import dmacc.beans.User;
import dmacc.repository.AnimalRepository;

//https://www.baeldung.com/spring-boot-testing

@SpringBootTest
class AnimalAdoptionApplicationTests {

	@Autowired
	private AnimalRepository aRepo;

	// animal testing
	@Test
	public void testSetAnimalName() {
		// setup
		String name = "Shiloh";
		Animal dog = new Animal();
		dog.setName("Shiloh");
		
		// assert
		assertThat(name).isEqualTo(dog.getName());
	}
	
	// user login testing
	@Test
	public void testUserLoggedInVariableInitial() {
		//setup
		User user = new User();
		
		boolean expected = true;
		user.setLoggedIn(true);
		boolean actual = user.isLoggedIn();
		
		//assert
		assertThat(expected).isEqualTo(actual);	
	}
	
	@Test
	public void testUserLogOut() {
		//setup
		User user = new User();
		
		boolean expected = false;
		user.setLoggedIn(true);
		user.logOut();
		boolean actual = user.isLoggedIn();
		
		//assert
		assertThat(expected).isEqualTo(actual);	
	}
	
	@Test
	public void testUserLogInSuccessful() {
		//setup
		User user = new User();
		
		boolean expected = true;
		user.setLoggedIn(false);
		user.setPassword("password123");
		user.logIn("password123");
		boolean actual = user.isLoggedIn();
		
		//assert
		assertThat(expected).isEqualTo(actual);	
	}
	
	@Test
	public void testUserLogInUnsuccessful() {
		//setup
		User user = new User();
		
		boolean expected = false;
		user.setLoggedIn(false);
		user.setPassword("password123");
		user.logIn("I'm a hacker");
		boolean actual = user.isLoggedIn();
		
		//assert
		assertThat(expected).isEqualTo(actual);	
	}
	
	// user favorite testing // current error
	@Test
	public void testSetUserFavoriteNotEmpty() {
		Animal dog = new Animal();
		Animal cat = new Animal();
		List <Animal> newFavorites = new ArrayList();
		//looks like no arg constructor might not work here
		User user = new User(0, "Done with finals, Spencer?", "pw123", newFavorites);
		
		List <Animal> favorites = user.getFavorites();
		System.out.println(favorites);
		if(!favorites.contains(dog)) {
			favorites.add(dog);
		}
		System.out.println(favorites + " " + favorites.contains(dog) + " "+ favorites.contains(cat));
	
		user.setFavorites(favorites);
		
		int size = user.getFavorites().size();
		int expectedSize = 1;
		assertThat(size).isEqualTo(expectedSize);	
	}
	
	@Test
	public void testFavoriteDoubleAddExceptionPrevention() {
		Animal dog = new Animal();
		Animal cat = new Animal();
		List <Animal> newFavorites = new ArrayList();
		//looks like no arg constructor might not work here
		User user = new User(0, "Done with finals, Spencer?", "pw123", newFavorites);
		
		List <Animal> favorites = user.getFavorites();
		System.out.println(favorites);
		if(!favorites.contains(dog)) {
			favorites.add(dog);
		}
		if(!favorites.contains(dog)) {
			favorites.add(dog);
		}
		System.out.println(favorites + " " + favorites.contains(dog) + " "+ favorites.contains(cat));
	
		user.setFavorites(favorites);
		
		int size = user.getFavorites().size();
		int expectedSize = 1;
		assertThat(size).isEqualTo(expectedSize);	
	}
	

}
