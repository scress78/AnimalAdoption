package dmacc.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import dmacc.beans.Animal;

@Repository
public interface AnimalRepository extends JpaRepository<Animal, Long>{

}
