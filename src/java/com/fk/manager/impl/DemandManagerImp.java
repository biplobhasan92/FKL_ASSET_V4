/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fk.manager.impl;

import com.fk.bean.DemandBean;
import com.fk.bean.Demand;
import com.fk.bean.DemandDesc;
import com.fk.bean.DemandDetails;
import com.fk.database.DBconnection;
import com.fk.manager.DemandManager;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Hasan
 */
public class DemandManagerImp implements DemandManager{

    private ResultSet rs = null;
    private Connection con = null;
    private PreparedStatement pst = null;
    private List <DemandDetails> demandDetail;
    private DemandBean bean = null;
    private Demand demand;
    
    
    
    @Override
    public boolean saveDemand(DemandBean dBean){
        
        demandDetail = dBean.getDemandDetail();     
        con = DBconnection.getConnection();
        if(con==null){
            return false;
        }            
        
        try{     // single table .............            
            String saveDmnd = " INSERT INTO "+
                    "  demand_note(ddn_no, demandDate, nameOfApplicant, department, desigWithId, submitedTo) "+
                  " VALUES(?,?,?,?,?,?) ";
            pst = con.prepareStatement(saveDmnd);
            pst.setInt(1,dBean.getDdn_no());
            pst.setString(2, dBean.getDemandDate());
            pst.setString(3, dBean.getNameOfApplicant());
            pst.setString(4, dBean.getDepartment());
            pst.setString(5, dBean.getDesigWithId());
            pst.setString(6, dBean.getSubmitedTo());
            pst.addBatch();
            pst.executeBatch();
        }catch(SQLException e){
            e.printStackTrace();
            return false;
        }finally{
            try {
                pst.close();
            } catch (SQLException ex){
                Logger.getLogger(DemandManagerImp.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        
        
        try{ // Multiple Table ...........................            
            String saveDmndSub = "INSERT INTO demand_note_sub(ddn_no, description, brand, model, weight, pcs, partsno, location, remarks, status) VALUES(?,?,?,?,?,?,?,?,?,?)";
            pst = con.prepareStatement(saveDmndSub);
            for (DemandDetails p : demandDetail){
                pst.setInt(1, dBean.getDdn_no());
                pst.setString(2, p.getDescription());
                pst.setString(3, p.getBrand());
                pst.setString(4, p.getModel());
                pst.setInt(5, p.getWeight());
                pst.setInt(6, p.getPcs());
                pst.setInt(7, p.getPartsNo());
                pst.setString(8, p.getLocation());
                pst.setString(9, p.getRemarks());
                pst.setString(10, "Pending");
                pst.addBatch();
                pst.executeBatch();
            }
        }catch(SQLException e){
            e.printStackTrace();
            return false;
        }finally{
            try {
                pst.close();
            }catch (SQLException ex){
                Logger.getLogger(DemandManagerImp.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return true;
    }

    
    
    
    @Override
    public boolean saveDemandSub(DemandBean dBena) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    
    
    @Override
    public List<Demand> getAllDemand(){
        
        List<Demand> demands =new ArrayList<>();        
        try {
            con = DBconnection.getConnection();
            if(con == null)
            {
                return demands;
            }
            String sql = " SELECT \n" +
                "  * \n" +
                " FROM\n" +
                "  demand_note d\n" +
                " JOIN\n" +
                "  demand_note_sub ds\n" +
                " ON(d.ddn_no=ds.ddn_no)";
            pst = con.prepareStatement(sql);
            ResultSet rs = pst.executeQuery(sql);
            Demand d;
            while(rs.next())
            {
                d = new Demand();
                d.setDmndID(rs.getInt("dmndID"));
                d.setDdn_no(rs.getInt("ddn_no"));
                d.setDemandDate(rs.getString("demandDate"));
                d.setNameOfApplicant(rs.getString("nameOfApplicant"));
                d.setDepartment(rs.getString("department"));
                d.setDesigWithId(rs.getString("desigWithId"));
                d.setSubmitedTo(rs.getString("submitedTo"));
                d.setSl(rs.getInt("sl"));
                d.setDescription(rs.getString("description"));
                d.setBrand(rs.getString("brand"));
                d.setModel(rs.getString("model"));
                d.setWeight(rs.getInt("weight"));
                d.setPcs(rs.getInt("pcs"));
                d.setPartsNo(rs.getInt("partsNo"));
                d.setLocation(rs.getString("location"));
                d.setStatus(rs.getString("status"));
                d.setRemarks(rs.getString("remarks"));
                demands.add(d);
            }
            rs.close();
            pst.close();
            con.close();
        } catch (SQLException ex){
            ex.printStackTrace();
        }
        return demands;
    }

    
    
    
    @Override
    public List<Demand> getSingleDemand(int ddn_no){
        
        List<Demand> demands =new ArrayList<>();
        try{
            con = DBconnection.getConnection();
            if(con == null){
                return demands;
            }
            String sql =" SELECT \n" +
                "  * \n" +
                " FROM \n" +
                "  demand_note d \n" +
                " JOIN \n" +
                "  demand_note_sub ds\n" +
                " ON(d.ddn_no=ds.ddn_no) \n" +
                "  WHERE \n" +
                " d.ddn_no="+ddn_no+" ";
            pst = con.prepareStatement(sql);
            rs = pst.executeQuery(sql);
            Demand d;
            while(rs.next())
            {
                d = new Demand();
                d.setDmndID(rs.getInt("dmndID"));
                d.setDdn_no(rs.getInt("ddn_no"));
                d.setDemandDate(rs.getString("demandDate"));
                d.setNameOfApplicant(rs.getString("nameOfApplicant"));
                d.setDepartment(rs.getString("department"));
                d.setDesigWithId(rs.getString("desigWithId"));
                d.setSubmitedTo(rs.getString("submitedTo"));
                d.setSl(rs.getInt("sl"));
                d.setDescription(rs.getString("description"));
                d.setBrand(rs.getString("brand"));
                d.setModel(rs.getString("model"));
                d.setWeight(rs.getInt("weight"));
                d.setPcs(rs.getInt("pcs"));
                d.setPartsNo(rs.getInt("partsNo"));
                d.setLocation(rs.getString("location"));
                d.setStatus(rs.getString("status"));
                d.setRemarks(rs.getString("remarks"));
                demands.add(d);
            }
            rs.close();
            pst.close();
            con.close();            
        }catch (Exception ex){
            ex.printStackTrace();
        }
        return demands;
    }

    
    
    @Override
    public DemandBean getDemandBean(int ddn_no){
        
        bean = new DemandBean();
        try{
            con = DBconnection.getConnection();
            if(con == null){
                return bean;
            }
            String sql = " select * from demand_note d where d.ddn_no="+ddn_no+" ";
            pst = con.prepareStatement(sql);
            rs = pst.executeQuery();
            while(rs.next()){
                bean.setDmndID(rs.getInt("dmndID"));
                bean.setDdn_no(rs.getInt("ddn_no"));
                bean.setDemandDate(rs.getString("demandDate"));
                bean.setDepartment(rs.getString("department"));
                bean.setNameOfApplicant(rs.getString("nameOfApplicant"));
                bean.setDesigWithId(rs.getString("desigWithId"));
                bean.setSubmitedTo(rs.getString("submitedTo"));
            }
            rs.close();
            pst.close();
            con.close();
        }catch(Exception e){
            e.printStackTrace();
        }
        return bean;
    }

    
    
    
    @Override
    public int addDescription(String desc){        
        int i =0;        
        try{
            con = DBconnection.getConnection();
            if(con == null){
                return 0;
            }
            String sql = " INSERT INTO demand_description(description) VALUES(?) ";
            pst = con.prepareStatement(sql);
            pst.setString(1, desc);
            i = pst.executeUpdate();
            pst.close();
            con.close();
        }catch(Exception e){
            e.printStackTrace();
        }
        return i;
    }

    
    
    
    @Override
    public List<Demand> getAllDescription(){
        
        List<Demand> demands =new ArrayList<>();
        try{
            con = DBconnection.getConnection();
            if(con == null){
                return demands;
            }
            String sql =" SELECT * from demand_description";
            pst = con.prepareStatement(sql);
            rs = pst.executeQuery(sql);
            Demand d;
            while(rs.next())
            {
                d = new Demand();
                d.setSl(rs.getInt("sl"));
                d.setDescription(rs.getString("description"));
                demands.add(d);
            }
            rs.close();
            pst.close();
            con.close();            
        }catch (Exception ex){
            ex.printStackTrace();
        }
        return demands;
    }
    
    

    @Override
    public Demand getSingleDescription(int slNO)
    {
        Demand demand =new Demand();
        try{
            con = DBconnection.getConnection();
            if(con == null){
                return demand;
            }
            String sql =" SELECT sl, description from demand_description where sl=?";
            pst = con.prepareStatement(sql);
            pst.setInt(1, slNO);
            rs = pst.executeQuery();
            while(rs.next())
            {
                demand.setSl(rs.getInt("sl"));
                demand.setDescription(rs.getString("description"));
            }
            rs.close();
            pst.close();
            con.close();            
        }catch (Exception ex){
           ex.printStackTrace();
        }
        return demand;
    }
    
    
    /*
    
        public static void main(String[] args){
            DemandManagerImp dmi = new DemandManagerImp();
            System.out.println(dmi.getSingleDescription(4).getSl());
            System.out.println(dmi.getSingleDescription(4).getDescription());
        }
    
    */

    @Override
    public boolean updateDescription(int sl, String desc) {
        
        boolean b = false;        
        try{
            con = DBconnection.getConnection();
            if(con==null){return false;}
            String sql = " update demand_description dd set dd.description = ? where dd.sl = ? ";
            pst = con.prepareStatement(sql);
            pst.setString(1, desc);
            pst.setInt(2, sl);
            if(pst.executeUpdate()>0){b=true;}
            pst.close();
            con.close();   
        }catch (Exception e){
             e.printStackTrace();
        }
        return b;
    }

    @Override
    public List<DemandDesc> getAllDesc() {
        List<DemandDesc> list = new ArrayList<>();
        try{
            con = DBconnection.getConnection();
            if(con == null){
                return list;
            }
            String sql =" SELECT * from demand_description";
            pst = con.prepareStatement(sql);
            rs = pst.executeQuery(sql);
            DemandDesc d;
            while(rs.next())
            {
                d = new DemandDesc();
                d.setSl(rs.getInt("sl"));
                d.setDescription(rs.getString("description"));
                list.add(d);
            }
            rs.close();
            pst.close();
            con.close();            
        }catch (Exception ex){
            ex.printStackTrace();
        }
        return list;
    }
    
}
