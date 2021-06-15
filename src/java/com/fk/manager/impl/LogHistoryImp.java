/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fk.manager.impl;

import com.fk.bean.HistoryBean;
import com.fk.database.DBconnection;
import com.fk.manager.LogHistory;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Hasan
 */
public class LogHistoryImp implements LogHistory{

    
    Connection c = null;
    Statement st = null;
    PreparedStatement ps = null;
    ResultSet rs = null;
    
    
    
    @Override
    public List<HistoryBean> getLogHistory() {
        List<HistoryBean> historyList = new ArrayList<>();
        c = DBconnection.getConnection();
        try {
            String query = "SELECT * FROM history ORDER BY sl DESC";
            ps = c.prepareStatement(query);
            rs = ps.executeQuery();
            while (rs.next()) {
                HistoryBean bean = new HistoryBean();
                bean.setSl(rs.getInt("sl"));
                bean.setFklId(rs.getString("fklid"));
                bean.setIp(rs.getString("ip"));
                bean.setMid(rs.getString("mid"));
                bean.setMtype(rs.getString("mtype"));
                bean.setHdd(rs.getString("hdd"));
                bean.setMboard(rs.getString("mboard"));
                bean.setRam(rs.getString("ram"));
                bean.setChip(rs.getString("chip"));
                bean.setPid(rs.getInt("pid"));
                bean.setId(rs.getString("id"));
                bean.setImg_date(rs.getString("img_date"));
                bean.setImg_loc(rs.getString("img_loc"));
                bean.setEmp_name(rs.getString("emp_designation"));
                bean.setHandover_date(rs.getString("handover_date"));
                bean.setDept(rs.getString("dept"));
                bean.setPcstatus(rs.getString("pcstatus"));
                bean.setNstatus(rs.getString("nstatus"));
                bean.setDate(rs.getString("date").substring(0,10));
                bean.setRemarks(rs.getString("remarks"));
                bean.setNote(rs.getString("note"));
                bean.setAction_by_user(rs.getString("action_by_user"));
                bean.setAction_take_by_pc(rs.getString("action_take_by_pc"));
                
                historyList.add(bean);
            }
            rs.close();
            c.close();
        } catch (Exception e) {
            System.out.println(e);
        }
        return historyList;
    }
    
    

    
}
