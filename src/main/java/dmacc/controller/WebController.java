package dmacc.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import dmacc.beans.Animal;
import dmacc.beans.User;
import dmacc.repository.AnimalRepository;
import dmacc.repository.UserRepository;

@Controller
public class WebController {
	@Autowired
	AnimalRepository repo;
	
	@Autowired
	UserRepository uRepo;
	
	@GetMapping("/viewAll")
	public String viewAllAnimals(Model model) {
		model.addAttribute("animals", repo.findAll());
		System.out.println(repo.findAll());
		return "results";
	}
	
	@GetMapping("/viewAllUsers")
	public String viewAllUsers(Model model) {
		model.addAttribute("users", uRepo.findAll());
		return "allusers";
	}
	
	@GetMapping("/inputAnimal")
	public String addNewContact(Model model) {
		Animal a = new Animal();
		model.addAttribute("newAnimal", a);
		return "input";
	}
	
	@PostMapping("/inputAnimal")
	public String addNewAnimal(@ModelAttribute Animal a, Model model) {
		repo.save(a);
		return viewAllAnimals(model);
	}
	
	@GetMapping("/inputUser")
	public String addNewUser(Model model) {
		User u = new User();
		model.addAttribute("newUser", u);
		return "inputuser";
	}
	
	@PostMapping("/inputUser")
	public String addNewUser(@ModelAttribute User u, Model model) {
		uRepo.save(u);
		return viewAllUsers(model);
	}
	
	
	@GetMapping("/edit/{id}")
	public String showUpdateAnimal(@PathVariable("id") long id, Model model) {
		Animal a = repo.findById(id).orElse(null);
		model.addAttribute("newAnimal", a);
		return "input";
	}
	
	@GetMapping("/edituser/{id}")
	public String showUpdateUser(@PathVariable("id") long id, Model model) {
		User u = uRepo.findById(id).orElse(null);
		model.addAttribute("newUser", u);
		return "inputuser";
	}
	
	@GetMapping("/displayuser/{id}")
	public String showUserFavorites(@PathVariable("id") long id, Model model) {
		User u = uRepo.findById(id).orElse(null);
		model.addAttribute("currentUser", u);
		return "currentuser";
	}
	
	@GetMapping("/addfavorite/{id}")
	public String selectFavoriteAnimal(@PathVariable("id") long id, Model model) {
		User u = uRepo.findById(id).orElse(null);
		// above should grab username as well, how do we do this??
		// need favorites page for users.. I guess we kind of have it with all users
		model.addAttribute("currentUser", u);
		model.addAttribute("animals", repo.findAll());
		return "addfavoriteanimal";
	}
	
	@GetMapping("/addfavoritetolist/{id}/{userId}")
	public String addFavoriteAnimal(@PathVariable("id") long id, @PathVariable("userId") long userId, Model model) {
		Animal a = repo.findById(id).orElse(null);
		User u = uRepo.findById(userId).orElse(null);
		// above should grab username as well, how do we do this??
		// need favorites page for users.. I guess we kind of have it with all users
		List <Animal> favorites = u.getFavorites();
		favorites.add(a);
		u.setFavorites(favorites);
		uRepo.save(u);
		model.addAttribute("currentUser", u);
		return "currentuser";
	}
	
	@GetMapping("/deletefavorite/{id}/{userId}")
	public String deleteFavorite(@PathVariable("id") long id, @PathVariable("userId") long userId, Model model) {
		User u = uRepo.findById(userId).orElse(null);
		List<Animal> favorites = u.getFavorites();
		int indexToDelete = 0;
		for (int i = 0; i < favorites.size(); i++) {
			if (favorites.get(i).getId() == id) {
				indexToDelete = i;
			}
		}
		favorites.remove(indexToDelete);
		u.setFavorites(favorites);
		uRepo.save(u);
		model.addAttribute("currentUser", u);
		return "currentuser";
	}
	
	@PostMapping("/update/{id}")
	public String reviseAnimal(Animal a, Model model) {
		repo.save(a);
		return viewAllAnimals(model);
	}
	
	@PostMapping("/updateUser/{id}")
	public String reviseUser(User u, Model model) {
		uRepo.save(u);
		return viewAllUsers(model);
	}
	
	@GetMapping("/delete/{id}")
	public String deleteAnimal(@PathVariable("id") long id, Model model) {
		Animal a = repo.findById(id).orElse(null);
		repo.delete(a);
		return viewAllAnimals(model);
	}
	
	@GetMapping("/deleteuser/{id}")
	public String deleteUser(@PathVariable("id") long id, Model model) {
		User u = uRepo.findById(id).orElse(null);
		uRepo.delete(u);
		return viewAllUsers(model);
	}
	/**
	@PostMapping("/searchSpecies")
	public String searchSpecies(String species, Model model) {
		model.addAttribute("animalsSearch", repo.findBySpecies(species));
		System.out.println(repo.findBySpecies(species));
		return "resultsSearch";
	}

	@GetMapping("/getSearchSpecies")
	public String getSearchSpecies(String species, Model model) {
		return "inputSearch";
	}**/
	
	//Allows you to search all animals by a given keyword
	@PostMapping("/search")
	public String search(String keyword, Model model) {
		List<Animal> a = repo.searchAnimal(keyword);
		model.addAttribute("animalsSearch", a);
		if (a.isEmpty()) {
			System.out.println("Search returned nothing.");
			return "inputSearch";
		}
		System.out.println(repo.searchAnimal(keyword));
		return "resultsSearch";
	}

	@GetMapping("/getSearch")
	public String getSearch(String keyword, Model model) {
		return "inputSearch";
	}

}
