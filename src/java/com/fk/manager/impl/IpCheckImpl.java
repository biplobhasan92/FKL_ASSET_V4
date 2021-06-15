/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fk.manager.impl;

import com.fk.bean.IpBean;
import com.fk.database.DBconnection;
import com.fk.manager.IpCheckManager;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Hasan
 */
public class IpCheckImpl implements IpCheckManager{

    
    Connection c = null;
    Statement st = null;
    PreparedStatement ps = null;
    ResultSet rs = null;

    
    // Retrive All Data From Database
    
    @Override
    public List<IpBean> getIpList100() {

        List<IpBean> ipBean = new ArrayList<IpBean>();
        c = DBconnection.getConnection();

        try {

            String query = "SELECT * FROM ip_vlan_100 ORDER BY ip_sl_no ASC";
            ps = c.prepareStatement(query);
            rs = ps.executeQuery();
            while (rs.next()){
                IpBean bean = new IpBean();
                bean.setIp_sl_no(rs.getInt("ip_sl_no"));
                bean.setIp_no(rs.getString("ip_no"));
                bean.setIp_user_name(rs.getString("ip_user_name"));
                bean.setIp_user_dept(rs.getString("ip_user_dept"));
                bean.setIp_type(rs.getString("ip_type"));
                bean.setIp_use_status(rs.getString("ip_use_status"));
                bean.setPbx_extension(rs.getString("pbx_extension"));
                ipBean.add(bean);
            }
            rs.close();
            c.close();
        } catch (Exception e) {
            System.out.println(e);
        }
        return ipBean;

    }
    
    
    
    @Override
    public List<IpBean> getIpList101() {
        
        List<IpBean> ipBean = new ArrayList<IpBean>();
        c = DBconnection.getConnection();

        try {

            String query = "SELECT * FROM ip_vlan_101 ORDER BY ip_sl_no ASC";
            ps = c.prepareStatement(query);
            rs = ps.executeQuery();

            while (rs.next()) {
                IpBean bean = new IpBean();
                bean.setIp_sl_no(rs.getInt("ip_sl_no"));
                bean.setIp_no(rs.getString("ip_no"));
                bean.setIp_user_name(rs.getString("ip_user_name"));
                bean.setIp_user_dept(rs.getString("ip_user_dept"));
                bean.setIp_type(rs.getString("ip_type"));
                bean.setIp_use_status(rs.getString("ip_use_status"));
                bean.setPbx_extension(rs.getString("pbx_extension"));
                ipBean.add(bean);
            }
            rs.close();
            c.close();
        } catch (Exception e) {
            System.out.println(e);
        }
        return ipBean;
    }

    @Override
    public List<IpBean> getIpList102() {
        List<IpBean> ipBean = new ArrayList<IpBean>();
        c = DBconnection.getConnection();

        try {

            String query = "SELECT * FROM ip_vlan_102 ORDER BY `ip_sl_no` ASC";
            ps = c.prepareStatement(query);
            rs = ps.executeQuery();

            while (rs.next()) {
                IpBean bean = new IpBean();
                bean.setIp_sl_no(rs.getInt("ip_sl_no"));
                bean.setIp_no(rs.getString("ip_no"));
                bean.setIp_user_name(rs.getString("ip_user_name"));
                bean.setIp_user_dept(rs.getString("ip_user_dept"));
                bean.setIp_type(rs.getString("ip_type"));
                bean.setIp_use_status(rs.getString("ip_use_status"));
                bean.setPbx_extension(rs.getString("pbx_extension"));
                ipBean.add(bean);
            }
            rs.close();
            c.close();
        } catch (Exception e) {
            System.out.println(e);
        }
        return ipBean;
    }

    @Override
    public List<IpBean> getIpList103() {
       List<IpBean> ipBean = new ArrayList<IpBean>();
        c = DBconnection.getConnection();

        try {

            String query = "SELECT * FROM ip_vlan_103 ORDER BY `ip_sl_no` ASC";
            ps = c.prepareStatement(query);
            rs = ps.executeQuery();

            while (rs.next()) {
                IpBean bean = new IpBean();
                bean.setIp_sl_no(rs.getInt("ip_sl_no"));
                bean.setIp_no(rs.getString("ip_no"));
                bean.setIp_user_name(rs.getString("ip_user_name"));
                bean.setIp_user_dept(rs.getString("ip_user_dept"));
                bean.setIp_type(rs.getString("ip_type"));
                bean.setIp_use_status(rs.getString("ip_use_status"));
                bean.setPbx_extension(rs.getString("pbx_extension"));
                ipBean.add(bean);
            }
            rs.close();
            c.close();
        } catch (Exception e) {
            System.out.println(e);
        }
        return ipBean;
    }

