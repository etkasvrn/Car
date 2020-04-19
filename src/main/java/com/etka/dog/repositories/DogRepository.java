package com.etka.dog.repositories;

import com.etka.dog.models.Dog;
import org.springframework.data.repository.CrudRepository;


public interface DogRepository extends CrudRepository<Dog, Long> {

}
