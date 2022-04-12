package dmacc.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import dmacc.beans.Animal;

@Repository
public interface AnimalRepository extends JpaRepository<Animal, Long>{

	/**
	 * @return
	 */
	List<Animal> findBySpecies(String species);

}
