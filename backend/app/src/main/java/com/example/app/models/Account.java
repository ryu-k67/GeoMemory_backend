package com.example.app.models;

import org.springframework.data.annotation.Id;

// import jakarta.persistence.Column;
// import jakarta.persistence.Entity;
// import jakarta.persistence.GeneratedValue;
// import jakarta.persistence.GenerationType;
// import jakarta.persistence.Table;
import lombok.Data;

@Data
// @Entity
// @Table(name="account")
public class Account {
    @Id
    // @GeneratedValue(strategy = GenerationType.IDENTITY)
    // @Column(name="userid")
    public int userid;

    // @Column(name="mailaddress")
    private String mailaddress;

    // @Column(name="password")
    private String password;

    public Account() {

    }

    public Account(int userId, String mailaddress, String password) {
        this.userId = userId;
        this.mailaddress = mailaddress;
        this.password = password;
    }

    //@Override
    //public int getUserid(){
    //    return userid;
    //}

    @Override
    public String toString() {
    return "Account [userid=" + userId + ", mailaddress=" + mailaddress + ", password=" + password + "]";
    }

}
