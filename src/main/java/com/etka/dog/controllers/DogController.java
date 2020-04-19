package com.etka.dog.controllers;
import com.etka.dog.models.Dog;
import com.etka.dog.repositories.DogRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@Slf4j
@RestController
@RequestMapping(path = "/dogs")
public class DogController {

    @Autowired
    DogRepository dogRepository;

    @GetMapping
    public ResponseEntity<List<Dog>> getAllDogs(){
        System.out.println("GET ALL DOGS CALLED");
        List<Dog> list = (List<Dog>) dogRepository.findAll();
        return ResponseEntity.ok(list);
    }

    @PostMapping
    public ResponseEntity<Dog> save(@RequestBody Dog dog){
        System.out.println("saving dog to db: " + dog);
        return ResponseEntity.ok(dogRepository.save(dog));
    }
    @PutMapping
    public ResponseEntity<Dog> update(@RequestBody Dog dog, @PathVariable("id") Long id)
           /* throws ResourceNotFoundException*/ {
       /* Dog dog1 = dogRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Dog not found for this id :: " + id));*/


        return ResponseEntity.ok(dogRepository.save(dog));
    }
}
