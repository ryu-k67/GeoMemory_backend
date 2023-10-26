package com.example.app.controller;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

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
    @ResponseStatus(HttpStatus.CREATED)
    public Mono<Void> registProfile(@RequestBody ProfileRequest profileRequest){
        return profileService.registProfile(profileRequest);
    }

    @PostMapping("/regist/img")
    @ResponseStatus(HttpStatus.CREATED)
    public Mono<Integer> registProfileImg(
                    // @RequestPart("user") ProfileRequest profileRequest,
                    // @RequestPart("file") MultipartFile file
                    // @RequestParam(name = "id") int userid,
                    // @RequestParam(name = "name") String username,
                    @RequestParam(name = "file") MultipartFile file
                    )
                    // throws IOException
                    {

        System.out.println(file.getOriginalFilename());
                    
        return profileService.registProfileImg(
                        // profileRequest,
                        // userid,
                        // username,
                        file
                        );
    }

    // プロフィールの取得
    @GetMapping("/get/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Mono<Profile> getProfile(@PathVariable("id") int userid){
        return profileService.getProfile(userid);
    }

    // プロフィールの更新
    @PutMapping("/update")
    @ResponseStatus(HttpStatus.OK)
    public Mono<Void> updateProfile(@RequestBody ProfileRequest profileRequest){
        return profileService.updateProfile(profileRequest);
    }

    // プロフィールの全件取得
    @GetMapping("/get/all")
    @ResponseStatus(HttpStatus.OK)
    public Flux<Profile> getProfileAll(){
        return profileService.findAll();
    }
}
