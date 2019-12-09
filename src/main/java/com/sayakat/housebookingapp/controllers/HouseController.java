package com.sayakat.housebookingapp.controllers;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.sayakat.housebookingapp.model.House;
import com.sayakat.housebookingapp.repository.HouseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/houses")
public class HouseController {

    @Autowired
    private HouseRepository houseRepository;

    @Autowired
    private ObjectMapper objectMapper;

    @GetMapping("/{id}")
    public ResponseEntity<House> findOne(@PathVariable Long id) {
        House house = houseRepository.findById(id).get();
        return new ResponseEntity<>(house, HttpStatus.OK);
    }

    @GetMapping(value = "/")
    public Page<House> getAll(Pageable pageable) {
        return houseRepository.findAll(pageable);
    }

    //    @ApiOperation(value = "create house")
    @PostMapping(value = "/")
    public ResponseEntity<House> create(@RequestBody House house) {
        House savedHouse = houseRepository.save(house);
        return ResponseEntity.status(HttpStatus.CREATED).body(savedHouse);
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity<House> update(@RequestBody House house, @PathVariable Long id) throws JsonMappingException {

        House savedHouse = houseRepository.findById(id).get();
        objectMapper.setSerializationInclusion(JsonInclude.Include.NON_NULL);
        savedHouse = objectMapper.updateValue(savedHouse, house);
        houseRepository.save(savedHouse);
        return ResponseEntity.ok(savedHouse);
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Object> delete(@PathVariable Long id) {
        houseRepository.deleteById(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

}
