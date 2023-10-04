package com.example.app.models;

import org.springframework.data.annotation.Id;

public class Account {
    @Id
    public int userid;

    private String mailaddress;

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