    @Override
    public List<IpBean> getIpList104() {
        List<IpBean> ipBean = new ArrayList<IpBean>();
        c = DBconnection.getConnection();

        try {

            String query = "SELECT * FROM ip_vlan_104 ORDER BY `ip_sl_no` ASC";
            ps = c.prepareStatement(query);
            rs = ps.executeQuery();

            while (rs.next()) {
                IpBean bean = new IpBean();
                bean.setIp_sl_no(rs.getInt("ip_sl_no"));
                bean.setIp_no(rs.getString("ip_no"));
                bean.setIp_user_name(rs.getString("ip_user_name"));
                bean.setIp_user_dept(rs.getString("ip_user_dept"));
                bean.setIp_type(rs.getString("ip_type"));
                bean.setIp_use_status(rs.getString("ip_use_status"));
                bean.setPbx_extension(rs.getString("pbx_extension"));
                ipBean.add(bean);
            }
            rs.close();
            c.close();
        } catch (Exception e) {
            System.out.println(e);
        }
        return ipBean;
    }

    @Override
    public List<IpBean> getIpList105() {
        List<IpBean> ipBean = new ArrayList<IpBean>();
        c = DBconnection.getConnection();

        try {

            String query = "SELECT * FROM ip_vlan_105 ORDER BY `ip_sl_no` ASC";
            ps = c.prepareStatement(query);
            rs = ps.executeQuery();

            while (rs.next()) {
                IpBean bean = new IpBean();
                bean.setIp_sl_no(rs.getInt("ip_sl_no"));
                bean.setIp_no(rs.getString("ip_no"));
                bean.setIp_user_name(rs.getString("ip_user_name"));
                bean.setIp_user_dept(rs.getString("ip_user_dept"));
                bean.setIp_type(rs.getString("ip_type"));
                bean.setIp_use_status(rs.getString("ip_use_status"));
                bean.setPbx_extension(rs.getString("pbx_extension"));
                ipBean.add(bean);
            }
            rs.close();
            c.close();
        } catch (Exception e) {
            System.out.println(e);
        }
        return ipBean;
    }

    @Override
    public List<IpBean> getIpList106() {
        List<IpBean> ipBean = new ArrayList<IpBean>();
        c = DBconnection.getConnection();

        try {

            String query = "SELECT * FROM ip_vlan_106 ORDER BY `ip_sl_no` ASC";
            ps = c.prepareStatement(query);
            rs = ps.executeQuery();

            while (rs.next()) {
                IpBean bean = new IpBean();
                bean.setIp_sl_no(rs.getInt("ip_sl_no"));
                bean.setIp_no(rs.getString("ip_no"));
                bean.setIp_user_name(rs.getString("ip_user_name"));
                bean.setIp_user_dept(rs.getString("ip_user_dept"));
                bean.setIp_type(rs.getString("ip_type"));
                bean.setIp_use_status(rs.getString("ip_use_status"));
                bean.setPbx_extension(rs.getString("pbx_extension"));
                ipBean.add(bean);
            }
            rs.close();
            c.close();
        } catch (Exception e) {
            System.out.println(e);
        }
        return ipBean;
    }

    @Override
    public List<IpBean> getIpList107() {
        List<IpBean> ipBean = new ArrayList<IpBean>();
        c = DBconnection.getConnection();

        try {

            String query = "SELECT * FROM ip_vlan_107 ORDER BY `ip_sl_no` ASC";
            ps = c.prepareStatement(query);
            rs = ps.executeQuery();

            while (rs.next()) {
                IpBean bean = new IpBean();
                bean.setIp_sl_no(rs.getInt("ip_sl_no"));
                bean.setIp_no(rs.getString("ip_no"));
                bean.setIp_user_name(rs.getString("ip_user_name"));
                bean.setIp_user_dept(rs.getString("ip_user_dept"));
                bean.setIp_type(rs.getString("ip_type"));
                bean.setIp_use_status(rs.getString("ip_use_status"));
                bean.setPbx_extension(rs.getString("pbx_extension"));
                ipBean.add(bean);
            }
            rs.close();
            c.close();
        } catch (Exception e) {
            System.out.println(e);
        }
        return ipBean;
    }

