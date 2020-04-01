package com.example.codeclan.FileSystem.controllers;

import com.example.codeclan.FileSystem.models.File;
import com.example.codeclan.FileSystem.repositories.FileRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Repository
@RequestMapping(value = "/files")
public class FileController {

    @Autowired
    FileRepository fileRepository;

    @GetMapping
    public ResponseEntity<List<File>> getAllFiles(){
        return new ResponseEntity<>(fileRepository.findAll(), HttpStatus.OK);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<Optional<File>> getFile(@PathVariable Long id){
        return new ResponseEntity<>(fileRepository.findById(id), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity postFile(@RequestBody File file){
        fileRepository.save(file);
        return new ResponseEntity(file, HttpStatus.CREATED);
    }
}
