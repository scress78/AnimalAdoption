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
	
	
	
	@Override
	public String toString() {
		return "Animal [id=" + id + ", species=" + species + ", name=" + name + ", breed=" + breed + ", size=" + size
				+ ", color=" + color + ", image=" + image + "]";
	}

	/**
	public long getId() {
		return id;
	}


	public void setId(long id) {
		this.id = id;
	}


	public String getSpecies() {
		return species;
	}


	public void setSpecies(String species) {
		this.species = species;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public String getBreed() {
		return breed;
	}


	public void setBreed(String breed) {
		this.breed = breed;
	}


	public String getSize() {
		return size;
	}


	public void setSize(String size) {
		this.size = size;
	}


	public String getColor() {
		return color;
	}


	public void setColor(String color) {
		this.color = color;
	}


	public String getImage() {
		return image;
	}


	public void setImage(String image) {
		this.image = image;
	}
	**/

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
