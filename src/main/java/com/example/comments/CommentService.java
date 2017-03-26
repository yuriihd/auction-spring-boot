package com.example.comments;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Yurii on 26.03.2017.
 */
@Service
public class CommentService {
    @Autowired
    private CommentRepository commentRepository;


    public List<Comment> getAllFromComments(String username){
        System.out.println(1);
        List<Comment> comments = new ArrayList<>();
        commentRepository.findByFromWhomUsername(username)
                .forEach(comments::add);
        return comments;

    }

    public List<Comment> getAllToComments(String username){

        System.out.println(0);
        List<Comment> comments = new ArrayList<>();
        commentRepository.findByToWhomUsername(username)
                .forEach(comments::add);

        return comments;

    }

    public void addComment(Comment comment) {

        commentRepository.save(comment);
    }


}
