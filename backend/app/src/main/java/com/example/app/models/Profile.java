package com.example.app.models;

import org.springframework.data.annotation.Id;

// import jakarta.persistence.Column;
// import jakarta.persistence.Entity;
// import jakarta.persistence.Table;
import lombok.Data;

@Data
// @Entity
// @Table(name = "profile")
public class Profile {
    @Id
    //@Column(name = "userId")
    public int userId;

    //@Column(name = "userName")
    private String userName;

    //@Column(name = "prof_img")
    private byte[] profImg;

    //@Column(name = "followingNumber")
    private int followingNumber;

    //@Column(name = "followerNumber")
    private int followerNumber;

    //@Column(name = "postNumber")
    private int postNumber;

    public Profile(){

    }

    public Profile(int userId, String userName, byte[] profImg, int followingNumber, int followerNumber, int postNumber){
        this.userId = userId;
        this.userName = userName;
        this.profImg = profImg;
        this.followingNumber = followingNumber;
        this.followerNumber = followerNumber;
        this.postNumber = postNumber;
    }

}
