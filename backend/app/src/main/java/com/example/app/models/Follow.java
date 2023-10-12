package com.example.app.models;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "follow")
public class Follow {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int followId;

    private int userId;

    private int followedUserId;

    public Follow(){

    }

    public Follow(int followId, int userId, int followedUserId){
        this.followId = followId;
        this.userId = userId;
        this.followedUserId = followedUserId;
    }
}
