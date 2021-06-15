/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fk.bean;

import java.util.List;

/**
 *
 * @author Hasan Mobarak<biplobjugp40@gmail.com>
 */
public class IpBean {
    
    private int    ip_sl_no;
    private String ip_no;
    private String ip_user_name;
    private String ip_user_dept;
    private String ip_type;
    private String ip_use_status;
    private String pbx_extension;
    private List<IpBean> ipBeans;
    
    
    
    public IpBean() {
    }

    public IpBean(String ip_no, String ip_user_name, String ip_user_dept, String ip_type, String ip_use_status, String pbx_extension){
        this.ip_no = ip_no;
        this.ip_user_name = ip_user_name;
        this.ip_user_dept = ip_user_dept;
        this.ip_type = ip_type;
        this.ip_use_status = ip_use_status;
        this.pbx_extension = pbx_extension;
    }

    public IpBean(int ip_sl_no, String ip_no, String ip_user_name, String ip_user_dept, String ip_type, String ip_use_status, String pbx_extension) {
        this.ip_sl_no = ip_sl_no;
        this.ip_no = ip_no;
        this.ip_user_name = ip_user_name;
        this.ip_user_dept = ip_user_dept;
        this.ip_type = ip_type;
        this.ip_use_status = ip_use_status;
        this.pbx_extension = pbx_extension;
    }
    
    

    public int getIp_sl_no(){
        return ip_sl_no;
    }

    public void setIp_sl_no(int ip_sl_no) {
        this.ip_sl_no = ip_sl_no;
    }

    public String getIp_no(){
        return ip_no;
    }

    public void setIp_no(String ip_no){
        this.ip_no = ip_no;
    }

    public String getIp_user_name(){
        return ip_user_name;
    }

    public void setIp_user_name(String ip_user_name){
        this.ip_user_name = ip_user_name;
    }

    public String getIp_user_dept(){
        return ip_user_dept;
    }

    public void setIp_user_dept(String ip_user_dept){
        this.ip_user_dept = ip_user_dept;
    }

    public String getIp_type(){
        return ip_type;
    }
    
    public String getPbx_extension() {
        return pbx_extension;
    }
    
    public void setPbx_extension(String pbx_extension){
        this.pbx_extension = pbx_extension;
    }

    
    
    public void setIp_type(String ip_type){
        this.ip_type = ip_type;
    }

    public String getIp_use_status() {
        return ip_use_status;
    }

    public void setIp_use_status(String ip_use_status) {
        this.ip_use_status = ip_use_status;
    }

    @Override
    public String toString() {
        return "IpBean{" + "ip_sl_no=" + ip_sl_no + ", ip_no=" + ip_no + ", ip_user_name=" + ip_user_name + ", ip_user_dept=" + ip_user_dept + ", ip_type=" + ip_type + ", ip_use_status=" + ip_use_status + ", pbx_extension=" + pbx_extension + ", ipBeans=" + ipBeans + '}';
    }
    
    
    
    public List<IpBean> getIpBeans(){
        return ipBeans;
    }

    public void setIpBeans(List<IpBean> ipBeans) {
        this.ipBeans = ipBeans;
    }
    
}
