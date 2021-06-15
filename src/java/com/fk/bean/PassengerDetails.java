/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fk.bean;

import java.io.Serializable;

/**
 *
 * @author Hasan
 */

public class PassengerDetails implements Serializable{
 
    private short sno;
    private String name;
    private String age;
    private String gender;
 
    public short getSno() {
        return sno;
    }
    public void setSno(short sno) {
        this.sno = sno;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getAge() {
        return age;
    }
    public void setAge(String age) {
        this.age = age;
    }
    public String getGender() {
        return gender;
    }
    public void setGender(String gender) {
        this.gender = gender;
    }
 
}
