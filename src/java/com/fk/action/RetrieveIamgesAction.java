/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fk.action;

import com.fk.bean.ImageDTO;
//import com.fk.manager.UploadManager;
import com.fk.manager.impl.UploadManagerImp;
import com.opensymphony.xwork2.ActionSupport;
//import java.io.OutputStream;
import java.sql.Blob;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.struts2.ServletActionContext;
// import sun.misc.BASE64Encoder;
import org.apache.commons.codec.binary.Base64;

/**
 *
 * @author Hasan
 */
public class RetrieveIamgesAction extends ActionSupport{
    
    
    List<ImageDTO> dataList = null;
    private int imgId;
    private String fkl_tag, name, image;   

    public String getFkl_tag() {
        return fkl_tag;
    }

    public void setFkl_tag(String fkl_tag) {
        this.fkl_tag = fkl_tag;
    }
    ResultSet rs = null;
    
    // UploadManagerImp daoObj = null;
    ImageDTO dataBean = null;

    public int getImgId() {
        return imgId;
    }

    public void setImgId(int imgId) {
        this.imgId = imgId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }
    
    
    
    @Override
    public String execute() throws Exception {
        HttpServletResponse response = ServletActionContext.getResponse();
        HttpServletRequest request = ServletActionContext.getRequest();
        String id = request.getParameter("id");
        try {
            dataList = new ArrayList<>();
            rs = new UploadManagerImp().getData();
            if (rs != null){
                while (rs.next()) {
                    dataBean = new ImageDTO();
                    dataBean.setId(rs.getInt("id"));
                    dataBean.setFkl_tag(rs.getString("fkl_tag"));
                    dataBean.setName(rs.getString("name"));
                    Blob ph = rs.getBlob("image");
                    // byte data[] = ph.getBytes(1, (int) ph.length());
                    // encoding the byte image string
                    byte[] encodedBytes = Base64.encodeBase64(ph.getBytes(1, (int) ph.length()));
                    // BASE64Encoder base64Encoder = new BASE64Encoder();
                    StringBuilder imageString = new StringBuilder();
                    imageString.append("data:image/png;base64,");
                    //imageString.append(base64Encoder.encode(data));
                    imageString.append(new String(encodedBytes));
                    dataBean.setImage(imageString.toString());
                    dataList.add(dataBean);
                }
            }

            /*
            
            byte[] encodedBytes = Base64.encodeBase64("Test".getBytes());
            System.out.println("encodedBytes " + new String(encodedBytes));
            byte[] decodedBytes = Base64.decodeBase64(encodedBytes);
            System.out.println("decodedBytes " + new String(decodedBytes));
            
            
                try {
                    rs = new UploadManagerImp().getPhoto(id);
                    if (rs.next()){
                        Blob ph = rs.getBlob("image");
                        byte data[] = ph.getBytes(1, (int) ph.length());
                        OutputStream out = response.getOutputStream();
                        out.write(data);
                        out.flush();
                        out.close();                    
                    }
                } catch (Exception e){
                    e.printStackTrace();
                    e.getMessage();
                }
            */
            
            
        } catch (Exception e) {
                e.printStackTrace();
        }
        return "success";
    }
        
        
        

    public List<ImageDTO> getDataList() {
        return dataList;
    }

    
    
    public void setDataList(List<ImageDTO> dataList) {
        this.dataList = dataList;
    }
    
    
    
}
