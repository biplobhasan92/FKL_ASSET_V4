/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fk.manager.impl;

import com.fk.bean.UploadBean;
import com.fk.database.DBconnection;
import com.fk.manager.UploadManager;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.OutputStream;
import java.sql.Blob;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.jsp.PageContext;
import org.apache.struts2.ServletActionContext;



/**
 * 
 *@since   : version 1.0, 05-Dec-2020, 18:13:07
 *@version : 4.0
 *About    : to upload file related machine in database
 *@author  : Hasan Mobarak<biplobjugp40@gmail.com>
 * 
 */


public class UploadManagerImp implements UploadManager{
    
    
    Connection c = null;
    Statement st = null;
    PreparedStatement ps = null;
    ResultSet rs = null;

    
    @Override
    public int uploadFile(UploadBean bean) {
        
        System.out.println("File_name : "+bean.getFkl_tag());
        System.out.println("File_name : "+bean.getFile_name());
        int i=0;
        try {
            String sql = "insert into file_upload(fkl_tag, file_name, anyFile) values(?,?,?)";
            ps = new DBconnection().getConnection().prepareStatement(sql);
             FileInputStream inputStream = new FileInputStream(bean.getAnyFile());
            ps.setString(1, bean.getFkl_tag());
            ps.setString(2, bean.getFile_name());
            ps.setBinaryStream(3, inputStream);
            i = ps.executeUpdate();
        } catch (Exception e){
            e.printStackTrace();
        }
        return i;
    }
    

    
    
    @Override
    public List<UploadBean> getListOfUploadedData(){
        
        HttpServletResponse response = ServletActionContext.getResponse();
        HttpServletRequest request = ServletActionContext.getRequest();
        String id = request.getParameter("id");
        
        List<UploadBean> uBean = null;
        c = DBconnection.getConnection();
        try {
            uBean = new ArrayList<UploadBean>();
            String query = "SELECT id, fkl_tag, file_name, anyFile FROM file_upload ORDER BY id DESC ";
            ps = c.prepareStatement(query);
            rs = ps.executeQuery();
            UploadBean bean;
            while (rs.next()){
                bean = new UploadBean();
                bean.setId(rs.getInt("id"));
                bean.setFkl_tag(rs.getString("fkl_tag"));
                bean.setFile_name(rs.getString("file_name"));
                uBean.add(bean);
            }
            rs.close();
            c.close();
        }catch(Exception e) {
            System.out.println(e);
        }
        return uBean;
    }
    
    
    
    public ResultSet getData() {
        try {
            return DBconnection.getConnection().prepareStatement("SELECT ID, fkl_tag, NAME, image FROM image_upload ORDER BY ID DESC").executeQuery();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }




    public ResultSet getPhoto(String id) {
        try {
            PreparedStatement ps = DBconnection.getConnection().prepareStatement("SELECT fkl_tag, NAME, image FROM image_upload WHERE id=?");
            ps.setString(1, id);
            return ps.executeQuery();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
    
        
        
    

        

    public static void main(String[] args){
        // System.out.println(new UploadManagerImp().isExistFklTag("FKL.17.00006"));
    }

    
    
    
    
    @Override
    public boolean deleteFile(int imgId) {
        boolean b = false;
        PreparedStatement ps;
        try {
            ps = DBconnection.getConnection().prepareStatement("delete FROM image_upload WHERE id=?");
            ps.setInt(1, imgId);
            if(ps.executeUpdate()>0){
                b = true;
            }else {
                b = false;
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
            ex.printStackTrace();
        }
       return b;
    }
    
    
    

    @Override
    public boolean isExistFklTag(String fkl_tag) {
        c = DBconnection.getConnection();
        int count = 0;
        boolean b = false;
        try{
            String query = "SELECT fkl_tag FROM image_upload where fkl_tag = ?";
            ps = c.prepareStatement(query);
            ps.setString(1, fkl_tag);
            rs = ps.executeQuery();
            while (rs.next()){
                count++;
            }
            if(count>0){
                b = true;
            }
            System.out.println("count:"+count);
            rs.close();
            c.close();
        }catch(Exception e) {
            System.out.println(e);
        }
        return b;
    }
}
