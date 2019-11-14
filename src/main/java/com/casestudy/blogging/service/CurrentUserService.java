package com.casestudy.blogging.service;

import com.casestudy.blogging.model.Blogs;
import com.casestudy.blogging.model.User;
import com.casestudy.blogging.repository.BlogsRepository;
import com.casestudy.blogging.repository.UserRepository;
import com.casestudy.blogging.repository.UserRepositoryClass;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.security.Principal;
import java.time.Instant;
import java.util.ArrayList;
import java.util.Optional;

@Service
public class CurrentUserService {
    @Autowired
    UserRepository usersRepository;

    @Autowired
    UserRepositoryClass userRepositoryClass;

    @Autowired
    BlogsRepository blogsRepository;


    public User getUser(Principal principal) {
        Optional<User> users = usersRepository.findByUsername(principal.getName());
        return users.get();
    }

    public String addPost(Blogs blogs,Principal principal) {
        Optional<User> user = userRepositoryClass.getByUsername(principal.getName());
        blogs.setCreatedOn(Instant.now());
        blogs.setUpdatedOn(Instant.now());
        blogs.setUser(user.get());
        blogs.setUsername(principal.getName());
        blogsRepository.save(blogs);
        return "\"Post created\"";
    }

    public ArrayList<Blogs> show(Principal principal) {
        String user = principal.getName();
        Optional<User> users = usersRepository.findByUsername(user);
        return blogsRepository.findAllByUser(users);
    }

    @Transactional
    public String delete(Long blogId) {
        blogsRepository.deleteById(blogId);
        return "\"Blog deleted\"";
    }
}
