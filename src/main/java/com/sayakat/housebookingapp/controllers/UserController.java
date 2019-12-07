package com.sayakat.housebookingapp.controllers;


import com.sayakat.housebookingapp.exception.ResourceNotFoundException;
import com.sayakat.housebookingapp.model.User;
import com.sayakat.housebookingapp.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Optional;

@RestController
@RequestMapping("/api/users")
public class UserController {

    @Autowired
    private UserRepository userRepository;


    @GetMapping("/{id}")
    private ResponseEntity<User> getOne(@PathVariable Long id) {
        Optional<User> optionalUser = userRepository.findById(id);
        if (optionalUser.isPresent()) {
            return ResponseEntity.ok(optionalUser.get());
        }
        return ResponseEntity.notFound().build();
    }

    @GetMapping("/")
    public Page<User> fetchAllPosts(Pageable pageable) {
        return userRepository.findAll(pageable);
    }

    @PostMapping("/")
    public ResponseEntity<User> create(@Valid @RequestBody User user) {
        User createUser = userRepository.save(user);
        return ResponseEntity.status(HttpStatus.CREATED).body(createUser);
    }


    //    @PutMapping("/{id}")
//    public User update(@PathVariable Long id,@Valid @RequestBody User userRequest) {
//        return userRepository.findById(id).map(user -> {
//            user.setTitle(user.getTitle());
//            user.setDescription(user.getDescription());
//            user.setContent(user.getContent());
//            return userRepository.save(user);
//        }).orElseThrow(() -> new ResourceNotFoundException("User: " + id + " NotFound"));
//    }

}
