package com.example.codeclan.FileSystem;

import com.example.codeclan.FileSystem.models.File;
import com.example.codeclan.FileSystem.models.Folder;
import com.example.codeclan.FileSystem.models.User;
import com.example.codeclan.FileSystem.repositories.FileRepository;
import com.example.codeclan.FileSystem.repositories.FolderRepository;
import com.example.codeclan.FileSystem.repositories.UserRepository;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
class FileSystemApplicationTests {

	@Autowired
	FolderRepository folderRepository;

	@Autowired
	UserRepository userRepository;

	@Autowired
	FileRepository fileRepository;

	@Test
	void contextLoads() {
	}

	@Test
	public void canAddFolderAndUser(){
		Folder documents = new Folder("Documents");
		folderRepository.save(documents);

		User peter = new User("Peter");
		userRepository.save(peter);
		peter.addFolder(documents);
		userRepository.save(peter);

		File install = new File("Install", ".dmg", 100,documents);
		fileRepository.save(install);
	}

}