    @Override
    public List<IpBean> getIpList108() {
        List<IpBean> ipBean = new ArrayList<IpBean>();
        c = DBconnection.getConnection();

        try {
            String query = "SELECT * FROM ip_vlan_108 ORDER BY `ip_sl_no` ASC";
            ps = c.prepareStatement(query);
            rs = ps.executeQuery();

            while (rs.next()) {
                IpBean bean = new IpBean();
                bean.setIp_sl_no(rs.getInt("ip_sl_no"));
                bean.setIp_no(rs.getString("ip_no"));
                bean.setIp_user_name(rs.getString("ip_user_name"));
                bean.setIp_user_dept(rs.getString("ip_user_dept"));
                bean.setIp_type(rs.getString("ip_type"));
                bean.setIp_use_status(rs.getString("ip_use_status"));
                bean.setPbx_extension(rs.getString("pbx_extension"));
                ipBean.add(bean);
            }
            rs.close();
            c.close();
        } catch (Exception e) {
            System.out.println(e);
        }
        return ipBean;
    }

    @Override
    public List<IpBean> getIpList109() {
        List<IpBean> ipBean = new ArrayList<IpBean>();
        c = DBconnection.getConnection();

        try {
            String query = "SELECT * FROM ip_vlan_109 ORDER BY `ip_sl_no` ASC";
            ps = c.prepareStatement(query);
            rs = ps.executeQuery();

            while (rs.next()) {
                IpBean bean = new IpBean();
                bean.setIp_sl_no(rs.getInt("ip_sl_no"));
                bean.setIp_no(rs.getString("ip_no"));
                bean.setIp_user_name(rs.getString("ip_user_name"));
                bean.setIp_user_dept(rs.getString("ip_user_dept"));
                bean.setIp_type(rs.getString("ip_type"));
                bean.setIp_use_status(rs.getString("ip_use_status"));
                bean.setPbx_extension(rs.getString("pbx_extension"));
                ipBean.add(bean);
            }
            rs.close();
            c.close();
        } catch (Exception e) {
            System.out.println(e);
        }
        return ipBean;
    }
    
    
    
    
     @Override
    public List<IpBean> getIpList110() {
        List<IpBean> ipBean = new ArrayList<IpBean>();
        c = DBconnection.getConnection();

        try {
            String query = "SELECT * FROM ip_vlan_110 ORDER BY `ip_sl_no` ASC";
            ps = c.prepareStatement(query);
            rs = ps.executeQuery();

            while (rs.next()) {
                IpBean bean = new IpBean();
                bean.setIp_sl_no(rs.getInt("ip_sl_no"));
                bean.setIp_no(rs.getString("ip_no"));
                bean.setIp_user_name(rs.getString("ip_user_name"));
                bean.setIp_user_dept(rs.getString("ip_user_dept"));
                bean.setIp_type(rs.getString("ip_type"));
                bean.setIp_use_status(rs.getString("ip_use_status"));
                bean.setPbx_extension(rs.getString("pbx_extension"));
                ipBean.add(bean);
            }
            rs.close();
            c.close();
        } catch (Exception e) {
            System.out.println(e);
        }
        return ipBean;
    }
    
    
    @Override
    public List<IpBean> getIpList192() {
        List<IpBean> ipBean = new ArrayList<IpBean>();
        c = DBconnection.getConnection();

        try {
            String query = "SELECT * FROM ip_vlan_192 ORDER BY ip_sl_no ASC";
            ps = c.prepareStatement(query);
            rs = ps.executeQuery();

            while (rs.next()) {
                IpBean bean = new IpBean();
                bean.setIp_sl_no(rs.getInt("ip_sl_no"));
                bean.setIp_no(rs.getString("ip_no"));
                bean.setIp_user_name(rs.getString("ip_user_name"));
                bean.setIp_user_dept(rs.getString("ip_user_dept"));
                bean.setIp_type(rs.getString("ip_type"));
                bean.setIp_use_status(rs.getString("ip_use_status"));
                bean.setPbx_extension(rs.getString("pbx_extension"));
                ipBean.add(bean);
            }
            rs.close();
            c.close();
        } catch (Exception e) {
            System.out.println(e);
        }
        return ipBean;
    }
    
    
    
    
    
    
   
    
    
