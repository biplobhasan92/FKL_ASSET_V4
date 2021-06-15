/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 * author : Ahsan, Hasan Mobarak
 */
package com.fk.action;

import com.fk.bean.userBean;
import com.fk.database.DBconnection;
import com.fk.login.LoginDao;
import com.opensymphony.xwork2.ActionSupport;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import org.apache.struts2.dispatcher.SessionMap;
import org.apache.struts2.interceptor.SessionAware;

public class AdminAction extends ActionSupport implements SessionAware {

    private String aname;
    private String password;
    private String emp_id;
    private String right;
    private String message;
    public Map m;
    private HashMap hm;
    HttpSession session;
    private List deptList = new ArrayList();
    private List availableTagList = new ArrayList();
    private List state = new ArrayList();
    private List status = new ArrayList();
    HttpServletRequest request;
    private List productList = new ArrayList();
    MenuAction eAction = new MenuAction();
    userBean userBn = new userBean();
    
    
    public String login() {                                                     // This is LogIn Method Accroding to Struts.xml action name login method name login
        if (LoginDao.validate(aname, password)) {                               //  LogIn Dao Validate Method Check User in Database
            right  = LoginDao.getRight(aname, password);                         //  LogIn Dao getRight Method provide privilege level of Admin Accroding to user Input
            // emp_id = LoginDao.getEmpId(aname, password);            
            hm = LoginDao.getSessionValue(aname, password);
            if (right.equals("Super Admin")){
                m.put("master", right);
            }else if (right.equals("Admin")){
                m.put("admin", right);
            }else if (right.equals("Entry User")){
                m.put("entry", right);
            }else{
                m.put("out", "out");
            }
            m.put("aname", aname);
            m.put("emp_id", hm.get("emp_id"));
            m.put("emp_full_name", hm.get("emp_full_name"));
            m.put("designation", hm.get("designation"));
            m.put("dept",hm.get("dept"));
            setDeptList(this.deptList);                                         // if logIn is success, the combo of Depertment is fill by this method
            setAvailableTagList(this.availableTagList);                         //  ??
            setProductList(this.productList);                                   // after LogIn it fill the combo of product type in addM Form
            return "success";
        }else{
            setMessage("Incorrect Login ID or Password");
            clear();
            return "fail";
        }
    }

    public String logout(){
        System.out.println("I am called for logout...");
        m.remove("aname");
        m.remove("emp_id");
        m.remove("master");
        m.remove("admin");
        m.remove("emp_full_name");
        m.remove("designation");
        m.remove("dept");
        m.remove("entry");
        m.remove("out");
        m.put("out", "out");
        addActionMessage("You Have Been Successfully Logged Out");
        return "success";
    }

    public String getAname(){
        return aname;
    }
    
    public void setAname(String aname){
        this.aname = aname;
    }

    public String getPassword(){
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmp_id(){
        return emp_id;
    }
    
    
    public void setEmp_id(String emp_id){
        this.emp_id = emp_id;
    }
    
    public String getMessage(){
        return message;
    }

    public void setMessage(String message){
        this.message = message;
    }

    public List getStatus(){
        return status;
    }

    public void setStatus(List status){
        this.status = status;
    }

    public List getDeptList(){
        return deptList;
    }

    public void setDeptList(List deptList) { // setDeptList() method is Used in Login Method
        try {
            Connection con = DBconnection.getConnection();
            String sql = "select distinct dept from deptlist";
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(sql);
            while (rs.next()) {
                deptList.add(rs.getString("dept"));
            }
            st.close();
            con.close();
        } catch (SQLException ex){
            ex.printStackTrace();
        }
    }

    public List getProductList() {
        return productList;
    }

    public void setProductList(List productList) {
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

    public List getAvailableTagList() {
        return availableTagList;
    }

    public void setAvailableTagList(List availableTagList) {
        try {
            Connection con = DBconnection.getConnection();
            String sql = "select fklid from mdata where mdata.fklid not in( select fklid from masgndata )";
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(sql);
            while (rs.next()){
                availableTagList.add(rs.getString("fklid"));
            }
            st.close();
            con.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    private void clear() {
        setAname("");
        setPassword("");
    }

    @Override
    public void setSession(Map m) {
        this.m = m;                                                             //To change body of generated methods, choose Tools | Templates.
    }
}
