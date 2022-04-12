package dmacc.beans;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import lombok.Data;


@Entity
@Data
public class Animal {
	@Id
	@GeneratedValue
	public long id;
	public String species;
	public String name;
	public String breed;
	public String size;
	public String color;
	public String image;
	
	public Animal() {
		super();
	}
	

	public Animal(String species, String name, String breed, String size) {
		super();
		this.species = species;
		this.name = name;
		this.breed = breed;
		this.size = size;
	}
	
	
	
	public Animal(long id, String species, String name, String breed, String size, String color, String image) {
		super();
		this.id = id;
		this.species = species;
		this.name = name;
		this.breed = breed;
		this.size = size;
		this.color = color;
		this.image = image;
	}
	
}
