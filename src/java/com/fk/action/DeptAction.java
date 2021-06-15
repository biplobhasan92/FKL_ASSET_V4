/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 * author : Ahsan, Hasan Mobarak
 */
package com.fk.action;

import com.fk.bean.EmpBean;
import com.fk.database.DBconnection;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Hasan-IT
 */
public class DeptAction extends ActionSupport implements ModelDriven<EmpBean> {
    
    
    private EmpBean eBean=new EmpBean();
    
    private List ipList = new ArrayList();

    public List getIpList() {
        return ipList;
    }

    public void setIpList(List ipList) {
        
         
        String dept= eBean.getDept();
        try {
                        Connection con = DBconnection.getConnection();
                        
                        String sql = "select ip dept from ipStock where dept='"+dept+"'";
                        Statement st = con.createStatement();
                        ResultSet rs = st.executeQuery(sql);
                        //EmpBean eBean;
                        while(rs.next())
                        {
                          
                          ipList.add(rs.getString("ip"));
                        }
                        
                        
                        
                        st.close();
                        con.close();
                        
                    } catch (SQLException ex) {
                        ex.printStackTrace();
                    }
        
        
        
        //this.ipList = ipList;
    }
    
    
    
    
    

    public String getDept()
    {
        
      //setState(this.state);
        //setStatus(this.status);
        setIpList(this.ipList);
        return "success";  
      /*List<EmpBean> eDeptList = eList.getDeptList();
            eBean.seteDeptList(eDeptList);
      return "success";  */

    }

    @Override
    public EmpBean getModel() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    
}
