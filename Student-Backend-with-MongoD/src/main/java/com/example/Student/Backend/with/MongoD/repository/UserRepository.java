package com.example.Student.Backend.with.MongoD.repository;

import java.util.Optional;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.example.Student.Backend.with.MongoD.model.User;
@Repository
public interface UserRepository extends MongoRepository<User, String> {
    Optional<User> findByUsername(String username);
  
    Boolean existsByUsername(String username);
  
    Boolean existsByEmail(String email);
  }