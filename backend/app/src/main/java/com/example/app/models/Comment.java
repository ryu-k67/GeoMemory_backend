package com.example.app.models;

import java.time.LocalDateTime;

import org.springframework.data.annotation.Id;

// import jakarta.persistence.Entity;
// import jakarta.persistence.GeneratedValue;
// import jakarta.persistence.GenerationType;
// import jakarta.persistence.Table;
import lombok.Data;

@Data
// @Entity
// @Table(name = "comment")
public class Comment {
    @Id
    // @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int commentId;

    private int postId;

    private int userId;

    private String content;

    private LocalDateTime datetime;

    public Comment(){

    }

    public Comment(int commentId, int postId, int userId, String content, LocalDateTime datetime){
        this.commentId = commentId;
        this.postId = postId;
        this.userId = userId;
        this.content = content;
        this.datetime = datetime;
    }
}
