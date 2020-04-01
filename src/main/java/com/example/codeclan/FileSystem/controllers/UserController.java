package com.example.codeclan.FileSystem.controllers;

import com.example.codeclan.FileSystem.models.User;
import com.example.codeclan.FileSystem.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Repository
@RequestMapping(value = "/users")
public class UserController {

    @Autowired
    UserRepository userRepository;

    @GetMapping
    public ResponseEntity<List<User>> getrAllUsers(){
        return new ResponseEntity<>(userRepository.findAll(), HttpStatus.OK);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<Optional<User>> getUser(@PathVariable Long id){
        return new ResponseEntity<>(userRepository.findById(id), HttpStatus.OK);
    }
    @PostMapping()
    public ResponseEntity createUser(@RequestBody User user){
        userRepository.save(user);
        return new ResponseEntity(user, HttpStatus.CREATED);
    }
}
