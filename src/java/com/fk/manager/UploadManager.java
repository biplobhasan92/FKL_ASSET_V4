/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fk.manager;

import com.fk.bean.UploadBean;
import java.util.List;

/**
 * 
 *@since   : version 1.0, 05-Dec-2020, 18:13:07
 *@version : 4.0
 *About    : to upload file related machine in database
 *@author  : Hasan Mobarak<biplobjugp40@gmail.com>
 * 
 */


public interface UploadManager {
    public int uploadFile(UploadBean bean);
    public List<UploadBean> getListOfUploadedData();    
    public boolean deleteFile(int imgId);
    public boolean isExistFklTag(String fkl_tag);
}
