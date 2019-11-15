package com.casestudy.blogging.service;

import com.casestudy.blogging.model.Blogs;
import com.casestudy.blogging.model.Comments;
import com.casestudy.blogging.model.User;
import com.casestudy.blogging.repository.BlogsRepository;
import com.casestudy.blogging.repository.CommentRepository;
import com.casestudy.blogging.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.security.Principal;
import java.util.Optional;

@Service
public class CommentService {

    @Autowired
    UserRepository userRepository;

    @Autowired
    BlogsRepository blogsRepository;

    @Autowired
    CommentRepository commentRepository;


    public String postComment(Principal principal,Long blogId,String comment) {
        Optional<User> user = userRepository.findByUsername(principal.getName());
        Optional<Blogs> blogs = blogsRepository.findById(blogId);
        Comments comments = new Comments();
        comments.setUser(user.get());
        comments.setBlogs(blogs.get());
        comments.setComment(comment);
        commentRepository.save(comments);
        return "\"Comment Added\"";
    }
}
