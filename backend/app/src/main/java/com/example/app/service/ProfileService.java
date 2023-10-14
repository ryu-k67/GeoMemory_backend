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
        profile.setFollowernumber(0);
        profile.setFollowingnumber(0);
        profile.setPostnumber(0);
        profile.setProfimg(profileRequest.getProfimg());
        profile.setUsername(profileRequest.getUsername());
        profile.setUserid(profileRequest.getUserid());
        profile.setPostnumber(0);

        // return profileRepository.save(profile);
        return profileRepository.save(profile)
        .map(savedAccount -> savedAccount.getUserid())
        .onErrorReturn(-1);
    }

    // public Mono<Integer> regist(int userid) {
    //     var profile = new Profile();
    //     profile.setFollowernumber(0);
    //     profile.setFollowingnumber(0);
    //     profile.setPostnumber(0);
    //     profile.setProfimg(1,2,3,4,5);
    //     profile.setUsername("test");
    //     profile.setUserid(userid);
    //     profile.setPostnumber(0);

    //     // return profileRepository.save(profile);
    //     return profileRepository.save(profile)
    //     .map(savedAccount -> savedAccount.getUserid())
    //     .onErrorReturn(-1);
    //}
}