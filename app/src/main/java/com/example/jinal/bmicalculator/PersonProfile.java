package com.example.jinal.bmicalculator;

import java.util.Date;

/**
 * Created by Jinal on 2018-07-18.
 */

public class PersonProfile {
    private String name;
    private String password;
    private String healthcard;
    private String bdate;

    public PersonProfile(String name, String password, String healthcard, String bdate) {
        this.name = name;
        this.password = password;
        this.healthcard = healthcard;
        this.bdate = bdate;
    }

    public String getDate() {
        return bdate;
    }

    public void setDate(String date) {
        this.bdate = date;
    }

    public String getName() {
        return name;
    }

    public String getPassword() {
        return password;
    }

    public String getHealthcard() {
        return healthcard;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setHealthcard(String healthcard) {
        this.healthcard = healthcard;
    }
}
