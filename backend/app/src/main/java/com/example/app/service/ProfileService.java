package com.example.app.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.app.models.Profile;
import com.example.app.models.ProfileRequest;
import com.example.app.repositories.ProfileRepository;

import reactor.core.publisher.Mono;

@Service
public class ProfileService {
    @Autowired
    ProfileRepository profileRepository;

    public Mono<Integer> registProfile(ProfileRequest profileRequest){
        var profile = new Profile();
        String username = profileRequest.getUsername();
        //byte[] profImg = profileRequest.getProf_img();
        int userid = profileRequest.getUserid();

        profile.setFollowernumber(0);
        profile.setFollowingnumber(0);
        profile.setPostnumber(0);
        profile.setProfimg(null);
        profile.setUsername(username);
        profile.setUserid(userid);
        return profileRepository.save(profile)
        .map(savedProfile -> savedProfile.getUserid())
        .onErrorReturn(-1);
    }

    // プロフィールの取得
    public Mono<Profile> getProfile(int userid){
        return profileRepository.findById(userid);
    }
}