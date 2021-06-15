/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fk.action;

import java.util.logging.Logger;
import com.fk.bean.IpBean;
import com.fk.database.DBconnection;
import com.fk.manager.IpCheckManager;
import com.fk.manager.impl.IpCheckImpl;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import java.util.List;
import java.util.Date;
import java.io.*;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.*;
import java.util.ArrayList;
import javax.servlet.http.HttpServletRequest;
import javax.sound.sampled.Line;
import org.apache.commons.logging.impl.SimpleLog;
import org.apache.struts2.ServletActionContext;
// import sun.java2d.pipe.SpanShapeRenderer;

/**
 *
 * @author Hasan
 */
public class IpCheckAction extends ActionSupport implements ModelDriven<IpBean>{

    
    
    public IpCheckAction() {
        viewTableIpVlan100();
        viewTableIpVlan101();
        viewTableIpVlan102();
        viewTableIpVlan103();
        viewTableIpVlan104();
        viewTableIpVlan105();
        viewTableIpVlan106();
        viewTableIpVlan107();
        viewTableIpVlan108();
        viewTableIpVlan109();
        viewTableIpVlan110();
    }
    
    
    
    
    
    MenuAction menuAction = new MenuAction();
    private IpBean ipBean = new IpBean();
    IpCheckManager ipManager = new IpCheckImpl();
    private List<IpBean> ipListVlan100;
    private List<IpBean> ipListVlan101;
    private List<IpBean> ipListVlan102;
    private List<IpBean> ipListVlan103;
    private List<IpBean> ipListVlan104;
    private List<IpBean> ipListVlan105;
    private List<IpBean> ipListVlan106;
    private List<IpBean> ipListVlan107;
    private List<IpBean> ipListVlan108;
    private List<IpBean> ipListVlan109;
    private List<IpBean> ipListVlan110;
    private List<IpBean> ipListVlan192;
    private List deptList    = new ArrayList();
    private List productList = new ArrayList();

    private String sucssMesg ="";

    
    private String errMesg ="";

    public IpBean getIpBean() {
        return ipBean;
    }

    public void setIpBean(IpBean ipBean) {
        this.ipBean = ipBean;
    }

    public IpCheckManager getIpManager() {
        return ipManager;
    }

    public void setIpManager(IpCheckManager ipManager) {
        this.ipManager = ipManager;
    }

    public List<IpBean> getIpListVlan100() {
        return ipListVlan100;
    }

    public void setIpListVlan100(List<IpBean> ipListVlan100) {
        this.ipListVlan100 = ipListVlan100;
    }
    
    
    public List<IpBean> getIpListVlan101() {
        return ipListVlan101;
    }

    public void setIpListVlan101(List<IpBean> ipListVlan101) {
        this.ipListVlan101 = ipListVlan101;
    }

    public List<IpBean> getIpListVlan102() {
        return ipListVlan102;
    }

    public void setIpListVlan102(List<IpBean> ipListVlan102) {
        this.ipListVlan102 = ipListVlan102;
    }

    public List<IpBean> getIpListVlan103() {
        return ipListVlan103;
    }

    public void setIpListVlan103(List<IpBean> ipListVlan103) {
        this.ipListVlan103 = ipListVlan103;
    }

    public List<IpBean> getIpListVlan104() {
        return ipListVlan104;
    }

    public void setIpListVlan104(List<IpBean> ipListVlan104) {
        this.ipListVlan104 = ipListVlan104;
    }

    public List<IpBean> getIpListVlan105() {
        return ipListVlan105;
    }

    public void setIpListVlan105(List<IpBean> ipListVlan105) {
        this.ipListVlan105 = ipListVlan105;
    }

    public List<IpBean> getIpListVlan106() {
        return ipListVlan106;
    }

    public void setIpListVlan106(List<IpBean> ipListVlan106) {
        this.ipListVlan106 = ipListVlan106;
    }
    
    public List<IpBean> getIpListVlan107() {
        return ipListVlan107;
    }

    public void setIpListVlan107(List<IpBean> ipListVlan107) {
        this.ipListVlan107 = ipListVlan107;
    }
    

    public List<IpBean> getIpListVlan108() {
        return ipListVlan108;
    }

