/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fk.action;


import com.fk.bean.ImageDTO;
import com.fk.bean.UploadBean;
import com.fk.database.DBconnection;
import com.fk.manager.UploadManager;
import com.fk.manager.impl.UploadManagerImp;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Blob;
import java.io.InputStream;
import java.io.OutputStream;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.imageio.ImageIO;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.struts2.ServletActionContext;
import org.apache.struts2.ServletActionContext;
import static org.apache.struts2.ServletActionContext.getServletContext;
// import sun.misc.BASE64Encoder;

/**
 *
 * @author Hasan
 */
public class UploadAction extends ActionSupport{

    
    
    
    
    
    
  
    
    
    /*
    public String testUpload() throws IOException
    {
        
        if(upload.getFkl_tag().trim().isEmpty()
                || upload.getFile_name().trim().isEmpty()){
            upload.setMsg("Input Filed Should not be empty");
            return  "fail";
        }
        
        
        int i = UploadDao.uploadFile(upload);
        if (i > 0){
            upload.setMsg("File successfully inserted.");
        }else{
            upload.setMsg("Something gone wrong.");
        }
        return "success";
    }
  */
    
    // RetrieveIamgesAction action = new RetrieveIamgesAction();
    
    private int id;
    private String fkl_tag;
    private String name;
    private File image;
    private String msg;

    
    
    
    
    public String getFkl_tag() {
        return fkl_tag;
    }

    public void setFkl_tag(String fkl_tag) {
        this.fkl_tag = fkl_tag;
    }
    
    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
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

    public void setName(String name) {
        this.name = name;
    }

    public File getImage() {
        return image;
    }

    public void setImage(File image) {
        this.image = image;
    }
    
    
  

    public String testUpload() throws IOException {
       
        String imageString = null;
        ByteArrayOutputStream bos = new ByteArrayOutputStream();
        if (name == null || name.trim().isEmpty()) {
            setMsg("please type name");
            return "fail";
        }
        
        if (fkl_tag == null || fkl_tag.trim().isEmpty()) {
            setMsg("please type fkl_tag");
            return "fail";
        }
        
        
        if (new UploadManagerImp().isExistFklTag(fkl_tag)){
            setMsg("This FKL Tag is already exist !");
            return "fail";
        }
        
        
        try {
            PreparedStatement ps 
                    = new DBconnection().getConnection().prepareStatement("INSERT INTO image_upload(fkl_tag, name, image) VALUES(?,?,?)");
            ps.setString(1, fkl_tag);
            ps.setString(2, name);
            FileInputStream inputStream = new FileInputStream(image);
            ps.setBinaryStream(3, inputStream);
            // preparedStatement.setString(2, encodeToString(image, "image"));
            int i = ps.executeUpdate();
            setName("");
            if (i > 0){
                setMsg("File successfully inserted.");
                setFkl_tag("");
                setName("");
            }else{
                setMsg("Something gone wrong.");
                setFkl_tag("");
                setName("");
            }
        } catch (Exception e){
            e.printStackTrace();
        }
        return "success";     
    }
    
    
    
    
    public String deletingAttachment(){
        if(new UploadManagerImp().deleteFile(getId())){
            return "success";
        }else {
            return "fail";
        }
    }
    
    
    public String loadAttach(){
        return "success";
    }
    
}
