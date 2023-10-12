package com.example.app.service;

import org.springframework.beans.factory.annotation.Autowired;

import com.example.app.models.Post;
import com.example.app.repositories.PostRepository;

import reactor.core.publisher.Mono;

public class PostService {
    @Autowired
    PostRepository postRepository;

    public Mono<Post> save(Post post) {
    return postRepository.save(post);
    }

    //public Mono<Integer> post(PostRequest postRequest) {
    //    var post = new Post();
    //    post.setContent(postRequest.getContent());
    //    post.setDatetime(postRequest.getDatetime());
    //    post.setLatitude(postRequest.getLatitude());
    //    post.setLongtitude(postRequest.getLongtitude());
    //    post.setPostImg(postRequest.getPostImg());
    //    post.setUserid(postRequest.getUserid());
    //    post.setPostid(123);
    //    return save(post)
    //    .map(savedPost -> savedPost.getUserid())
    //    .onErrorReturn(-1);
    //}

    //public Post update(int id, Post post) {
    //return postRepository.findById(id).map(Optional::of).defaultIfEmpty(Optional.empty())
     //   .flatMap(optionalPost -> {
     //       if (optionalPost.isPresent()) {
     //       post.setUserid(id);
     //       return postRepository.save(post);
     //       }

     //       return Mono.empty();
     //   });
    //}
}
