/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 * author : Ahsan, Hasan Mobarak
 */
package com.fk.bean;

/**
 *
 * @author Ahsan-IT
 */
public class adminBean {
    
    private String aname;
    private String emp_id;
    private String password;
    private String right;
    private String message;
    private String confrmPass;   

    public String getEmp_id() {
        return emp_id;
    }

    public void setEmp_id(String emp_id) {
        this.emp_id = emp_id;
    }

    
    public String getRight() {
        return right;
    }

    public void setRight(String right) {
        this.right = right;
    }
    
    

    public String getAname() {
        return aname;
    }

    public void setAname(String aname) {
        this.aname = aname;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
    
    
    public String getConfrmPass() {
        return confrmPass;
    }

    public void setConfrmPass(String confrmPass) {
        this.confrmPass = confrmPass;
    }
    
}
