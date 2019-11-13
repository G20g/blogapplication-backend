package com.casestudy.blogging.repository;

import com.casestudy.blogging.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class UserRepositoryClass {

    @Autowired
    public UserRepository userRepository;

    public Optional<User> getByUsername(String username) {
        System.out.println("getting by Username");
        return userRepository.findByUsername(username);
    }
}
