package com.casestudy.blogging.repository;

import com.casestudy.blogging.model.Blogs;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BlogsRepository extends JpaRepository<Blogs, Long> {

    public List<Blogs>findAllByCategory(String cat);
}
