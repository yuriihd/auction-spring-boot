package com.example.comments;

import org.springframework.data.repository.CrudRepository;


import java.util.List;

/**
 * Created by Yurii on 26.03.2017.
 */
public interface CommentRepository extends CrudRepository<Comment, String> {

    public List<Comment> findByFromWhom (String username);
    public List<Comment> findByToWhom (String username);
}
