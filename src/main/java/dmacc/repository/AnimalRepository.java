package dmacc.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import dmacc.beans.Animal;

@Repository
public interface AnimalRepository extends JpaRepository<Animal, Long>{

	/**
	 * @return
	 */
	List<Animal> findBySpecies(String species);
	
	@Query("SELECT a FROM Animal a WHERE CONCAT(a.species, ' ', a.name, ' ', a.breed, ' ', a.size, ' ', a.color) LIKE %?1%")
	public List<Animal> searchAnimal(String keyword);

}
