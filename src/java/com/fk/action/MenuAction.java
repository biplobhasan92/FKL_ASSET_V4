/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 * author : Ahsan, Hasan Mobarak
 */

package com.fk.action;

import com.fk.bean.EmpBean;
import com.fk.database.DBconnection;
import com.fk.manager.EmpManager;
import com.fk.manager.impl.EmpManagerCheck;
import com.fk.manager.impl.EmpManagerImpl;
import com.fk.manager.impl.EmpManagerList;
import com.opensymphony.xwork2.ModelDriven;
import com.opensymphony.xwork2.ActionSupport;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;



public class MenuAction extends ActionSupport implements ModelDriven<EmpBean>{
        
    private EmpBean eBean = new EmpBean();
    private EmpManager eManager= new EmpManagerImpl();
    public  List deptList = new ArrayList();
    private List availableTagList = new ArrayList();
    private List mdeptList = new ArrayList();
    private List subDeptList = new ArrayList();
    private List productList = new ArrayList();
    
    
    public List getProductList() {
        return productList;
    }
    
    
    

    public void setProductList(List productList){

        try {
            
            Connection con = DBconnection.getConnection();
            String sql = "select distinct mtype from item_type";
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(sql);
            while (rs.next()) {
                productList.add(rs.getString("mtype"));
            }
            st.close();
            con.close();

        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }
    
    
    
    public List getSubDeptList(){
        return subDeptList;
    }

    
    
    public void setSubDeptList(List subDeptList) {
        //this.subDeptList = subDeptList;

        System.out.println("deptEntry");
        try {
            Connection con = DBconnection.getConnection();

            String sql = "select dept from main_deptlist, deptlist where deptlist.dept_id = main_deptlist.dept_id and main_deptlist.dept_name='" + eBean.getMdept() + "'";
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(sql);
            //EmpBean eBean;
            System.out.println("deptInside1 " + eBean.getMdept() + " the value");
            while (rs.next()) {

                subDeptList.add(rs.getString("dept"));
                System.out.println(rs.getString("dept"));
                System.out.println("deptInside");
            }

            st.close();
            con.close();

        } catch (SQLException ex) {
            ex.printStackTrace();
            System.out.println("deptOut");
        }

    }

    public List getMdeptList() {
        return mdeptList;
    }

    public void setMdeptList(List mdeptList) {
        //this.mdeptList = mdeptList;
        try {
            Connection con = DBconnection.getConnection();

            String sql = "select distinct dept_name from main_deptlist";
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(sql);
            //EmpBean eBean;
            while (rs.next()) {

                mdeptList.add(rs.getString("dept_name"));
                System.out.println(rs.getString("dept_name"));
            }

            st.close();
            con.close();

        } catch (SQLException ex) {
            ex.printStackTrace();
        }

    }


    

    public List getAvailableTagList() {
        return availableTagList;
    }

    public void setAvailableTagList(List availableTagList) {
        //this.availableTagList = availableTagList;
        try {
            Connection con = DBconnection.getConnection();

            String sql = "select fklid from mdata where mdata.fklid not in( select fklid from masgndata )";
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(sql);
            //EmpBean eBean;
            while (rs.next()) {
                availableTagList.add(rs.getString("fklid"));
            }

            st.close();
            con.close();

        } catch (SQLException ex) {
            ex.printStackTrace();
        }

    }


    public String addM()
    {
        setAvailableTagList(this.availableTagList);
        setDeptList(this.deptList);
        setProductList(this.productList);
        return "success";
    
    
    }
    
    
    public String addM2()
    {
        //setAvailableTagList(this.availableTagList);
        setDeptList(this.deptList);
        setProductList(this.productList);
        return "success";
    
    
    }
    
    public String upM()
    {
        //setAvailableTagList(this.availableTagList);
        return "success";
    
    
    }
    
    
    public String addAttach(){
        return "success";
    }
    
    public String newEmp()
    {
        setDeptList(this.deptList);
        return "success";    
    } 
    
    public String createUser()
    {        
        return "success";        
    }
    

    public List getDeptList() {
        return deptList;
    }

    public void setDeptList(List deptList) {
        //this.deptList = deptList;
        try {
            Connection con = DBconnection.getConnection();

            String sql = "select distinct dept from deptlist";
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(sql);
            //EmpBean eBean;
            while (rs.next()) {

                deptList.add(rs.getString("dept"));
                System.out.println(rs.getString("dept"));
            }

            st.close();
            con.close();

        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    
    public List<String> setDeptList() {
        
        List<String> deptList = new ArrayList<>();
        
        try {
            
            Connection con = DBconnection.getConnection();
            String sql = "select distinct dept from deptlist";
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(sql);
            //EmpBean eBean;
            while (rs.next()) {

                deptList.add(rs.getString("dept"));
                System.out.println(rs.getString("dept"));
            }

            st.close();
            con.close();

        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        
        return deptList;
    }
    
    
 
    public String settings()
    {
        
        return "success";
    
    
    }
    
    
    public String Mupdate()
    {
      return "success";  

    }
    
    
    public String changePass(){
        return "success";  
    }
    
    
    public String searchEntry()
    {
      
        setDeptList(this.deptList);
        setProductList(this.productList);
        return "success";  

    }
    
    public String openReport()
    {
        setMdeptList(this.mdeptList);
        setDeptList(this.deptList);
        setProductList(this.productList);
        return "success";  

    }
    
    public String openHisReport()
    {
        setMdeptList(this.mdeptList);
        setDeptList(this.deptList);
        setProductList(this.productList);
        return "success";  

    }
    
    
    
    
    
    
    public String machineReport(){
        List<EmpBean> eBeanList = eManager.getAllRecords();
        eBean.seteBeans(eBeanList);
        return "success";
    }
    
    
    

    public String subDeptList() {
        setMdeptList(this.mdeptList);
        setSubDeptList(this.subDeptList);
        return "success";
    }

    //EmpBean emBean= new EmpBean();

    @Override
    public EmpBean getModel()
    {
        return  eBean;

    }
    
    
/*    
    public static void main(String[] args) {
        //IpCheckAction action = new IpCheckAction();
        List deptList = new ArrayList();
        MenuAction action1 = new MenuAction();
        deptList = action1.setDeptList();
        System.out.println(": Test ");
        for (int i = 0; i < deptList.size(); i++) {
            System.out.println(i+": "+deptList.get(i));
        }
    }
*/
}
