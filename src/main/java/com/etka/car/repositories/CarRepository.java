package com.etka.car.repositories;

import com.etka.car.models.Car;
import org.springframework.data.repository.CrudRepository;


public interface CarRepository extends CrudRepository<Car, Long> {

}
