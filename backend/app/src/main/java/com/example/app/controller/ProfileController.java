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

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/api")
public class ProfileController {
    @Autowired
    ProfileService profileService;

    //プロフィールの登録
    @PostMapping("/registProfile")
    @ResponseStatus(HttpStatus.OK)
    public void registProfile(@RequestBody ProfileRequest profileRequest){
        profileService.registProfile(profileRequest);
        return;
    }
}
