package com.example.app.repositories;

import org.springframework.data.r2dbc.repository.R2dbcRepository;
import org.springframework.stereotype.Repository;

import com.example.app.models.Post;

@Repository
public interface PostRepository extends R2dbcRepository<Post, Integer> {
    
}
