package com.etka.car.controllers;
import com.etka.car.models.Car;
import com.etka.car.repositories.CarRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@Slf4j
@RestController
@RequestMapping(path = "/cars")
public class CarController {

    @Autowired
    CarRepository carRepository;

    @GetMapping
    public ResponseEntity<List<Car>> getAllCars(){
        System.out.println("GET ALL CARS CALLED");
        List<Car> list = (List<Car>) carRepository.findAll();
        return ResponseEntity.ok(list);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Optional<Car>> getCar(@PathVariable("id")Long id){
        System.out.println("GET ALL CARS CALLED");
        Optional<Car>  optional = (Optional<Car>) carRepository.findById(id);
        return ResponseEntity.ok(optional);
    }

    @PostMapping
    public ResponseEntity<Car> save(@RequestBody Car car){
        System.out.println("saving car to db: " + car);
        return ResponseEntity.ok(carRepository.save(car));
    }
    @PutMapping("/{id}")
    public ResponseEntity<Car> carUpdate(@PathVariable("id")Long id, @RequestBody Car car){
        car.setId(id);

        return ResponseEntity.ok(carRepository.save(car));
    }

    @DeleteMapping("/{id}")
    public Map<String, Boolean> delete(@PathVariable(value = "id") Long id){


        carRepository.deleteById(id);
        Map<String, Boolean> response = new HashMap<>();
        response.put("deleted", Boolean.TRUE);
        return response;

    }

}
