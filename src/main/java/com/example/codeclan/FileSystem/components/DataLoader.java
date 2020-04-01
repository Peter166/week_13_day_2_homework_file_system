package com.example.codeclan.FileSystem.components;

import com.example.codeclan.FileSystem.models.File;
import com.example.codeclan.FileSystem.models.Folder;
import com.example.codeclan.FileSystem.models.User;
import com.example.codeclan.FileSystem.repositories.FileRepository;
import com.example.codeclan.FileSystem.repositories.FolderRepository;
import com.example.codeclan.FileSystem.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

@Component
public class DataLoader implements ApplicationRunner {

    @Autowired
    FileRepository fileRepository;
    @Autowired
    FolderRepository folderRepository;
    @Autowired
    UserRepository userRepository;

    public DataLoader() {
    }

    public void run(ApplicationArguments args){
        User peter = new User("Peter");
        userRepository.save(peter);

        User bob = new User("Bob");
        userRepository.save(bob);

        Folder downloads = new Folder("Downloads");
        downloads.addUser(bob);
        downloads.addUser(peter);
        folderRepository.save(downloads);
        Folder documents = new Folder("Documents");
        documents.addUser(bob);
        documents.addUser(peter);
        folderRepository.save(documents);

        File macOsInstall = new File("MacOsInstall", ".dmg", 1000, downloads);
        fileRepository.save(macOsInstall);
        File picture = new File("holiday", ".jpg", 12, documents);
        fileRepository.save(picture);




    }
}
