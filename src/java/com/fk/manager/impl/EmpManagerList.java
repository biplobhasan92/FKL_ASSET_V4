/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 * author : Ahsan, Hasan Mobarak
 */

package com.fk.manager.impl;

import com.fk.bean.EmpBean;
import com.fk.database.DBconnection;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;


public class EmpManagerList {
    
    public List<EmpBean> getDeptList(){ 
                
                 
                ArrayList<EmpBean> eDeptList = new ArrayList<EmpBean>(); 
                
                
                        try {
                        Connection con = DBconnection.getConnection();
                        if(con == null)
                        {
                            return eDeptList;
                        }
                        String sql = "select distinct dept from empdata";
                        Statement st = con.createStatement();
                        ResultSet rs = st.executeQuery(sql);
                        EmpBean eBean;
                        while(rs.next())
                        {
                          eBean = new EmpBean();
                          eBean.setDept(rs.getString("dept"));

                          eDeptList.add(eBean);
                        }
                        st.close();
                        con.close();
                    } catch (SQLException ex) {
                        ex.printStackTrace();
                    }
                  return eDeptList;
                }	

   
    
    
    
}
