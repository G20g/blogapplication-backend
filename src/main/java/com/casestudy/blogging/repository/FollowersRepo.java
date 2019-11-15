package com.casestudy.blogging.repository;

import com.casestudy.blogging.model.Followers;
import com.casestudy.blogging.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.Optional;

@Repository
public interface FollowersRepo extends JpaRepository<Followers, Long> {

    ArrayList<Followers> findAllByUsers(Optional<User> users);

    void deleteByUsersAndUsers1(Optional<User> users, Optional<User> users1);
}
