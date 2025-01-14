package com.example.Student.Backend.with.MongoD.repository;

import java.util.Optional;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.example.Student.Backend.with.MongoD.model.ERole;
import com.example.Student.Backend.with.MongoD.model.Role;

public interface RoleRepository extends MongoRepository<Role, String> {
    Optional<Role> findByName(ERole name);
  }