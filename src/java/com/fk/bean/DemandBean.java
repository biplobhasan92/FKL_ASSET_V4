/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fk.bean;

import java.io.Serializable;
import java.util.List;

/**
 *
 * @author Hasan
 */


public class DemandBean implements Serializable {
    
    private static final long serialVersionUID = 1L;
    
    private int dmndID;
    private int ddn_no;
    private String demandDate;
    private String nameOfApplicant;
    private String department;
    private String desigWithId;
    private String submitedTo;
    private String message;
    private List<DemandDetails> demandDetail;


    
    
    public int getDmndID() {
        return dmndID;
    }

    public void setDmndID(int dmndID) {
        this.dmndID = dmndID;
    }

    public int getDdn_no() {
        return ddn_no;
    }

    public void setDdn_no(int ddn_no) {
        this.ddn_no = ddn_no;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
    
    public String getDemandDate() {
        return demandDate;
    }

    public void setDemandDate(String demandDate) {
        this.demandDate = demandDate;
    }

    public String getNameOfApplicant() {
        return nameOfApplicant;
    }

    public void setNameOfApplicant(String nameOfApplicant) {
        this.nameOfApplicant = nameOfApplicant;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public String getDesigWithId() {
        return desigWithId;
    }

    public void setDesigWithId(String desigWithId) {
        this.desigWithId = desigWithId;
    }

    public String getSubmitedTo() {
        return submitedTo;
    }

    public void setSubmitedTo(String submitedTo) {
        this.submitedTo = submitedTo;
    }

    public List<DemandDetails> getDemandDetail() {
        return demandDetail;
    }

    public void setDemandDetail(List<DemandDetails> demandDetail) {
        this.demandDetail = demandDetail;
    }



    
    
    
}
