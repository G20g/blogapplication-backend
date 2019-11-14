package com.casestudy.blogging.controller;

import com.casestudy.blogging.model.User;
import com.casestudy.blogging.repository.UserRepository;
import com.casestudy.blogging.service.CurrentUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.security.Principal;
import java.util.List;

@RestController
@RequestMapping("/users")
@CrossOrigin(origins = "http://localhost:4200",allowedHeaders = "*")
public class UserController {

    @Autowired
    UserRepository usersRepository;

    @Autowired
    CurrentUserService currentUserService;

    @PostMapping("/addUsers")
    public User addUsers(@Valid @RequestBody User users) {
        users.setActive(1);
        usersRepository.save(users);
        return users;
    }
    @GetMapping(path = "/checkuser", produces = "application/json")
    public String checkLogin(Principal principal) {
        System.out.println("Logging in User.. "+principal.getName());
        return "\"Login Successful\"";
    }

    @GetMapping("/getUsers")
    public List<User> getUsers() {
        return usersRepository.findAll();
    }

    @GetMapping("/validate")
    public String valUser()
    {
        return "\"You Are Valid Authenticated User\"";
    }

    @GetMapping("/logUser")
    public User logUser(Principal principal) {
        return currentUserService.getUser(principal);
    }

    @PutMapping("/update")
    public User update(@Valid @RequestBody User users) {
        users.setActive(1);
        usersRepository.save(users);
        return users;
    }
}
