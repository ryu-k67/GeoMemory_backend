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

import com.example.app.models.Follow;
import com.example.app.models.FollowRequest;
// import com.example.app.models.ProfileRequest;
// import com.example.app.repositories.FollowRepository;
import com.example.app.service.FollowService;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/api/follow")
public class FollowController {
    @Autowired
    FollowService followService;

    // フォロー関係の登録
    @PostMapping("/post")
    @ResponseStatus(HttpStatus.OK)
    public Mono<Integer> postFollow(@RequestBody FollowRequest followRequest){
        return followService.post(followRequest);
    }
    
    // 自分がフォローしてる人を取得
    @GetMapping("/get/{id}")
    public Flux<Follow> getFollow(@PathVariable("id") int userid){
        return followService.get(userid);
    }
}
