package com.sayakat.housebookingapp.controllers;


import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.sayakat.housebookingapp.model.User;
import com.sayakat.housebookingapp.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/api/users")
public class UserController {

    @Autowired
    private ObjectMapper objectMapper;

    @Autowired
    private UserRepository userRepository;

    @GetMapping("/")
    public Page<User> getAll(Pageable pageable) {
        return userRepository.findAll(pageable);
    }

    @GetMapping("/{id}")
    public ResponseEntity<User> getOne(@PathVariable Long id) {
        Optional<User> optionalUser = userRepository.findById(id);
        if (optionalUser.isPresent()) {
            return ResponseEntity.ok(optionalUser.get());
        }
        return ResponseEntity.notFound().build();
    }

    @PostMapping("/")
    public ResponseEntity<User> create(@RequestBody User user) {
        User createUser = userRepository.save(user);
        return ResponseEntity.status(HttpStatus.CREATED).body(createUser);
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity<User> update(@RequestBody User user, @PathVariable Long id) throws JsonMappingException {

        User savedUser = userRepository.findById(id).get();
        objectMapper.setSerializationInclusion(JsonInclude.Include.NON_NULL);
        savedUser = objectMapper.updateValue(savedUser, user);
        userRepository.save(savedUser);
        return ResponseEntity.ok(savedUser);
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Object> delete(@PathVariable Long id) {
        userRepository.deleteById(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

}
