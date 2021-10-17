package com.piyushgarg.controller;

import java.util.UUID;

import com.piyushgarg.model.User;
import com.piyushgarg.model.UserDTO;
import com.piyushgarg.repository.UserRepository;

import org.springframework.beans.BeanUtils;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;

@Controller
public class UserController {

    private final UserRepository userRepository;

    public UserController(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @QueryMapping
    public Iterable<User> getAllUsers() {
        return userRepository.findAll();
    }

    @QueryMapping
    public User getUserById(@Argument UUID id) {
        return userRepository.findById(id).orElseThrow();
    }

    @MutationMapping
    public User addUser(@Argument UserDTO userDTO) {
        User user = new User();
        BeanUtils.copyProperties(userDTO, user);
        user.setId(UUID.randomUUID());
        return userRepository.save(user);
    }

    @MutationMapping
    public User updateUser(@Argument UUID id, @Argument UserDTO userDTO) {
        User user = userRepository.findById(id).orElseThrow();
        BeanUtils.copyProperties(userDTO, user);
        return userRepository.save(user);
    }

    @MutationMapping
    public User deleteUser(@Argument UUID id) {
        User user = userRepository.findById(id).orElseThrow();
        userRepository.deleteById(id);
        return user;
    }
}
