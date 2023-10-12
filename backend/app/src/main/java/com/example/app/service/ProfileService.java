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
        String userName = profileRequest.getUsername();
        //byte[] profImg = profileRequest.getProf_img();
        int userId = profileRequest.getUserid();

        profile.setFollowernumber(0);
        profile.setFollowingnumber(0);
        profile.setPostnumber(0);
        //profile.setProfimg(profImg);
        profile.setUsername(userName);
        profile.setUserid(userId);
        profileRepository.save(profile);
        return;
    }
}