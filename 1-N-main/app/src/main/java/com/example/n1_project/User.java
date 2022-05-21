package com.example.n1_project;

public class  User {
    private String location;
    private String rn;
    private String time;
    private String uid;


    public User(){}

    public String getRn(){return rn;}

    public void setRn(String rn) {
        this.rn = rn;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getUid(){return uid;}

    public void setUid(String uid){this.uid = uid;}

    //값을 추가할 때 쓰는 함수, MainActivity에서 addanimal함수에서 사용할 것임.
    public User(String location, String rn, String time, String uid){
        this.time = time;
        this.location = location;
        this.rn = rn;
        this.uid = uid;
    }


}
