/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fk.bean;

import java.io.File;
import java.sql.Blob;
import java.util.List;

/**
 *
 * @author Hasan
 */
public class ImageDTO {
    
    /*
    private int id;
    private String fkl_tag;
    private String file_name;
    private Blob anyFile;
    */
    
    
    
    
    
    private int id;
    private String name;
    private String fkl_tag;
    // private Blob image;
    private String image;
    
    
    public String getFkl_tag() {
        return fkl_tag;
    }

    public void setFkl_tag(String fkl_tag) {
        this.fkl_tag = fkl_tag;
    }
    
    
    
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name){
        this.name = name;
    }

    public String getImage(){
        return image;
    }

    public void setImage(String image){
        this.image = image;
    }
    
}
