package com.example.app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.example.app.models.ProfileRequest;
import com.example.app.service.ProfileService;

import reactor.core.publisher.Mono;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/api")
public class ProfileController {
    @Autowired
    ProfileService profileService;

    //プロフィールの登録
    @PostMapping("/profile/register")
    @ResponseStatus(HttpStatus.OK)
    public Mono<Integer> registProfile(@RequestBody ProfileRequest profileRequest){
        return profileService.registProfile(profileRequest);
    }
}