    @Override
    public boolean saveIpList100(IpBean ipBean) {
        
        try {
            c = DBconnection.getConnection();
            String sql = "INSERT INTO ip_vlan_100(ip_no, ip_user_name, ip_user_dept, ip_type, ip_use_status) values(?,?,?,?,?) ";
            ps = c.prepareStatement(sql);
            ps.setString(1, ipBean.getIp_no());
            ps.setString(2, ipBean.getIp_user_name());
            ps.setString(3, ipBean.getIp_user_dept());
            ps.setString(4, ipBean.getIp_type());
            ps.setString(5, ipBean.getIp_use_status());
            int val = ps.executeUpdate();
            if(val>0){
                return true;
            }
            ps.close();
            c.close();
        } catch (Exception e) {
        }
        
        return false;
    }
    
    
    
    @Override
    public boolean updateIpList100(IpBean ipBean) {
        
        String s = ipBean.getIp_no();
        String subS = s.substring(7, 10);
        System.out.println("IP V-Lan No: "+subS);
        
        try {
            c = DBconnection.getConnection();
            String sql = "UPDATE ip_vlan_"+subS+" SET ip_user_name = ?, ip_user_dept = ?, ip_type = ?, ip_use_status = ?, pbx_extension = ? where ip_no = ? ";
            
            ps = c.prepareStatement(sql);
            ps.setString(1, ipBean.getIp_user_name());
            ps.setString(2, ipBean.getIp_user_dept());
            ps.setString(3, ipBean.getIp_type());
            ps.setString(4, ipBean.getIp_use_status());
            ps.setString(5, ipBean.getPbx_extension());
            ps.setString(6, ipBean.getIp_no());
            
            int val = ps.executeUpdate();
            if(val>0){
                return true;
            }
            ps.close();
            c.close();
        } catch (Exception e) {
            e.printStackTrace();
        }        
        return false;
    }
    
    
    @Override
    public boolean updateIpList192(IpBean ipBean) {
        
        System.out.println("IP SL No: "+ipBean.getIp_sl_no());
        System.out.println("IP No: "+ipBean.getIp_no());        
        try {
            c = DBconnection.getConnection();
            String sql = "UPDATE ip_vlan_192 SET ip_no = ?, ip_user_name = ?, ip_user_dept = ?, ip_type = ?, ip_use_status = ?, pbx_extension = ? where ip_sl_no = ? ";
            
            ps = c.prepareStatement(sql);
            ps.setString(1, ipBean.getIp_no());
            ps.setString(2, ipBean.getIp_user_name());
            ps.setString(3, ipBean.getIp_user_dept());
            ps.setString(4, ipBean.getIp_type());
            ps.setString(5, ipBean.getIp_use_status());
            ps.setString(6, ipBean.getPbx_extension());
            ps.setInt(7, ipBean.getIp_sl_no());
            
            int val = ps.executeUpdate();
            if(val>0){
                return true;
            }
            ps.close();
            c.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        return false;
    }
    
    
    

    @Override
    public boolean deleteIpList100(IpBean ipBean) {
        
        try {
            c = DBconnection.getConnection();
            String sql = "DELETE FROM ip_vlan_100 WHERE ip_sl_no = ? ";
            ps = c.prepareStatement(sql);
            ps.setInt(1, ipBean.getIp_sl_no());
            int val = ps.executeUpdate();
            if(val>0){
                return true;
            }
            ps.close();
            c.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        return false;
    }
    
    
    
    
    
    @Override
    public IpBean getSingleIp100(String ip_no) {
        c = DBconnection.getConnection();
        IpBean bean = null;

        try {
            String query ="select * from ip_vlan_100 where ip_no = ?";
            ps = c.prepareStatement(query);
            ps.setString(1, ip_no);
            rs = ps.executeQuery();

            while(rs.next()){
                bean = new IpBean();
                bean.setIp_sl_no(rs.getInt("ip_sl_no"));
                bean.setIp_no(rs.getString("ip_no"));
                bean.setIp_user_name(rs.getString("ip_user_name"));
                bean.setIp_user_dept(rs.getString("ip_user_dept"));
                bean.setIp_type(rs.getString("ip_type"));
                bean.setPbx_extension(rs.getString("pbx_extension"));
                bean.setIp_use_status(rs.getString("ip_use_status"));
            }
            rs.close();
            c.close();
        } catch (Exception e) {
            System.out.println(e);
        }
        return bean;
    }
    
    @Override
    public IpBean getSingleIp101(String ip_no) {
		c = DBconnection.getConnection();
		IpBean bean = null;

		try {

			String query ="select * from ip_vlan_101 where ip_no = ?";
			ps = c.prepareStatement(query);
			ps.setString(1, ip_no);
			rs = ps.executeQuery();
			
			while(rs.next()){
                            bean = new IpBean();
                            bean.setIp_sl_no(rs.getInt("ip_sl_no"));
                            bean.setIp_no(rs.getString("ip_no"));
                            bean.setIp_user_name(rs.getString("ip_user_name"));
                            bean.setIp_user_dept(rs.getString("ip_user_dept"));
                            bean.setIp_type(rs.getString("ip_type"));
                            bean.setIp_use_status(rs.getString("ip_use_status"));                            
                            bean.setPbx_extension(rs.getString("pbx_extension"));
			}
			
			rs.close();
			c.close();
                        
			
		} catch (Exception e) {
			System.out.println(e);
		}
		return bean;
	}
    
    
    
    
    @Override
    public IpBean getSingleIp102(String ip_no) {
		c = DBconnection.getConnection();
		IpBean bean = null;

		try {

			String query ="select * from ip_vlan_102 where ip_no = ?";
			ps = c.prepareStatement(query);
			ps.setString(1, ip_no);
			rs = ps.executeQuery();
			
			while(rs.next()){
                            bean = new IpBean();
                            bean.setIp_sl_no(rs.getInt("ip_sl_no"));
                            bean.setIp_no(rs.getString("ip_no"));
                            bean.setIp_user_name(rs.getString("ip_user_name"));
                            bean.setIp_user_dept(rs.getString("ip_user_dept"));
                            bean.setIp_type(rs.getString("ip_type"));
                            bean.setIp_use_status(rs.getString("ip_use_status"));                            
                            bean.setPbx_extension(rs.getString("pbx_extension"));
			}
			
			rs.close();
			c.close();
                        
			
		} catch (Exception e) {
			System.out.println(e);
		}
		return bean;
	}
    
    
    
    @Override
    public IpBean getSingleIp103(String ip_no) {
		c = DBconnection.getConnection();
		IpBean bean = null;

		try {

			String query ="select * from ip_vlan_103 where ip_no = ?";
			ps = c.prepareStatement(query);
			ps.setString(1, ip_no);
			rs = ps.executeQuery();
			
			while(rs.next()){
                            bean = new IpBean();
                            bean.setIp_sl_no(rs.getInt("ip_sl_no"));
                            bean.setIp_no(rs.getString("ip_no"));
                            bean.setIp_user_name(rs.getString("ip_user_name"));
                            bean.setIp_user_dept(rs.getString("ip_user_dept"));
                            bean.setIp_type(rs.getString("ip_type"));
                            bean.setIp_use_status(rs.getString("ip_use_status"));                            
                            bean.setPbx_extension(rs.getString("pbx_extension"));
			}
			
			rs.close();
			c.close();
                        
			
		} catch (Exception e) {
			System.out.println(e);
		}
		return bean;
	}
    
    @Override
    public IpBean getSingleIp104(String ip_no) {
		c = DBconnection.getConnection();
		IpBean bean = null;

		try {

			String query ="select * from ip_vlan_104 where ip_no = ?";
			ps = c.prepareStatement(query);
			ps.setString(1, ip_no);
			rs = ps.executeQuery();
			
			while(rs.next()){
                            bean = new IpBean();
                            bean.setIp_sl_no(rs.getInt("ip_sl_no"));
                            bean.setIp_no(rs.getString("ip_no"));
                            bean.setIp_user_name(rs.getString("ip_user_name"));
                            bean.setIp_user_dept(rs.getString("ip_user_dept"));
                            bean.setIp_type(rs.getString("ip_type"));
                            bean.setIp_use_status(rs.getString("ip_use_status"));
                            bean.setPbx_extension(rs.getString("pbx_extension"));
			}
			
			rs.close();
			c.close();
                        
			
		} catch (Exception e) {
			System.out.println(e);
		}
		return bean;
	}
    
    
    @Override
    public IpBean getSingleIp105(String ip_no) {
		c = DBconnection.getConnection();
		IpBean bean = null;

		try {

			String query ="select * from ip_vlan_105 where ip_no = ?";
			ps = c.prepareStatement(query);
			ps.setString(1, ip_no);
			rs = ps.executeQuery();
			
			while(rs.next()){
                            bean = new IpBean();
                            bean.setIp_sl_no(rs.getInt("ip_sl_no"));
                            bean.setIp_no(rs.getString("ip_no"));
                            bean.setIp_user_name(rs.getString("ip_user_name"));
                            bean.setIp_user_dept(rs.getString("ip_user_dept"));
                            bean.setIp_type(rs.getString("ip_type"));
                            bean.setIp_use_status(rs.getString("ip_use_status"));
                            bean.setPbx_extension(rs.getString("pbx_extension"));
			}
			
			rs.close();
			c.close();
                        
			
		} catch (Exception e) {
			System.out.println(e);
		}
		return bean;
	}
    
    
    @Override
    public IpBean getSingleIp106(String ip_no) {
		c = DBconnection.getConnection();
		IpBean bean = null;

		try {

			String query ="select * from ip_vlan_106 where ip_no = ?";
			ps = c.prepareStatement(query);
			ps.setString(1, ip_no);
			rs = ps.executeQuery();
			
			while(rs.next()){
                            bean = new IpBean();
                            bean.setIp_sl_no(rs.getInt("ip_sl_no"));
                            bean.setIp_no(rs.getString("ip_no"));
                            bean.setIp_user_name(rs.getString("ip_user_name"));
                            bean.setIp_user_dept(rs.getString("ip_user_dept"));
                            bean.setIp_type(rs.getString("ip_type"));
                            bean.setIp_use_status(rs.getString("ip_use_status"));
                            bean.setPbx_extension(rs.getString("pbx_extension"));
			}
			
			rs.close();
			c.close();
                        
			
		} catch (Exception e) {
			System.out.println(e);
		}
		return bean;
	}
    
    @Override
    public IpBean getSingleIp107(String ip_no) {
		c = DBconnection.getConnection();
		IpBean bean = null;

		try {

			String query ="select * from ip_vlan_107 where ip_no = ?";
			ps = c.prepareStatement(query);
			ps.setString(1, ip_no);
			rs = ps.executeQuery();
			
			while(rs.next()){
                            bean = new IpBean();
                            bean.setIp_sl_no(rs.getInt("ip_sl_no"));
                            bean.setIp_no(rs.getString("ip_no"));
                            bean.setIp_user_name(rs.getString("ip_user_name"));
                            bean.setIp_user_dept(rs.getString("ip_user_dept"));
                            bean.setIp_type(rs.getString("ip_type"));
                            bean.setIp_use_status(rs.getString("ip_use_status"));                            
                            bean.setPbx_extension(rs.getString("pbx_extension"));
			}
			
			rs.close();
			c.close();
                        
			
		} catch (Exception e) {
			System.out.println(e);
		}
		return bean;
	}
    
    @Override
    public IpBean getSingleIp108(String ip_no) {
            c = DBconnection.getConnection();
            IpBean bean = null;
            try {
                String query ="select * from ip_vlan_108 where ip_no = ?";
                ps = c.prepareStatement(query);
                ps.setString(1, ip_no);
                rs = ps.executeQuery();
                while(rs.next()){
                    bean = new IpBean();
                    bean.setIp_sl_no(rs.getInt("ip_sl_no"));
                    bean.setIp_no(rs.getString("ip_no"));
                    bean.setIp_user_name(rs.getString("ip_user_name"));
                    bean.setIp_user_dept(rs.getString("ip_user_dept"));
                    bean.setIp_type(rs.getString("ip_type"));
                    bean.setIp_use_status(rs.getString("ip_use_status"));                            
                    bean.setPbx_extension(rs.getString("pbx_extension"));
                }			
                rs.close();
                c.close();                     			
            } catch (Exception e) {
                System.out.println(e);
            }
            return bean;
	}
    
    
    
        
        
        
        
    
        @Override
        public IpBean getSingleIp109(String ip_no) {
	    
            c = DBconnection.getConnection();
	    IpBean bean = null;
	    try {
		String query ="select * from ip_vlan_109 where ip_no = ?";
		ps = c.prepareStatement(query);
		ps.setString(1, ip_no);
		rs = ps.executeQuery();			
		while(rs.next()){
                    bean = new IpBean();
                    bean.setIp_sl_no(rs.getInt("ip_sl_no"));
                    bean.setIp_no(rs.getString("ip_no"));
                    bean.setIp_user_name(rs.getString("ip_user_name"));
                    bean.setIp_user_dept(rs.getString("ip_user_dept"));
                    bean.setIp_type(rs.getString("ip_type"));
                    bean.setIp_use_status(rs.getString("ip_use_status"));
                    bean.setPbx_extension(rs.getString("pbx_extension"));
                }		
                rs.close();
                c.close();                        			
            }catch (Exception e) {
                System.out.println(e);
            }
            return bean;
        }
        
        
        
        @Override
        public IpBean getSingleIp110(String ip_no){            
            c = DBconnection.getConnection();
	    IpBean bean = null;
	    try{
		String query ="select * from ip_vlan_110 where ip_no = ?";
		ps = c.prepareStatement(query);
		ps.setString(1, ip_no);
		rs = ps.executeQuery();			
		while(rs.next()){
                    bean = new IpBean();
                    bean.setIp_sl_no(rs.getInt("ip_sl_no"));
                    bean.setIp_no(rs.getString("ip_no"));
                    bean.setIp_user_name(rs.getString("ip_user_name"));
                    bean.setIp_user_dept(rs.getString("ip_user_dept"));
                    bean.setIp_type(rs.getString("ip_type"));
                    bean.setIp_use_status(rs.getString("ip_use_status"));
                    bean.setPbx_extension(rs.getString("pbx_extension"));
                }
                rs.close();
                c.close();                        			
            }catch (Exception e){
                System.out.println(e);
            }
            return bean;
        }
    
        
        
    
        @Override
        public IpBean getSingleIp192(int ip_sl_no) {
            c = DBconnection.getConnection();
            IpBean bean = null;
            try {
                String query ="select * from ip_vlan_192 where ip_sl_no = ?";
                ps = c.prepareStatement(query);
                ps.setInt(1, ip_sl_no);
                rs = ps.executeQuery();
                while(rs.next()){
                    bean = new IpBean();
                    bean.setIp_sl_no(rs.getInt("ip_sl_no"));
                    bean.setIp_no(rs.getString("ip_no"));
                    bean.setIp_user_name(rs.getString("ip_user_name"));
                    bean.setIp_user_dept(rs.getString("ip_user_dept"));
                    bean.setIp_type(rs.getString("ip_type"));
                    bean.setIp_use_status(rs.getString("ip_use_status"));                            
                    bean.setPbx_extension(rs.getString("pbx_extension"));
                }
                rs.close();
                c.close();                 			
            } catch (Exception e){
                System.out.println(e);
            }
            return bean;
        }
 
    
    
    
/*
    

    public static void main(String[] args) {
        IpCheckImpl checkImpl = new IpCheckImpl();
        IpBean ipList_100 = new  IpBean("172.16.109.5", "Biplob Misra", "Accounts", "PC", "Inactive");
//        boolean b = checkImpl.updateIpList100(ipList_100);
        List<IpBean> ipList_109 = checkImpl.getIpList192();
        
        for (int i = 0; i < ipList_109.size(); i++) {
            System.out.println("SL NO: "+ipList_109.get(i));
        }
        
        System.out.println("IP NO:"+ipList_100.getIp_no());
        System.out.println("IP SL:"+ipList_100.getIp_sl_no());
        System.out.println("IP NO:"+ipList_100.getIp_user_name());
       
    }


*/

   

    


    
    
}    
    

