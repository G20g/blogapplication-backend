package com.casestudy.blogging.service;

import com.casestudy.blogging.model.Followers;
import com.casestudy.blogging.model.User;
import com.casestudy.blogging.repository.FollowersRepo;
import com.casestudy.blogging.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.security.Principal;
import java.util.ArrayList;
import java.util.Optional;

@Service
public class FollowerService {

    @Autowired
    FollowersRepo followersRepo;

    @Autowired
    UserRepository usersRepo;

    public ArrayList<Followers> getFollowers(Principal principal) {
        String email = principal.getName();
        Optional<User> users = usersRepo.findByUsername(email);
        return followersRepo.findAllByUsers(users);
    }
    public String addFollower(Principal principal, Long id) {
        Optional<User> users = usersRepo.findById(id);
        Optional<User> users1 = usersRepo.findByUsername(principal.getName());
        //ArrayList<Followers> followers = getFollowersFromCurrentUser(principal);
        Followers followers = new Followers();
        followers.setUsers1(users.get());
        followers.setUsers(users1.get());
        followersRepo.save(followers);
        return "\"Follower added\"";
    }

    @Transactional
    public String deleteFromFollowers(Long id,Principal principal)
    {
        Optional<User> users1= usersRepo.findById(id);
        Optional<User> users = usersRepo.findByUsername(principal.getName());
        followersRepo.deleteByUsersAndUsers1(users,users1);
        return "\"Follower deleted\"";
    }
}
