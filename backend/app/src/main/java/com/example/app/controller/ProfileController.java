package com.example.app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.example.app.models.Profile;
import com.example.app.models.ProfileRequest;
import com.example.app.service.ProfileService;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/api/profile")
public class ProfileController {
    @Autowired
    ProfileService profileService;

    //プロフィールの登録
    @PostMapping("/regist")
    @ResponseStatus(HttpStatus.OK)
    public Mono<Void> registProfile(@RequestBody ProfileRequest profileRequest){
        return profileService.registProfile(profileRequest);
    }

    // プロフィールの取得
    @GetMapping("/get/{id}")
    public Mono<Profile> getProfile(@PathVariable("id") int userid){
        return profileService.getProfile(userid);
    }

    // プロフィールの更新
    @PutMapping("/update")
    public Mono<Void> updateProfile(@RequestBody ProfileRequest profileRequest){
        return profileService.updateProfile(profileRequest);
    }

    // プロフィールの全件取得
    @GetMapping("/get/all")
    public Flux<Profile> getProfileAll(){
        return profileService.findAll();
    }
}
