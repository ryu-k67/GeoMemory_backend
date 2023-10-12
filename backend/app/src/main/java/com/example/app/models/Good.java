package com.example.app.models;

import org.springframework.data.annotation.Id;

// import jakarta.persistence.Entity;
// import jakarta.persistence.GeneratedValue;
// import jakarta.persistence.GenerationType;
// import jakarta.persistence.Id;
// import jakarta.persistence.Table;
import lombok.Data;

@Data
// @Entity
// @Table(name = "good")
public class Good {
    @Id
    //@GeneratedValue(strategy = GenerationType.IDENTITY)
    private int goodId;

    private int userId;

    private int postId;

    public Good(){

    }
    
    public Good(int goodId, int userId, int postId){
        this.goodId = goodId;
        this.userId = userId;
        this.postId = postId;
    }
}