    public void setIpListVlan108(List<IpBean> ipListVlan108) {
        this.ipListVlan108 = ipListVlan108;
    }

    public List<IpBean> getIpListVlan109() {
        return ipListVlan109;
    }

    public void setIpListVlan109(List<IpBean> ipListVlan109) {
        this.ipListVlan109 = ipListVlan109;
    }

    public List<IpBean> getIpListVlan110() {
        return ipListVlan110;
    }

    public void setIpListVlan110(List<IpBean> ipListVlan110) {
        this.ipListVlan110 = ipListVlan110;
    }

    
    public List<IpBean> getIpListVlan192() {
        return ipListVlan192;
    }

    public void setIpListVlan192(List<IpBean> ipListVlan192) {
        this.ipListVlan192 = ipListVlan192;
    }
    
    

    
    public String getSucssMesg() {
        return sucssMesg;
    }

    public void setSucssMesg(String sucssMesg) {
        this.sucssMesg = sucssMesg;
    }

    public String getErrMesg() {
        return errMesg;
    }

    public void setErrMesg(String errMesg) {
        this.errMesg = errMesg;
    }

    public List getDeptList() {
        return deptList;
    }

    public void setDeptList(List deptList) {
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
        } catch (SQLException ex) {
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
    
    
    
    
    
    
    
    // Reset Form of Edit
    public String resetFormEdit(){
        ipBean.setIp_user_name("");
        ipBean.setIp_user_dept("");
        ipBean.setIp_type("");
        ipBean.setIp_use_status("");
        return SUCCESS;
    }
    
    // Reset Form of IP
    public void resetFormIp(){
        ipBean.setIp_no("");
        ipBean.setIp_user_name("");
        ipBean.setIp_user_dept("");
        ipBean.setIp_type("");
        ipBean.setIp_use_status("");
    }
    
    // Save Single Data INTO ip_vlan_100 TABLE
    
    public String saveIpVan100(){
        ipBean.setIp_no(ipBean.getIp_no());
        ipBean.setIp_user_name(ipBean.getIp_user_name());
        ipBean.setIp_user_dept(ipBean.getIp_user_dept());
        ipBean.setIp_type(ipBean.getIp_type());
        ipBean.setIp_use_status(ipBean.getIp_use_status());
        boolean b = ipManager.saveIpList100(ipBean);
        if(b){
            setSucssMesg("IP Saved Successfully !!");
            resetFormIp();
            return SUCCESS;
        }else{
            setErrMesg("IP Not Saved !");
            return "input";
        }
    }
    
    
    // update Single Data INTO ip_vlan_100 TABLE
    public String editePageIpUpdateCheck(){
        
        ipBean.setIp_no(ipBean.getIp_no());
        ipBean.setIp_user_name(ipBean.getIp_user_name());
        ipBean.setIp_user_dept(ipBean.getIp_user_dept());
        ipBean.setIp_type(ipBean.getIp_type());
        ipBean.setIp_use_status(ipBean.getIp_use_status());
        ipBean.setPbx_extension(ipBean.getPbx_extension());
        boolean b = ipManager.updateIpList100(ipBean);
        if(b){
            setSucssMesg("IP update Successfully !!");
            resetFormIp();
            viewTableIpVlan100();
            viewTableIpVlan101();
            viewTableIpVlan102();
            viewTableIpVlan103();
            viewTableIpVlan104();
            viewTableIpVlan105();
            viewTableIpVlan106();
            viewTableIpVlan107();
            viewTableIpVlan108();
            viewTableIpVlan109();
            viewTableIpVlan110();
            viewTableIpVlan192();
            return SUCCESS;
        }else{
            setErrMesg("IP Not update !");
            return "input";
        }
    }
    
    // Update Single Row of 192 ip serie
    public String updateIp192(){
        ipBean.setIp_no("192.168."+ipBean.getIp_no());
        ipBean.setIp_user_name(ipBean.getIp_user_name());
        ipBean.setIp_user_dept(ipBean.getIp_user_dept());
        ipBean.setIp_type(ipBean.getIp_type());
        ipBean.setIp_use_status(ipBean.getIp_use_status());
        ipBean.setPbx_extension(ipBean.getPbx_extension());
        boolean b = ipManager.updateIpList192(ipBean);
        if(b){
            setSucssMesg("IP 192 update Successfully !!");
            resetFormIp();
            viewTableIpVlan100();
            viewTableIpVlan101();
            viewTableIpVlan102();
            viewTableIpVlan103();
            viewTableIpVlan104();
            viewTableIpVlan105();
            viewTableIpVlan106();
            viewTableIpVlan107();
            viewTableIpVlan108();
            viewTableIpVlan109();
            viewTableIpVlan110();
            viewTableIpVlan192();
            return SUCCESS;
        }else{
            setErrMesg("IP Not update !");
            return "input";
        }
    }
    
    // IP Update
    public String testFunction(){
        HttpServletRequest request = (HttpServletRequest) ActionContext.getContext().get(ServletActionContext.HTTP_REQUEST);
        
        String ip_no = request.getParameter("ip_no");
        String ip_user_name = request.getParameter("ip_user_name");
        String ip_user_dept = request.getParameter("ip_user_dept");
        String ip_type = request.getParameter("ip_type");
        String ip_use_status = request.getParameter("ip_use_status");
        
        System.out.println("ip_no In Ip Check Action : "       +ip_no);
        System.out.println("ip_user_name In Ip Check Action : "+ip_user_name);
        System.out.println("ip_user_dept In Ip Check Action : "+ip_user_dept);
        System.out.println("ip_type In Ip Check Action : "     +ip_type);
        System.out.println("ip_use_status In Ip Check Action : "+ip_use_status);
       // IpBean bean = new IpBean(ip_no, ip_user_name, ip_user_dept, ip_type, ip_use_status);

        return SUCCESS;
    }
    
    
    // Update Ip
    public String updateIpVlanTable(){
        HttpServletRequest request = (HttpServletRequest) ActionContext.getContext().get(ServletActionContext.HTTP_REQUEST);
        
        String ip_no = request.getParameter("ip_no");
        String ip_user_name = request.getParameter("ip_user_name");
        String ip_user_dept = request.getParameter("ip_user_dept");
        String ip_type = request.getParameter("ip_type");
        String ip_use_status = request.getParameter("ip_use_status");
        
        
        ipBean.setIp_no(ip_no);
        ipBean.setIp_user_name(ip_user_name);
        ipBean.setIp_user_dept(ip_user_dept);
        ipBean.setIp_type(ip_type);
        ipBean.setIp_use_status(ip_use_status);
        
        boolean b = ipManager.updateIpList100(ipBean);
        if(b){
            System.out.println(" IP update Successfully !!");
            setSucssMesg("IP update Successfully !!");
            resetFormIp();
            return "success";
        }else{
            setErrMesg("IP Not updated !");
            System.out.println(" IP Not updated !!!");
            return "input";
        }
    }
    
    

    
    
    // Go To Edit Page
    public String updateIpData100(){        
        HttpServletRequest request = (HttpServletRequest) ActionContext.getContext().get(ServletActionContext.HTTP_REQUEST);
        String ip_no = request.getParameter("ip_no");
        System.out.println("ip_no In Ip Check Action : "+ip_no);
        IpBean bean = ipManager.getSingleIp100(ip_no);
        ipBean.setIp_sl_no(bean.getIp_sl_no());
        ipBean.setIp_no(bean.getIp_no());
        ipBean.setIp_user_name(bean.getIp_user_name());
        ipBean.setIp_user_dept(bean.getIp_user_dept());
        ipBean.setIp_type(bean.getIp_type());
        ipBean.setIp_use_status(bean.getIp_use_status());
        ipBean.setPbx_extension(bean.getPbx_extension());
        setDeptList(deptList);
        setProductList(productList);
        return SUCCESS;
    }
    
    
    // Go To Edit Page with data 101
    public String updateIpData101() {
        
        HttpServletRequest request = (HttpServletRequest) ActionContext.getContext().get(ServletActionContext.HTTP_REQUEST);
        String ip_no = request.getParameter("ip_no");
        System.out.println("ip_no In Ip Check Action : "+ip_no);
        IpBean bean = ipManager.getSingleIp101(ip_no);
        ipBean.setIp_sl_no(bean.getIp_sl_no());
        ipBean.setIp_no(bean.getIp_no());
        ipBean.setIp_user_name(bean.getIp_user_name());
        ipBean.setIp_user_dept(bean.getIp_user_dept());
        ipBean.setIp_type(bean.getIp_type());
        ipBean.setIp_use_status(bean.getIp_use_status());
        ipBean.setPbx_extension(bean.getPbx_extension());
        setDeptList(deptList);
        setProductList(productList);
        
        return SUCCESS;
    }
    
    
     // Go To Edit Page with data 102
    public String updateIpData102() {
        
        HttpServletRequest request = (HttpServletRequest) ActionContext.getContext().get(ServletActionContext.HTTP_REQUEST);
        String ip_no = request.getParameter("ip_no");
        System.out.println("ip_no In Ip Check Action : "+ip_no);
        IpBean bean = ipManager.getSingleIp102(ip_no);
        ipBean.setIp_sl_no(bean.getIp_sl_no());
        ipBean.setIp_no(bean.getIp_no());
        ipBean.setIp_user_name(bean.getIp_user_name());
        ipBean.setIp_user_dept(bean.getIp_user_dept());
        ipBean.setIp_type(bean.getIp_type());
        ipBean.setIp_use_status(bean.getIp_use_status());
        ipBean.setPbx_extension(bean.getPbx_extension());
        setDeptList(deptList);
        setProductList(productList);
        
        return SUCCESS;
    }
    
    
     // Go To Edit Page with data 103
    public String updateIpData103() {
        
        HttpServletRequest request = (HttpServletRequest) ActionContext.getContext().get(ServletActionContext.HTTP_REQUEST);
        String ip_no = request.getParameter("ip_no");
        System.out.println("ip_no In Ip Check Action : "+ip_no);
        IpBean bean = ipManager.getSingleIp103(ip_no);
        ipBean.setIp_sl_no(bean.getIp_sl_no());
        ipBean.setIp_no(bean.getIp_no());
        ipBean.setIp_user_name(bean.getIp_user_name());
        ipBean.setIp_user_dept(bean.getIp_user_dept());
        ipBean.setIp_type(bean.getIp_type());
        ipBean.setIp_use_status(bean.getIp_use_status());
        ipBean.setPbx_extension(bean.getPbx_extension());
        setDeptList(deptList);
        setProductList(productList);
        
        return SUCCESS;
    }
    
    
     // Go To Edit Page with data 104
    public String updateIpData104() {
        
        HttpServletRequest request = (HttpServletRequest) ActionContext.getContext().get(ServletActionContext.HTTP_REQUEST);
        String ip_no = request.getParameter("ip_no");
        System.out.println("ip_no In Ip Check Action : "+ip_no);
        IpBean bean = ipManager.getSingleIp104(ip_no);
        ipBean.setIp_sl_no(bean.getIp_sl_no());
        ipBean.setIp_no(bean.getIp_no());
        ipBean.setIp_user_name(bean.getIp_user_name());
        ipBean.setIp_user_dept(bean.getIp_user_dept());
        ipBean.setIp_type(bean.getIp_type());
        ipBean.setIp_use_status(bean.getIp_use_status());
        ipBean.setPbx_extension(bean.getPbx_extension());
        setDeptList(deptList);
        setProductList(productList);
        
        return SUCCESS;
    }
    
    
     // Go To Edit Page with data 105
    public String updateIpData105() {
        
        HttpServletRequest request = (HttpServletRequest) ActionContext.getContext().get(ServletActionContext.HTTP_REQUEST);
        String ip_no = request.getParameter("ip_no");
        System.out.println("ip_no In Ip Check Action : "+ip_no);
        IpBean bean = ipManager.getSingleIp105(ip_no);
        ipBean.setIp_sl_no(bean.getIp_sl_no());
        ipBean.setIp_no(bean.getIp_no());
        ipBean.setIp_user_name(bean.getIp_user_name());
        ipBean.setIp_user_dept(bean.getIp_user_dept());
        ipBean.setIp_type(bean.getIp_type());
        ipBean.setIp_use_status(bean.getIp_use_status());
        ipBean.setPbx_extension(bean.getPbx_extension());
        setDeptList(deptList);
        setProductList(productList);
        
        return SUCCESS;
    }
    
    
     // Go To Edit Page with data 106
    public String updateIpData106() {
        
        HttpServletRequest request = (HttpServletRequest) ActionContext.getContext().get(ServletActionContext.HTTP_REQUEST);
        String ip_no = request.getParameter("ip_no");
        System.out.println("ip_no In Ip Check Action : "+ip_no);
        IpBean bean = ipManager.getSingleIp106(ip_no);
        ipBean.setIp_sl_no(bean.getIp_sl_no());
        ipBean.setIp_no(bean.getIp_no());
        ipBean.setIp_user_name(bean.getIp_user_name());
        ipBean.setIp_user_dept(bean.getIp_user_dept());
        ipBean.setIp_type(bean.getIp_type());
        ipBean.setIp_use_status(bean.getIp_use_status());
        ipBean.setPbx_extension(bean.getPbx_extension());
        setDeptList(deptList);
        setProductList(productList);
        
        return SUCCESS;
    }
    
    
     // Go To Edit Page with data 107
    public String updateIpData107() {
        
        HttpServletRequest request = (HttpServletRequest) ActionContext.getContext().get(ServletActionContext.HTTP_REQUEST);
        String ip_no = request.getParameter("ip_no");
        System.out.println("ip_no In Ip Check Action : "+ip_no);
        IpBean bean = ipManager.getSingleIp107(ip_no);
        ipBean.setIp_sl_no(bean.getIp_sl_no());
        ipBean.setIp_no(bean.getIp_no());
        ipBean.setIp_user_name(bean.getIp_user_name());
        ipBean.setIp_user_dept(bean.getIp_user_dept());
        ipBean.setIp_type(bean.getIp_type());
        ipBean.setIp_use_status(bean.getIp_use_status());
        ipBean.setPbx_extension(bean.getPbx_extension());
        setDeptList(deptList);
        setProductList(productList);
        
        return SUCCESS;
    }
    
    
     // Go To Edit Page with data 108
    public String updateIpData108() {
        
        HttpServletRequest request = (HttpServletRequest) ActionContext.getContext().get(ServletActionContext.HTTP_REQUEST);
        String ip_no = request.getParameter("ip_no");
        System.out.println("ip_no In Ip Check Action : "+ip_no);
        IpBean bean = ipManager.getSingleIp108(ip_no);
        ipBean.setIp_sl_no(bean.getIp_sl_no());
        ipBean.setIp_no(bean.getIp_no());
        ipBean.setIp_user_name(bean.getIp_user_name());
        ipBean.setIp_user_dept(bean.getIp_user_dept());
        ipBean.setIp_type(bean.getIp_type());
        ipBean.setIp_use_status(bean.getIp_use_status());
        ipBean.setPbx_extension(bean.getPbx_extension());
        setDeptList(deptList);
        setProductList(productList);
        
        return SUCCESS;
    }
    
     // Go To Edit Page with data 109
    public String updateIpData109(){
        
        HttpServletRequest request = (HttpServletRequest) ActionContext.getContext().get(ServletActionContext.HTTP_REQUEST);
        String ip_no = request.getParameter("ip_no");
        System.out.println("ip_no In Ip Check Action : "+ip_no);
        IpBean bean = ipManager.getSingleIp109(ip_no);
        ipBean.setIp_sl_no(bean.getIp_sl_no());
        ipBean.setIp_no(bean.getIp_no());
        ipBean.setIp_user_name(bean.getIp_user_name());
        ipBean.setIp_user_dept(bean.getIp_user_dept());
        ipBean.setIp_type(bean.getIp_type());
        ipBean.setIp_use_status(bean.getIp_use_status());
        ipBean.setPbx_extension(bean.getPbx_extension());
        setDeptList(deptList);
        setProductList(productList);
        
        return SUCCESS;
    }
    
    
    
         // Go To Edit Page with data 109
    public String updateIpData110(){
        
        HttpServletRequest request = (HttpServletRequest) ActionContext.getContext().get(ServletActionContext.HTTP_REQUEST);
        String ip_no = request.getParameter("ip_no");
        System.out.println("ip_no In Ip Check Action : "+ip_no);
        IpBean bean = ipManager.getSingleIp110(ip_no);
        ipBean.setIp_sl_no(bean.getIp_sl_no());
        ipBean.setIp_no(bean.getIp_no());
        ipBean.setIp_user_name(bean.getIp_user_name());
        ipBean.setIp_user_dept(bean.getIp_user_dept());
        ipBean.setIp_type(bean.getIp_type());
        ipBean.setIp_use_status(bean.getIp_use_status());
        ipBean.setPbx_extension(bean.getPbx_extension());
        setDeptList(deptList);
        setProductList(productList);        
        return SUCCESS;
    }
    
    
     // Go To Edit Page with data 192
    public String updateIpData192(){
        
        HttpServletRequest request = (HttpServletRequest) ActionContext.getContext().get(ServletActionContext.HTTP_REQUEST);
        int ip_sl_no = Integer.parseInt(request.getParameter("ip_sl_no"));
        System.out.println("ip_no In Ip Check Action : "+ip_sl_no);
        IpBean bean = ipManager.getSingleIp192(ip_sl_no);
        ipBean.setIp_sl_no(bean.getIp_sl_no());
        ipBean.setIp_no(bean.getIp_no().substring(8));
        ipBean.setIp_user_name(bean.getIp_user_name());
        ipBean.setIp_user_dept(bean.getIp_user_dept());
        ipBean.setIp_type(bean.getIp_type());
        ipBean.setIp_use_status(bean.getIp_use_status());
        ipBean.setPbx_extension(bean.getPbx_extension());
        setDeptList(deptList);
        setProductList(productList);
        return SUCCESS;
    }
    
    // Retrive All Data Form Table ip_vlan_100
    public String viewTableIpVlan100(){
        ipListVlan100 = ipManager.getIpList100();
        return "success";
    }
    
    // Retrive All Data Form Table ip_vlan_101
    public String viewTableIpVlan101(){
        ipListVlan101 = ipManager.getIpList101();
        return "success";
    }
    
        // Retrive All Data Form Table ip_vlan_102
    public String viewTableIpVlan102(){
        ipListVlan102 = ipManager.getIpList102();
        return "success";
    }
    
    // Retrive All Data Form Table ip_vlan_103
    public String viewTableIpVlan103(){
        ipListVlan103 = ipManager.getIpList103();
        return "success";
    }
    
    
    
    // Retrive All Data Form Table ip_vlan_104
    public String viewTableIpVlan104(){
        ipListVlan104 = ipManager.getIpList104();
        return "success";
    }
    
    // Retrive All Data Form Table ip_vlan_105
    public String viewTableIpVlan105(){
        ipListVlan105 = ipManager.getIpList105();
        return "success";
    }
    
    // Retrive All Data Form Table ip_vlan_106
    public String viewTableIpVlan106(){
        ipListVlan106 = ipManager.getIpList106();
        return "success";
    }
    
    // Retrive All Data Form Table ip_vlan_107
    public String viewTableIpVlan107(){
        ipListVlan107 = ipManager.getIpList107();
        return "success";
    }
    
    // Retrive All Data Form Table ip_vlan_108
    public String viewTableIpVlan108(){
        ipListVlan108 = ipManager.getIpList108();
        return "success";
    }
    
    // Retrive All Data Form Table ip_vlan_109
    public String viewTableIpVlan109(){
        ipListVlan109 = ipManager.getIpList109();
        return "success";
    }
    
    // Retrive All Data Form Table ip_vlan_110
    public String viewTableIpVlan110(){
        ipListVlan110 = ipManager.getIpList110();
        return "success";
    }
    
    // Retrive All Data Form Table ip_vlan_192
    public String viewTableIpVlan192(){
        ipListVlan192 = ipManager.getIpList192();
        return "success";
    }
    
    
    // Go To Ip Check page 
    public String check_ip(){
        viewTableIpVlan100();
        viewTableIpVlan101();
        viewTableIpVlan102();
        viewTableIpVlan103();
        viewTableIpVlan104();
        viewTableIpVlan105();
        viewTableIpVlan106();
        viewTableIpVlan107();
        viewTableIpVlan108();
        viewTableIpVlan109();
        viewTableIpVlan110();
        viewTableIpVlan192();
        return "success";
    }
    
    
    public String log_history(){
        
        return "success";
    }
    
    @Override
    public IpBean getModel() {
        return ipBean;
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
    }*/
}
