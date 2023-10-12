package com.example.app.models;

import org.springframework.data.annotation.Id;

// import jakarta.persistence.Entity;
// import jakarta.persistence.GeneratedValue;
// import jakarta.persistence.GenerationType;
// import jakarta.persistence.Table;
import lombok.Data;
//import reactor.core.publisher.Mono;

@Data
// @Entity
// @Table(name = "account")
public class Account {
    @Id
    // @GeneratedValue(strategy = GenerationType.IDENTITY)
    public int userid;

    private String mailaddress;

    private String password;

    public Account() {

    }

    public Account(int userId, String mailaddress, String password) {
        this.userid = userId;
        this.mailaddress = mailaddress;
        this.password = password;
    }

    //public int getUserid(){
    //    return userId;
    //}

    @Override
    public String toString() {
    return "Account [userid=" + userid + ", mailaddress=" + mailaddress + ", password=" + password + "]";
    }

}
