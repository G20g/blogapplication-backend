package com.casestudy.blogging.repository;

import com.casestudy.blogging.model.Blogs;
import com.casestudy.blogging.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Repository
public interface BlogsRepository extends JpaRepository<Blogs, Long> {

    public List<Blogs>findAllByCategory(String cat);
    public List<Blogs>findAllByContentContaining(String str);
    public ArrayList<Blogs> findAllByUser(Optional<User> users);
    public List<Blogs>findAllByOrderByUpdatedOnDesc();

    public void deleteById(Long id);
}
