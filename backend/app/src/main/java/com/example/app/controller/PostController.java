package com.example.app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.example.app.models.Post;
import com.example.app.models.PostRequest;
import com.example.app.service.PostService;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/api/post")
public class PostController {
    @Autowired
    PostService postService;

    //投稿登録処理
    @PostMapping("/post")
    @ResponseStatus(HttpStatus.OK)
    public Mono<Void> post(@RequestBody PostRequest postRequest) {
        return postService.post(postRequest);
    }

    // 投稿数を取得
    @GetMapping("/getNumber/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Mono<Long> getPostNumber(@PathVariable("id") int userid) {
        return postService.getPostNumber(userid);
    }

    //投稿全権取得処理
    @GetMapping("/get")
    @ResponseStatus(HttpStatus.OK)
    public Flux<Post> getAllPosts() {
        return postService.findAll();
    // if (title == null)
    //    return appService.findAll();
    // else
    //    return appService.findByTitleContaining(title);
    // }
    }
}
