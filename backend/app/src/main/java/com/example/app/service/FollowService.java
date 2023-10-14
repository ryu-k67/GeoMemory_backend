package com.example.app.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.app.models.Follow;
import com.example.app.models.FollowRequest;
import com.example.app.repositories.FollowRepository;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class FollowService {
    @Autowired
    FollowRepository followRepository;

    public Mono<Void> post(FollowRequest followRequest){
        var follow = new Follow();

        follow.setUserid(followRequest.getUserid());
        follow.setFollowinguserid(followRequest.getFollowinguserid());

        return followRepository.save(follow).then();
        // .map(savedFollow -> savedFollow.getFollowid())
        // .onErrorReturn(-1);
    }

    public Flux<Follow> get(int userid){
        return followRepository.findByUserid(userid);
    }

    public Mono<Long> getFollowingNumber(int userid){
        return followRepository.findByUserid(userid).count();
        // .collectList()
        // .flatMap(s -> s.size());
    }

    public Mono<Long> getFollowerNumber(int followinguserid){
        return followRepository.findByFollowinguserid(followinguserid).count();
        // .collectList()
        // .flatMap(s -> s.size());
    }
    
}
