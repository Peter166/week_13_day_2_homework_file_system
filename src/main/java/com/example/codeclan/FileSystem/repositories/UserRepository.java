package com.example.codeclan.FileSystem.repositories;

import com.example.codeclan.FileSystem.models.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
}
