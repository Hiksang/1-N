package com.example.n1_project;

public class User {
    private String user_key;//키
    private String user_location;//위치
    private String user_time;//시간

    User(){

    }

    public User(String user_key,String user_time, String user_location){
        this.user_key = user_key;
        this.user_location = user_location;
        this.user_time = user_time;
    }

    public String getUser_key() {
        return user_key;
    }

    public void setUser_key(String user_key) {
        this.user_key = user_key;
    }

    public String getUser_location() {
        return user_location;
    }

    public void setUser_location(String user_location) {
        this.user_location = user_location;
    }

    public String getUser_time() {
        return user_time;
    }

    public void setUser_time(String user_time) {
        this.user_time = user_time;
    }




}
