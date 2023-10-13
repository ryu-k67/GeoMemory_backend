package com.example.app.models;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import org.springframework.data.annotation.Id;

// import jakarta.persistence.Column;
// import jakarta.persistence.Entity;
// import jakarta.persistence.GeneratedValue;
// import jakarta.persistence.GenerationType;
// import jakarta.persistence.Table;
import lombok.Data;

@Data
// @Entity
// @Table(name = "post")
public class Post {
    @Id
    // @GeneratedValue(strategy = GenerationType.IDENTITY)
    // @Column(name = "postid")
    public int postid;

    // @Column(name = "content")
    private String content;

    // @Column(name = "post_img")
    private byte[] postimg;

    // @Column(name = "datetime")
    private LocalDateTime datetime;

    // @Column(name = "latitude")
    private BigDecimal latitude;

    // @Column(name = "longtitude")
    private BigDecimal longtitude;

    // @Column(name = "userid")
    private int userid;

    public Post() {

    }

    public Post(int postid, String content, byte[] postimg, LocalDateTime datetime, BigDecimal latitude, BigDecimal longtitude, int userid) {
        this.postid = postid;
        this.content = content;
        this.postimg = postimg;
        this.datetime = datetime;
        this.latitude = latitude;
        this.longtitude = longtitude;
        this.userid = userid;
    }
    
    //@Override
    //public String toString() {
    //return "Account [userid=" + userid + ", mailaddress=" + mailaddress + ", password=" + password + "]";
    //}

}