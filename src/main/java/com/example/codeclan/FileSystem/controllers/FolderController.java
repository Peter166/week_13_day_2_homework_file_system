package com.example.codeclan.FileSystem.controllers;

import com.example.codeclan.FileSystem.models.Folder;
import com.example.codeclan.FileSystem.repositories.FolderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.xml.ws.Response;
import java.util.List;
import java.util.Optional;

@RestController

@RequestMapping(value = "/folders")
public class FolderController {

    @Autowired
    FolderRepository folderRespository;

    @GetMapping
    public ResponseEntity<List<Folder>> getAllFolders(){
        return new ResponseEntity<>(folderRespository.findAll(), HttpStatus.OK);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<Optional<Folder>> getFolders(@PathVariable Long id){
        return new ResponseEntity<>(folderRespository.findById(id), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity postFolder(@RequestBody Folder folder){
        folderRespository.save(folder);
        return new ResponseEntity(folder, HttpStatus.CREATED);
    }


}
