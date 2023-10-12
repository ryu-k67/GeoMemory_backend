package com.example.app.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.app.models.Profile;
import com.example.app.models.ProfileRequest;
import com.example.app.repositories.ProfileRepository;

@Service
public class ProfileService {
    @Autowired
    ProfileRepository profileRepository;

    public void registProfile(ProfileRequest profileRequest){
        var profile = new Profile();
        String userName = profileRequest.getUserName();
        //byte[] profImg = profileRequest.getProf_img();
        int userid = profileRequest.getUserid();

        profile.setFollowerNumber(0);
        profile.setFollowingNumber(0);
        profile.setPostNumber(0);
        //profile.setProfImg(profImg);
        profile.setUserName(userName);
        profile.setUserid(userid);
        profileRepository.save(profile);
        return;
    }
}