package com.example.q35;
//Student class
public class Password
{
    private String place;   //name of student
    private String pwd;

    public Password(String name, String pwd) {
        this.place = name;
        this.pwd = pwd;
    }

    public String getPlace() {
        return place;
    }

    public String getPwd() {
        return pwd;
    }
}
