package com.example.codeclan.FileSystem.repositories;

import com.example.codeclan.FileSystem.models.File;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FileRepository extends JpaRepository<File, Long> {
}
