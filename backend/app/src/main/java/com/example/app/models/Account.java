package com.example.app.models;

import org.springframework.data.annotation.Id;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Table;

@Entity
@Table(name="account")
public class Account {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="userid")
    public int userid;

    @Column(name="mailaddress")
    private String mailaddress;

    @Column(name="password")
    private String password;

    public Account() {

    }

    public Account(int userid, String mailaddress, String password) {
        this.userid = userid;
        this.mailaddress = mailaddress;
        this.password = password;
    }

    // getters and setters
    public int getUserid(){
        return userid;
    }
    
    public void setUserid(int userid){
        this.userid = userid;
    }

    public String getMailaddress(){
        return mailaddress;
    }

    public void setMailaddress(String mailaddress){
        this.mailaddress = mailaddress;
    }

    public String getPassword(){
        return password;
    }

    public void setPassword(String password){
        this.password = password;
    }

    @Override
    public String toString() {
    return "Account [userid=" + userid + ", mailaddress=" + mailaddress + ", password=" + password + "]";
    }

}
