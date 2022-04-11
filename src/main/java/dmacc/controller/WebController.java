package dmacc.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import dmacc.beans.Animal;
import dmacc.repository.AnimalRepository;

@Controller
public class WebController {
	@Autowired
	AnimalRepository repo;
	
	@GetMapping("/viewAll")
	public String viewAllAnimals(Model model) {
		model.addAttribute("animals", repo.findAll());
		return "results";
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

}