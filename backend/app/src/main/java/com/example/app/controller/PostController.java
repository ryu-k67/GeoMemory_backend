package com.example.app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.example.app.models.PostRequest;
import com.example.app.service.PostService;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/api/post")
public class PostController {
    @Autowired
    PostService postService;

    //ポスト処理
    @PostMapping("/post")
    @ResponseStatus(HttpStatus.OK)
    public void post(@RequestBody PostRequest postRequest) {
        postService.post(postRequest);
        return;
    }

}
