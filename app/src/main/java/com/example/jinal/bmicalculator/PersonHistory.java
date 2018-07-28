package com.example.jinal.bmicalculator;

/**
 * Created by Jinal on 2018-07-28.
 */

public class PersonHistory {
    private String userid ;
    private String height;
    private String weight;
    private String bmi;
    private String date;

    public PersonHistory(){}

    public PersonHistory(String userid, String height, String weight, String bmi, String date) {
        this.userid = userid;
        this.height = height;
        this.weight = weight;
        this.bmi = bmi;
        this.date = date;
    }

    public String getUserid() {
        return userid;
    }

    public void setUserid(String userid) {
        this.userid = userid;
    }

    public String getHeight() {
        return height;
    }

    public void setHeight(String height) {
        this.height = height;
    }

    public String getWeight() {
        return weight;
    }

    public void setWeight(String weight) {
        this.weight = weight;
    }

    public String getBmi() {
        return bmi;
    }

    public void setBmi(String bmi) {
        this.bmi = bmi;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    @Override
    public String toString() {
        return String.valueOf(getBmi())+"           "+getDate();
    }
}
