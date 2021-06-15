/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fk.bean;

import java.io.File;
import java.util.List;

/**
 * 
 *@since   : version 1.0, 05-Dec-2020, 18:13:07
 *@version : 4.0
 *About    : to upload file related machine in database
 *@author  : Hasan Mobarak<biplobjugp40@gmail.com>
 * 
 */



public class UploadBean {
    
    private int id;
    private String fkl_tag;
    private String file_name;
    private File anyFile;
    private byte [] anyFileByte;
    private String msg;
    private List<UploadBean> uBeans;



    
    public UploadBean(int id, String fkl_tag, String file_name, byte[] anyFileByte, String msg) {
        this.id = id;
        this.fkl_tag = fkl_tag;
        this.file_name = file_name;
        this.anyFileByte = anyFileByte;
        this.msg = msg;
    }


    
    
    public UploadBean(){}       

    
    
    public byte[] getAnyFileByte() {
        return anyFileByte;
    }

    public void setAnyFileByte(byte[] anyFileByte) {
        this.anyFileByte = anyFileByte;
    }
    
    

    public UploadBean(String fkl_tag, String file_name, File anyFile, String msg) {
        this.fkl_tag = fkl_tag;
        this.file_name = file_name;
        this.anyFile = anyFile;
        this.msg = msg;
    }

    
    
    
    public UploadBean(int id, String fkl_tag, String file_name, File anyFile, String msg) {
        this.id = id;
        this.fkl_tag = fkl_tag;
        this.file_name = file_name;
        this.anyFile = anyFile;
        this.msg = msg;
    }
    
    
    
    
    public File getAnyFile() {
        return anyFile;
    }

    public void setAnyFile(File anyFile) {
        this.anyFile = anyFile;
    }

   

   

    
    
    
    
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFkl_tag() {
        return fkl_tag;
    }

    public void setFkl_tag(String fkl_tag) {
        this.fkl_tag = fkl_tag;
    }

    public String getFile_name() {
        return file_name;
    }

    public void setFile_name(String file_name) {
        this.file_name = file_name;
    }



    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public List<UploadBean> getuBeans() {
        return uBeans;
    }

    public void setuBeans(List<UploadBean> uBeans) {
        this.uBeans = uBeans;
    }
    
    
    
        
    
}
