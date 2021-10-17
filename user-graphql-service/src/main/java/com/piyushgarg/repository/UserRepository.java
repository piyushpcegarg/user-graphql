package com.piyushgarg.repository;

import java.util.UUID;

import com.piyushgarg.model.User;

import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<User, UUID> {
    
}
