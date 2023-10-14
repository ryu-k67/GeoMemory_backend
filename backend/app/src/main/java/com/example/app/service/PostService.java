package com.example.app.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.app.models.Post;
import com.example.app.models.PostRequest;
import com.example.app.repositories.PostRepository;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class PostService {
    @Autowired
    PostRepository postRepository;

    public Mono<Post> save(Post post) {
    return postRepository.save(post);
    }

    public Mono<Void> post(PostRequest postRequest) {
        var post = new Post();
        post.setContent(postRequest.getContent());
        // post.setPostimg(postRequest.getPostimg());
        post.setPostimg(null);
        post.setDatetime(postRequest.getDatetime());
        post.setLatitude(postRequest.getLatitude());
        post.setLongtitude(postRequest.getLongtitude());
        post.setUserid(postRequest.getUserid());
        return postRepository.save(post).then();
    }

    public Flux<Post> findAll() {
    return postRepository.findAll();
    }

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

    public Mono<Long> getPostNumber(int userid){
        return postRepository.findByUserid(userid).count();
        // .collectList()
        // .flatMap(s -> s.size());
    }
}
