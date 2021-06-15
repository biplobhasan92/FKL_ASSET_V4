/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fk.bean;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

/**
 *
 * @author Hasan
 */


public class Demand implements Serializable{
    
    private int dmndID;
    private int ddn_no;
    private String demandDate;
    private String nameOfApplicant;
    private String department;
    private String desigWithId;
    private String submitedTo;
    private String message;
    private int sl;
    private String description;
    private String brand;
    private String model;
    private int weight;
    private int pcs;
    private int partsNo;
    private String location;
    private String status;
    private String remarks;
    private List<Demand> dBeans;
    
    public int getDmndID(){
        return dmndID;
    }

    public void setDmndID(int dmndID){
        this.dmndID = dmndID;
    }

    public int getDdn_no(){
        return ddn_no;
    }

    public void setDdn_no(int ddn_no){
        this.ddn_no = ddn_no;
    }

    public String getDemandDate(){
        return demandDate;
    }

    public void setDemandDate(String demandDate){
        this.demandDate = demandDate;
    }

    public String getNameOfApplicant(){
        return nameOfApplicant;
    }

    public void setNameOfApplicant(String nameOfApplicant){
        this.nameOfApplicant = nameOfApplicant;
    }

    public String getDepartment(){
        return department;
    }

    public void setDepartment(String department){
        this.department = department;
    }

    public String getDesigWithId() {
        return desigWithId;
    }

    public void setDesigWithId(String desigWithId){
        this.desigWithId = desigWithId;
    }

    public String getSubmitedTo(){
        return submitedTo;
    }

    public void setSubmitedTo(String submitedTo){
        this.submitedTo = submitedTo;
    }

    public String getMessage(){
        return message;
    }

    public void setMessage(String message){
        this.message = message;
    }

    public int getSl(){
        return sl;
    }

    public void setSl(int sl){
        this.sl = sl;
    }

    public String getDescription(){
        return description;
    }

    public void setDescription(String description){
        this.description = description;
    }

    public String getBrand(){
        return brand;
    }

    public void setBrand(String brand){
        this.brand = brand;
    }

    public String getModel(){
        return model;
    }

    public void setModel(String model){
        this.model = model;
    }

    public int getWeight(){
        return weight;
    }

    public void setWeight(int weight){
        this.weight = weight;
    }

    public int getPcs(){
        return pcs;
    }

    public void setPcs(int pcs){
        this.pcs = pcs;
    }

    public int getPartsNo(){
        return partsNo;
    }

    public void setPartsNo(int partsNo){
        this.partsNo = partsNo;
    }

    public String getLocation(){
        return location;
    }

    public void setLocation(String location){
        this.location = location;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    
    
    
    
    public String getRemarks(){
        return remarks;
    }

    public void setRemarks(String remarks){
        this.remarks = remarks;
    }

    public List<Demand> getdBeans(){
        return dBeans;
    }

    public void setdBeans(List<Demand> dBeans){
        this.dBeans = dBeans;
    }

      
}
